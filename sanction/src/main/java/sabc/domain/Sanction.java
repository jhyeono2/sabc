package sabc.domain;

import sabc.domain.2ndConfirmed;
import sabc.domain.2ndRejected;
import sabc.SanctionApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Sanction_table")
@Data

//<<< DDD / Aggregate Root
public class Sanction  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
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
    public void onPostPersist(){


        2ndConfirmed 2ndConfirmed = new 2ndConfirmed(this);
        2ndConfirmed.publishAfterCommit();



        2ndRejected 2ndRejected = new 2ndRejected(this);
        2ndRejected.publishAfterCommit();

    
    }

    public static SanctionRepository repository(){
        SanctionRepository sanctionRepository = SanctionApplication.applicationContext.getBean(SanctionRepository.class);
        return sanctionRepository;
    }




//<<< Clean Arch / Port Method
    public static void startScreening(1stConfirmed 1stConfirmed){
        
        //implement business logic here:

        /** Example 1:  new item 
        Sanction sanction = new Sanction();
        repository().save(sanction);

        */

        /** Example 2:  finding and process
        
        repository().findById(1stConfirmed.get???()).ifPresent(sanction->{
            
            sanction // do something
            repository().save(sanction);


         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
