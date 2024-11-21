package sabc.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import sabc.config.kafka.KafkaProcessor;
import sabc.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    AcceptRepository acceptRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Comleted'"
    )
    public void wheneverComleted_Notify(@Payload Comleted comleted) {
        Comleted event = comleted;
        System.out.println("\n\n##### listener Notify : " + comleted + "\n\n");

        // Sample Logic //
        Accept.notify(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
