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
    @Autowired SanctionRepository sanctionRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='1stConfirmed'")
    public void whenever1stConfirmed_StartScreening(@Payload 1stConfirmed 1stConfirmed){

        1stConfirmed event = 1stConfirmed;
        System.out.println("\n\n##### listener StartScreening : " + 1stConfirmed + "\n\n");


        

        // Sample Logic //
        Sanction.startScreening(event);
        

        

    }

}

//>>> Clean Arch / Inbound Adaptor

