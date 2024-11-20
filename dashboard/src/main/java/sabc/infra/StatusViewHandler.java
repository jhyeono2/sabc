package sabc.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import sabc.config.kafka.KafkaProcessor;
import sabc.domain.*;

@Service
public class StatusViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private StatusRepository statusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDocumentAccepted_then_CREATE_1(
        @Payload DocumentAccepted documentAccepted
    ) {
        try {
            if (!documentAccepted.validate()) return;

            // view 객체 생성
            Status status = new Status();
            // view 객체에 이벤트의 Value 를 set 함
            status.setId(documentAccepted.getId());
            status.setAcceptNo(documentAccepted.getAcceptNo());
            status.setStatus(documentAccepted.getStatus());
            status.setBranchNo(documentAccepted.getBranchNo());
            status.setCustomerId(documentAccepted.getCustomerId());
            status.setCustomerName(documentAccepted.getCustomerName());
            // view 레파지 토리에 save
            statusRepository.save(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_UPDATE_1(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
            // view 객체 조회

            List<Status> statusList = statusRepository.findByAcceptNo(
                rejected.getAcceptNo()
            );
            for (Status status : statusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                status.setStatus(rejected.getStatus());
                // view 레파지 토리에 save
                statusRepository.save(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenApproved_then_UPDATE_2(@Payload Approved approved) {
        try {
            if (!approved.validate()) return;
            // view 객체 조회

            List<Status> statusList = statusRepository.findByAcceptNo(
                approved.getAcceptNo()
            );
            for (Status status : statusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                status.setStatus(approved.getStatus());
                // view 레파지 토리에 save
                statusRepository.save(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenJobCompleted_then_UPDATE_3(
        @Payload JobCompleted jobCompleted
    ) {
        try {
            if (!jobCompleted.validate()) return;
            // view 객체 조회

            List<Status> statusList = statusRepository.findByAcceptNo(
                jobCompleted.getAcceptNo()
            );
            for (Status status : statusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                status.setStatus(jobCompleted.getStatus());
                // view 레파지 토리에 save
                statusRepository.save(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenJobRejected_then_UPDATE_4(
        @Payload JobRejected jobRejected
    ) {
        try {
            if (!jobRejected.validate()) return;
            // view 객체 조회

            List<Status> statusList = statusRepository.findByAcceptNo(
                jobRejected.getAcceptNo()
            );
            for (Status status : statusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                status.setStatus(jobRejected.getStatus());
                // view 레파지 토리에 save
                statusRepository.save(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_DELETE_1(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
