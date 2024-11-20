package sabc.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import sabc.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import sabc.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler{
    @Autowired ReviewRepository reviewRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DocumentAccepted'")
    public void wheneverDocumentAccepted_Regist(@Payload DocumentAccepted documentAccepted){

        DocumentAccepted event = documentAccepted;
        System.out.println("\n\n##### listener Regist : " + documentAccepted + "\n\n");


        

        // Sample Logic //
        Review.regist(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='2ndRejected'")
    public void whenever2ndRejected_Receive2ndResult(@Payload 2ndRejected 2ndRejected){

        2ndRejected event = 2ndRejected;
        System.out.println("\n\n##### listener Receive2ndResult : " + 2ndRejected + "\n\n");


        

        // Sample Logic //
        Review.receive2ndResult(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='2ndConfirmed'")
    public void whenever2ndConfirmed_Receive2ndResult(@Payload 2ndConfirmed 2ndConfirmed){

        2ndConfirmed event = 2ndConfirmed;
        System.out.println("\n\n##### listener Receive2ndResult : " + 2ndConfirmed + "\n\n");


        

        // Sample Logic //
        Review.receive2ndResult(event);
        

        

    }

}

//>>> Clean Arch / Inbound Adaptor

