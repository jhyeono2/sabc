package sabc.domain;

import java.util.*;
import lombok.*;
import sabc.domain.*;
import sabc.infra.AbstractEvent;

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
}
