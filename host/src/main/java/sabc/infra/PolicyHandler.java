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

@Service
@Transactional
public class PolicyHandler {

    @Autowired

    AccountRepository accountRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Approved'"
    )
    public void wheneverApproved_StartAccountJob(@Payload Approved approved) {
        Approved event = approved;
        System.out.println(
            "\n\n##### listener StartAccountJob : " + approved + "\n\n"
        );

        // Sample Logic //
        Account.startAccountJob(event);
    }
}

