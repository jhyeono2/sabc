package sabc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import sabc.infra.AbstractEvent;

@Data
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
