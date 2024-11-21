package sabc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import sabc.domain.*;
import sabc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Completed extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String status;
    private String message;

    public Completed(Review aggregate) {
        super(aggregate);
    }

    public Completed() {
        super();
    }
}
//>>> DDD / Domain Event
