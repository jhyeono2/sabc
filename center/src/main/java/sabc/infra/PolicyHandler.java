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
    ReviewRepository reviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DocumentAccepted'"
    )
    public void wheneverDocumentAccepted_Regist(
        @Payload DocumentAccepted documentAccepted
    ) {
        DocumentAccepted event = documentAccepted;
        System.out.println(
            "\n\n##### listener Regist : " + documentAccepted + "\n\n"
        );

        // Sample Logic //
        Review.regist(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SecondRejected'"
    )
    public void wheneverSecondRejected_Receive2ndResult(
        @Payload SecondRejected secondRejected
    ) {
        SecondRejected event = secondRejected;
        System.out.println(
            "\n\n##### listener Receive2ndResult : " + secondRejected + "\n\n"
        );

        // Sample Logic //
        Review.receive2ndResult(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SecondConfirmed'"
    )
    public void wheneverSecondConfirmed_Receive2ndResult(
        @Payload SecondConfirmed secondConfirmed
    ) {
        SecondConfirmed event = secondConfirmed;
        System.out.println(
            "\n\n##### listener Receive2ndResult : " + secondConfirmed + "\n\n"
        );

        // Sample Logic //
        Review.receive2ndResult(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
