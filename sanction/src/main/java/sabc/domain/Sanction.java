package sabc.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import sabc.SanctionApplication;

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

    private String counterPartyName;

    private String customerId;

    private String customerName;

    private String counterPartyId;

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
