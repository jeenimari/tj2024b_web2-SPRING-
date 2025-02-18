package example.day02._1RESTparam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/day02")
public class RestController4 {

    //[1]HTTP request(요처 )body(본문)매핑하는 방법 body 는 post/ Put 만 지원( 관례)
    @PostMapping("/dopost1")
    public boolean method1(@RequestBody MemberDto memberDto) {
        System.out.println("RestController4.method1");
        System.out.println("memberDto = " + memberDto);
        return true;

    }

    @PostMapping("/dopost2")
    public boolean method2(@RequestBody Map<String,String>map) {
        System.out.println("RestController4.method2");
        System.out.println("map = " + map);
        return true;
    }
}
