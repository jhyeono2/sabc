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
}
//>>> Clean Arch / Inbound Adaptor
