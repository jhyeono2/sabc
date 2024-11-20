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
    public static void notify(Comleted comleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Accept accept = new Accept();
        repository().save(accept);

        */

        /** Example 2:  finding and process
        
        repository().findById(comleted.get???()).ifPresent(accept->{
            
            accept // do something
            repository().save(accept);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
