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
public class DashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashboardRepository statusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDocumentAccepted_then_CREATE_1(
        @Payload DocumentAccepted documentAccepted
    ) {
        try {
            System.out.println("##############whenDocumentAccepted_then_CREATE_1");
            if (!documentAccepted.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setId(documentAccepted.getId());
            dashboard.setAcceptNo(documentAccepted.getAcceptNo());
            dashboard.setStatus(documentAccepted.getStatus());
            dashboard.setBranchNo(documentAccepted.getBranchNo());
            dashboard.setCustomerId(documentAccepted.getCustomerId());
            dashboard.setCustomerName(documentAccepted.getCustomerName());
            // view 레파지 토리에 save
            statusRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_UPDATE_1(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = statusRepository.findByAcceptNo(
                rejected.getAcceptNo()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(rejected.getStatus());
                // view 레파지 토리에 save
                statusRepository.save(dashboard);
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

            List<Dashboard> dashboardList = statusRepository.findByAcceptNo(
                approved.getAcceptNo()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(approved.getStatus());
                // view 레파지 토리에 save
                statusRepository.save(dashboard);
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

            List<Dashboard> statusList = statusRepository.findByAcceptNo(
                jobCompleted.getAcceptNo()
            );
            for (Dashboard status : statusList) {
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

            List<Dashboard> statusList = statusRepository.findByAcceptNo(
                jobRejected.getAcceptNo()
            );
            for (Dashboard status : statusList) {
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
