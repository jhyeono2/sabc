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
    private String userId;
    private String userName;
    private String importCountry;
    private String exportCountry;
    private String importCountry;
    private String exportCountry;
    private String counterPartyName;
    private String counterPartyId;
    private String status;
}
