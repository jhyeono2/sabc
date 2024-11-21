package sabc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import sabc.infra.AbstractEvent;

@Data
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
    private String message;
}
