package example.day13;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/day13/users")
@RequiredArgsConstructor
public class TranController {

    private final TranService tranService;

    @PostMapping("")
    public boolean tran() {
        tranService.tran();
        return true;
    }

    //(2)
    @PostMapping("/transfer")
    public boolean transfer(@RequestBody Map<String, String> params) {
        try {
            tranService.transfer(params);
            return true;
        } catch (Exception e) {
            return false;
        }


}


}
