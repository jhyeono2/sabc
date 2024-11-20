package sabc.domain;

import sabc.domain.1stConfirmed;
import sabc.domain.Rejected;
import sabc.domain.Approved;
import sabc.CenterApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name="Review_table")
@Data

//<<< DDD / Aggregate Root
public class Review  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
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
    public void onPostPersist(){


        1stConfirmed 1stConfirmed = new 1stConfirmed(this);
        1stConfirmed.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        Approved approved = new Approved(this);
        approved.publishAfterCommit();

    
    }

    public static ReviewRepository repository(){
        ReviewRepository reviewRepository = CenterApplication.applicationContext.getBean(ReviewRepository.class);
        return reviewRepository;
    }




//<<< Clean Arch / Port Method
    public static void regist(DocumentAccepted documentAccepted){
        
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
    public static void receive2ndResult(2ndRejected 2ndRejected){
        
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
        
        repository().findById(2ndRejected.get???()).ifPresent(review->{
            
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
    public static void receive2ndResult(2ndConfirmed 2ndConfirmed){
        
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
        
        repository().findById(2ndConfirmed.get???()).ifPresent(review->{
            
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
