package sabc.infra;

import javax.transaction.Transactional;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import sabc.config.kafka.KafkaProcessor;
import sabc.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='JobCompleted'"
    )
    public void wheneverJobCompleted_Notify(
        @Payload JobCompleted jobCompleted
    ) {
        JobCompleted event = jobCompleted;
        System.out.println(
            "\n\n##### listener Notify : " + jobCompleted + "\n\n"
        );

        // Sample Logic //
        Accept.notify(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='JobRejected'"
    )
    public void wheneverJobRejected_Notify(@Payload JobRejected jobRejected) {
        JobRejected event = jobRejected;
        System.out.println(
            "\n\n##### listener Notify : " + jobRejected + "\n\n"
        );

        // Sample Logic //
        Accept.notify(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
