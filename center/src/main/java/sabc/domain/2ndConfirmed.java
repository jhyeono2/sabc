package sabc.domain;

import sabc.domain.*;
import sabc.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class 2ndConfirmed extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String status;
}


