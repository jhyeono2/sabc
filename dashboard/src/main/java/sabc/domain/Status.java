package sabc.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Status_table")
@Data
public class Status {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String acceptNo;
    private String userId;
    private String userName;
    private String status;
    private Integer branchNo;
}
