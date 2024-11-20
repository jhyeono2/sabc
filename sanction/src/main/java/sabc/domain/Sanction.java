package sabc.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import sabc.SanctionApplication;
import sabc.domain.SecondConfirmed;
import sabc.domain.SecondRejected;

@Entity
@Table(name = "Sanction_table")
@Data
//<<< DDD / Aggregate Root
public class Sanction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String acceptNo;

    private String status;

    private String importCountry;

    private String exportCountry;

    private String counterpartyName;

    private String userId;

    private String userName;

    private String counterpartyId;

    @PostPersist
    public void onPostPersist() {
        SecondConfirmed secondConfirmed = new SecondConfirmed(this);
        secondConfirmed.publishAfterCommit();

        SecondRejected secondRejected = new SecondRejected(this);
        secondRejected.publishAfterCommit();
    }

    public static SanctionRepository repository() {
        SanctionRepository sanctionRepository = SanctionApplication.applicationContext.getBean(
            SanctionRepository.class
        );
        return sanctionRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startScreening(FirstConfirmed firstConfirmed) {
        //implement business logic here:

        /** Example 1:  new item 
        Sanction sanction = new Sanction();
        repository().save(sanction);

        */

        /** Example 2:  finding and process
        
        repository().findById(firstConfirmed.get???()).ifPresent(sanction->{
            
            sanction // do something
            repository().save(sanction);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
