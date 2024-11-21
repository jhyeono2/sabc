package sabc.domain;

import lombok.*;
import sabc.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
@EqualsAndHashCode(callSuper=false)  // 부모 클래스의 equals()와 hashCode()를 호출하지 않도록 설정
public class DocumentAccepted extends AbstractEvent {

    private Long id;
    private String customerId;
    private String customerName;
    private String tranType;
    private String documentImg;
    private String acceptNo;
    private String status;
    private Integer branchNo;

    public DocumentAccepted() {
        super();
    }
}
//>>> DDD / Domain Event
