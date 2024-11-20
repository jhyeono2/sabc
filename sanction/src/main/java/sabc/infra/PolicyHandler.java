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
    SanctionRepository sanctionRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FirstConfirmed'"
    )
    public void wheneverFirstConfirmed_StartScreening(
        @Payload FirstConfirmed firstConfirmed
    ) {
        FirstConfirmed event = firstConfirmed;
        System.out.println(
            "\n\n##### listener StartScreening : " + firstConfirmed + "\n\n"
        );

        // Sample Logic //
        Sanction.startScreening(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
