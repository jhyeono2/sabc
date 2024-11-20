package sabc.domain;

import javax.persistence.*;
import lombok.Data;
import sabc.BranchApplication;

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

    public static AcceptRepository repository() {
        AcceptRepository acceptRepository = BranchApplication.applicationContext.getBean(
            AcceptRepository.class
        );
        return acceptRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notify(JobCompleted jobCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Accept accept = new Accept();
        repository().save(accept);

        */

        /** Example 2:  finding and process
        
        repository().findById(jobCompleted.get???()).ifPresent(accept->{
            
            accept // do something
            repository().save(accept);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notify(JobRejected jobRejected) {
        //implement business logic here:

        /** Example 1:  new item 
        Accept accept = new Accept();
        repository().save(accept);

        */

        /** Example 2:  finding and process
        
        repository().findById(jobRejected.get???()).ifPresent(accept->{
            
            accept // do something
            repository().save(accept);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
