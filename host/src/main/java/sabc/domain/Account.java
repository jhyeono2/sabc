package sabc.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import sabc.HostApplication;

@Entity
@Table(name = "Host_table")
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

    public static AccountRepository repository() {
        AccountRepository hostRepository = HostApplication.applicationContext.getBean(
            AccountRepository.class
        );
        return hostRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startAccountJob(Approved approved) {
        //implement business logic here:

        /** Example 1:  new item 
        Host host = new Host();
        repository().save(host);

        */

        /** Example 2:  finding and process
        
        repository().findById(approved.get???()).ifPresent(host->{
            
            host // do something
            repository().save(host);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
