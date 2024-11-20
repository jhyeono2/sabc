package sabc.domain;

import java.math.BigDecimal;
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

    private BigDecimal price;

    private int qty;

    private String importCountry;

    private String exportCountry;

    private int branchNo;

    public static AccountRepository repository() {
        AccountRepository hostRepository = HostApplication.applicationContext.getBean(
            AccountRepository.class
        );
        return hostRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startAccountJob(Approved approved) {
        //implement business logic here:
        Account account = new Account();
        account.setAcceptNo(approved.getAcceptNo());
        account.setBranchNo(approved.getBranchNo());
        account.setCustomerId(approved.getCustomerId());
        account.setCustomerName(approved.getCustomerName());
        account.setTranType(approved.getTranType());
        account.setCounterPartyId(approved.getCounterPartyId());
        account.setCounterPartyName(approved.getCounterPartyName());
        account.setImportCountry(approved.getImportCountry());
        account.setExportCountry(approved.getExportCountry());
        account.setGoodsName(approved.getGoodsName());
        account.setPrice(approved.getPrice());
        account.setQty(approved.getQty());
        
        if(account.getPrice().compareTo(new BigDecimal("10000")) < 0){
            account.setStatus("finalConfirmed");
            repository().save(account);
            
            JobCompleted jobCompleted = new JobCompleted();
            jobCompleted.setAcceptNo(account.getAcceptNo());
            jobCompleted.setStatus("confimed");
            jobCompleted.setResultMessage("confimed");
            jobCompleted.publishAfterCommit();
        }else{
            account.setStatus("finalRejected");
            repository().save(account);

            JobRejected jobRejected = new JobRejected();
            jobRejected.setAcceptNo(account.getAcceptNo());
            jobRejected.setStatus(account.getStatus());
            jobRejected.setResultMessage("10000불 이상은 거래불가");
            jobRejected.publishAfterCommit();
        }
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
