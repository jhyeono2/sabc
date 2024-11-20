package sabc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import sabc.CenterApplication;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String acceptNo;

    private String customerId;

    private String customerName;

    private String tranType;

    private String documentImg;

    private String counterPartyId;

    private String counterPartyName;

    private String goodsName;

    private BigDecimal price;

    private Integer qty;

    private Date tradeDate;

    private String importCountry;

    private String exportCountry;

    private Integer branchNo;

    private String status;

    private String rejectMessage;

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = CenterApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }

    @PostUpdate
    public void onPostUpdate() {
        String status = this.getStatus();
        System.out.println("status after patch:"+status);
        switch (status) {
            case "firstConfirmed":
                FirstConfirmed firstConfirmed = new FirstConfirmed(this);
                firstConfirmed.publishAfterCommit();
                System.out.println("firstConfirm publish");
                break;
            case "rejected":
                Rejected rejected = new Rejected(this);
                rejected.publishAfterCommit();
                System.out.println("reject publish");
                break;
        }
    }

    //<<< Clean Arch / Port Method
    public static void regist(DocumentAccepted documentAccepted) {
        System.out.println("regist start");
        //implement business logic here:
        Review review = new Review();
        review.setId(documentAccepted.getId());
        review.setAcceptNo(documentAccepted.getAcceptNo());
        review.setBranchNo(documentAccepted.getBranchNo());
        review.setCustomerId(documentAccepted.getCustomerId());
        review.setCustomerName(documentAccepted.getCustomerName());
        review.setDocumentImg(documentAccepted.getDocumentImg());
        review.setTranType(documentAccepted.getTranType());
        review.setStatus(documentAccepted.getStatus());
        System.out.println(review.toString());
        repository().save(review);
        System.out.println("review data saved");
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void receive2ndResult(SecondRejected secondRejected) {
        System.out.println("receive secondRejected:" + secondRejected.getAcceptNo());
        Review review = repository().findById(secondRejected.getId()).orElseThrow();
        review.setStatus("secondRejected");
        repository().save(review);

        Rejected rejected = new Rejected(review);
        rejected.setMessage(secondRejected.getMessage());
        System.out.println("secondReject Message:"+rejected.getMessage());
        rejected.publishAfterCommit();
        System.out.println("rejected publish");
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void receive2ndResult(SecondConfirmed secondConfirmed) {
        System.out.println("receive secondConfirmed:" + secondConfirmed.getAcceptNo());
        Review review = repository().findById(secondConfirmed.getId()).orElseThrow();
        review.setStatus("secondConfirmed");
        repository().save(review);

        Approved approved = new Approved(review);
        approved.publishAfterCommit();
        System.out.println("approved publish");
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void receiveFinalResult(JobCompleted jobCompleted) {
        System.out.println("receive FinalResult jobCompleted");
        Review review = repository().findById(jobCompleted.getId()).orElseThrow();
        review.setStatus("finalConfirmed");
        repository().save(review);

        Completed completed = new Completed();
        completed.setId(jobCompleted.getId());
        completed.setAcceptNo(jobCompleted.getAcceptNo());
        completed.setStatus(jobCompleted.getStatus());
        completed.setMessage(jobCompleted.getMessage());
        completed.publishAfterCommit();
        System.out.println("publish confirmed");
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void receiveFinalResult(JobRejected jobRejected) {
        System.out.println("receive FinalResult jobRejected");
        Review review = repository().findById(jobRejected.getId()).orElseThrow();
        review.setStatus("finalRejected");
        repository().save(review);

        Rejected rejected = new Rejected();
        rejected.setId(jobRejected.getId());
        rejected.setAcceptNo(jobRejected.getAcceptNo());
        rejected.setStatus(jobRejected.getStatus());
        rejected.setMessage(jobRejected.getMessage());
        rejected.publishAfterCommit();
        System.out.println("publish reject");
    }

}
