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
    private String userId;
    private String userName;
    private String tranType;
    private String documentImg;

    public Approved(Review aggregate) {
        super(aggregate);
    }

    public Approved() {
        super();
    }
}
//>>> DDD / Domain Event
