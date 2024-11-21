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
        System.out.println("startScreening");
        //implement business logic here:

        Sanction sanction = new Sanction();
        sanction.setId(firstConfirmed.getId());
        sanction.setAcceptNo(firstConfirmed.getAcceptNo());
        sanction.setCustomerId(firstConfirmed.getCustomerId());
        sanction.setCustomerName(firstConfirmed.getCustomerName());
        sanction.setCounterPartyId(firstConfirmed.getCounterPartyId());
        sanction.setCounterPartyName(firstConfirmed.getCounterPartyName());
        sanction.setImportCountry(firstConfirmed.getImportCountry());
        sanction.setExportCountry(firstConfirmed.getExportCountry());
        
        System.out.println("sanction save:"+sanction.toString());
        
        if("KIMJEONGEUN".equals(sanction.getCounterPartyName())){
            System.out.println("secondRejected");
            sanction.setStatus("secondRejected");
            repository().save(sanction);
            SecondRejected secondRejected = new SecondRejected();
            secondRejected.setId(sanction.getId());
            secondRejected.setAcceptNo(sanction.getAcceptNo());
            secondRejected.setStatus("secondRejected");
            secondRejected.setMessage("KIMJEONGEUN cannot confirmed");
            secondRejected.publishAfterCommit();
            System.out.println("secondReject publish");
        }else{
            System.out.println("secondConfirmed");
            sanction.setStatus("secondConfirmed");
            repository().save(sanction);
            SecondConfirmed secondConfirmed = new SecondConfirmed();
            secondConfirmed.setId(sanction.getId());
            secondConfirmed.setAcceptNo(sanction.getAcceptNo());
            secondConfirmed.setStatus("confirmed");
            secondConfirmed.setMessage("confirmed");
            secondConfirmed.publishAfterCommit();
            System.out.println("secondConfirmed publish");
        }
    }
    //>>> Clean Arch / Port Method
}
//>>> DDD / Aggregate Root
