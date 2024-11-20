package sabc.domain;

import lombok.*;
import sabc.infra.AbstractEvent;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)  // 부모 클래스의 equals()와 hashCode()를 호출하지 않도록 설정
public class JobRejected extends AbstractEvent {

    private Long id;
    private String acceptNo;
    private String status;
}
