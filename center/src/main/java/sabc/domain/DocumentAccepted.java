package sabc.domain;

import java.util.*;
import lombok.*;
import sabc.domain.*;
import sabc.infra.AbstractEvent;

@Data
@ToString
public class DocumentAccepted extends AbstractEvent {

    private Long id;
    private String customerId;
    private String customerName;
    private String tranType;
    private String documentImg;
    private String acceptNo;
    private String status;
    private Integer branchNo;
}
