package sabc.domain;

import java.util.*;
import lombok.*;
import sabc.domain.*;
import sabc.infra.AbstractEvent;

@Data
@ToString
public class SecondRejected extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String status;
    private String message;
}
