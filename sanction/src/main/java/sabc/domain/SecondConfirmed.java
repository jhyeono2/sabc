package sabc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import sabc.domain.*;
import sabc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SecondConfirmed extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String status;

    public SecondConfirmed(Sanction aggregate) {
        super(aggregate);
    }

    public SecondConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
