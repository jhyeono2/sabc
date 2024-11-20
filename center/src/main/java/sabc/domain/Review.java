package sabc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import sabc.CenterApplication;
import sabc.domain.Approved;
import sabc.domain.FirstConfirmed;
import sabc.domain.Rejected;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String acceptNo;

    private String userId;

    private String userName;

    private String tranType;

    private String documentImg;

    private String counterPartyId;

    private String counterPartyName;

    private String goodsName;

    private BigDecimal price;

    private Integer qty;

    private Date tradeDate;

    private String importCountry;

    private String exportCountry;

    private Integer branchNo;

    private String status;

    @PostPersist
    public void onPostPersist() {
        FirstConfirmed firstConfirmed = new FirstConfirmed(this);
        firstConfirmed.publishAfterCommit();

        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();

        Approved approved = new Approved(this);
        approved.publishAfterCommit();
    }

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = CenterApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }

    //<<< Clean Arch / Port Method
    public static void regist(DocumentAccepted documentAccepted) {
        //implement business logic here:

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        */

        /** Example 2:  finding and process
        
        repository().findById(documentAccepted.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void receive2ndResult(SecondRejected secondRejected) {
        //implement business logic here:

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        Approved approved = new Approved(review);
        approved.publishAfterCommit();
        Rejected rejected = new Rejected(review);
        rejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(secondRejected.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);

            Approved approved = new Approved(review);
            approved.publishAfterCommit();
            Rejected rejected = new Rejected(review);
            rejected.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void receive2ndResult(SecondConfirmed secondConfirmed) {
        //implement business logic here:

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        Approved approved = new Approved(review);
        approved.publishAfterCommit();
        Rejected rejected = new Rejected(review);
        rejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(secondConfirmed.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);

            Approved approved = new Approved(review);
            approved.publishAfterCommit();
            Rejected rejected = new Rejected(review);
            rejected.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
