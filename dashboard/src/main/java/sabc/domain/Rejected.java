package sabc.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import sabc.infra.AbstractEvent;

@Data
public class Rejected extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String status;
}
