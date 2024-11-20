package sabc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import sabc.domain.*;
import sabc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DocumentAccepted extends AbstractEvent {

    private Long id;
    private String userId;
    private String userName;
    private String tranType;
    private String documentImg;
    private String acceptNo;
    private String status;
    private Integer branchNo;

    public DocumentAccepted(Accept aggregate) {
        super(aggregate);
    }

    public DocumentAccepted() {
        super();
    }
}
//>>> DDD / Domain Event
