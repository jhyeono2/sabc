package sabc.domain;

import sabc.domain.*;
import sabc.infra.AbstractEvent;
import java.util.*;
import lombok.*;
import java.time.LocalDate;


//<<< DDD / Domain Event
@Data
@ToString
public class 2ndRejected extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String status;

    public 2ndRejected(Sanction aggregate){
        super(aggregate);
    }
    public 2ndRejected(){
        super();
    }
}
//>>> DDD / Domain Event