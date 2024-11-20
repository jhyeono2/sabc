package sabc.domain;

import sabc.domain.*;
import sabc.infra.AbstractEvent;
import java.util.*;
import lombok.*;
import java.time.LocalDate;


//<<< DDD / Domain Event
@Data
@ToString
public class 1stConfirmed extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String userId;
    private String userName;
    private String importCountry;
    private String exportCountry;
    private String importCountry;
    private String exportCountry;
    private String counterPartyName;
    private String counterPartyId;
    private String status;

    public 1stConfirmed(Review aggregate){
        super(aggregate);
    }
    public 1stConfirmed(){
        super();
    }
}
//>>> DDD / Domain Event