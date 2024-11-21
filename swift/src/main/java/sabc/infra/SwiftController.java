package sabc.infra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwiftController {
    
    @GetMapping("/swift")
    public String getSwift(){
        return "swift";
    }
}
