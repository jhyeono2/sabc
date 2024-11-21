package sabc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import sabc.infra.AbstractEvent;

@Data
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
}
