package sabc.domain;

import javax.persistence.*;
import lombok.Data;
import sabc.BranchApplication;
import sabc.domain.DocumentAccepted;

@Entity
@Table(name = "Accept_table")
@Data
//<<< DDD / Aggregate Root
public class Accept {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String customerName;

    private String tranType;

    private String documentImg;

    private String acceptNo;

    private String status;

    private Integer branchNo;

    @PostPersist
    public void onPostPersist() {
        DocumentAccepted documentAccepted = new DocumentAccepted(this);
        documentAccepted.publishAfterCommit();
    }

    public static AcceptRepository repository() {
        AcceptRepository acceptRepository = BranchApplication.applicationContext.getBean(
            AcceptRepository.class
        );
        return acceptRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notify(Completed completed) {
        System.out.println("account notify :" + completed.getAcceptNo() + " status :" + completed.getStatus());
        Accept accept = repository().findById(completed.getId()).orElseThrow();
        accept.setStatus(completed.getStatus());
        repository().save(accept);
    }
}
//>>> DDD / Aggregate Root
