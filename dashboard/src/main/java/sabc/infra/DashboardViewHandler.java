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
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDocumentAccepted_then_CREATE_1(
        @Payload DocumentAccepted documentAccepted
    ) {
        try {
            System.out.println("##############whenDocumentAccepted_then_CREATE");
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
            dashboardRepository.save(dashboard);
            System.out.println("saved:"+dashboard.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_UPDATE_1(@Payload Rejected rejected) {
        try {
            System.out.println("##############whenRejected_then_UPDATE_1");

            if (!rejected.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByAcceptNo(
                rejected.getAcceptNo()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(rejected.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenApproved_then_UPDATE_2(@Payload Approved approved) {
        try {
            System.out.println("##############whenApproved_then_UPDATE_2");

            if (!approved.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByAcceptNo(
                approved.getAcceptNo()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(approved.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
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
            System.out.println("##############whenJobCompleted_then_UPDATE_3");

            if (!jobCompleted.validate()) return;
            // view 객체 조회

            List<Dashboard> statusList = dashboardRepository.findByAcceptNo(
                jobCompleted.getAcceptNo()
            );
            for (Dashboard status : statusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                status.setStatus(jobCompleted.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(status);
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
            System.out.println("##############whenJobRejected_then_UPDATE_4");

            if (!jobRejected.validate()) return;
            // view 객체 조회

            List<Dashboard> statusList = dashboardRepository.findByAcceptNo(
                jobRejected.getAcceptNo()
            );
            for (Dashboard status : statusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                status.setStatus(jobRejected.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFirstConfirmed_then_UPDATE_5(
        @Payload FirstConfirmed firstConfirmed
    ) {
        try {
            System.out.println("########firstConfirmed"+ firstConfirmed.toString());
            if (!firstConfirmed.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByAcceptNo(
                firstConfirmed.getAcceptNo()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(firstConfirmed.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSecondConfirmed_then_UPDATE_6(
        @Payload SecondConfirmed secondConfirmed
    ) {
        try {
            System.out.println("############secondConfirmed:"+secondConfirmed.toString());
            if (!secondConfirmed.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByAcceptNo(
                secondConfirmed.getAcceptNo()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(secondConfirmed.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSecondRejected_then_UPDATE_7(
        @Payload SecondRejected secondRejected
    ) {
        try {
            System.out.println("############whenSecondRejected_then_UPDATE_7:"+secondRejected.toString());

            if (!secondRejected.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByAcceptNo(
                secondRejected.getAcceptNo()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(secondRejected.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
