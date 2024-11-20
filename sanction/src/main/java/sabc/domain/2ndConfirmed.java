package sabc.domain;

import sabc.domain.*;
import sabc.infra.AbstractEvent;
import java.util.*;
import lombok.*;
import java.time.LocalDate;


//<<< DDD / Domain Event
@Data
@ToString
public class 2ndConfirmed extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String status;

    public 2ndConfirmed(Sanction aggregate){
        super(aggregate);
    }
    public 2ndConfirmed(){
        super();
    }
}
//>>> DDD / Domain Event