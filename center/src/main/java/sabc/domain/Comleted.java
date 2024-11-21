package sabc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import sabc.domain.*;
import sabc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Comleted extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String status;
    private String message;

    public Comleted(Review aggregate) {
        super(aggregate);
    }

    public Comleted() {
        super();
    }
}
//>>> DDD / Domain Event
