package sabc.infra;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sabc.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/accepts")
@Transactional
public class AcceptController {

    @Autowired
    AcceptRepository acceptRepository;

    @GetMapping("/actuator/health")
    public String health() {
        // 의도적으로 500 오류 반환
        System.out.println("#########error");
        throw new RuntimeException("Intentional failure for livenessProbe test");
    }
}
//>>> Clean Arch / Inbound Adaptor
