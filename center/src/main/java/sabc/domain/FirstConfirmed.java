package sabc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import sabc.domain.*;
import sabc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FirstConfirmed extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String customerId;
    private String customerName;
    private String importCountry;
    private String exportCountry;
    private String counterPartyName;
    private String counterPartyId;
    private String status;

    public FirstConfirmed(Review aggregate) {
        super(aggregate);
    }

    public FirstConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
