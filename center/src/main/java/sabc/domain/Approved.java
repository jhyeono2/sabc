package sabc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import lombok.*;
import sabc.domain.*;
import sabc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Approved extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String counterPartyId;
    private String counterPartyName;
    private String goodsName;
    private BigDecimal price;
    private Integer qty;
    private Date tradeDate;
    private String importCountry;
    private String exportCountry;
    private Integer branchNo;
    private String status;
    private String customerId;
    private String customerName;
    private String tranType;
    private String documentImg;
    private String message;

    public Approved(Review aggregate) {
        super(aggregate);
    }

    public Approved() {
        super();
    }
}
//>>> DDD / Domain Event
