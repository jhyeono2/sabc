package sabc.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import sabc.HostApplication;
import sabc.domain.JobCompleted;
import sabc.domain.JobRejected;

@Entity
@Table(name = "Account_table")
@Data
//<<< DDD / Aggregate Root
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String acceptNo;

    private String status;

    private String customerId;

    private String customerName;

    private String tranType;

    private String counterPartyId;

    private String counterPartyName;

    private String goodsName;

    private String price;

    private String qty;

    private String importCountry;

    private String exportCountry;

    private String branchNo;

    private String message;

    @PostPersist
    public void onPostPersist() {
        JobCompleted jobCompleted = new JobCompleted(this);
        jobCompleted.publishAfterCommit();

        JobRejected jobRejected = new JobRejected(this);
        jobRejected.publishAfterCommit();
    }

    public static AccountRepository repository() {
        AccountRepository accountRepository = HostApplication.applicationContext.getBean(
            AccountRepository.class
        );
        return accountRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startAccountJob(Approved approved) {
        //implement business logic here:

        /** Example 1:  new item 
        Account account = new Account();
        repository().save(account);

        */

        /** Example 2:  finding and process
        
        repository().findById(approved.get???()).ifPresent(account->{
            
            account // do something
            repository().save(account);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
