package example.day01._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller// 1.bean(객체) 등록 .2HTTP 서블릿 지원

public class RestController2 {





    //[1] @ResponseBody
        //-메소드의 반환(return)값 HTTP 응답 본문(Body)으로 application/json으로 응답 자동으로 변환.
        //int-> application/json;
    //String-> text/plain; *String만 text/ plain전송하고 모든 객체들은 application/json 형태로 변환.


    // 2 @ResponseBody + @ Controller =>@ResetController
    // 동적페이지(화면,view,html) 반환할때는 @controller
    //-REST(값,application/json) 반환할때는 @RestController


    @GetMapping("/day01/doget3")
    @ResponseBody //자동으로 함수 return 값을 HTTP Response 값을 application/json 응답
    public int doGet3() {
        return 100;
    }
    @GetMapping("/day01/doget4")
    @ResponseBody // 현재 클래스가 @RestController 이면 생략가능하다.
    public String doGet4() {
        return "Hello World!";
    }

    @GetMapping("day01/doget5")
    @ResponseBody
    public Map<String,String>doGet5(){
        Map<String,String> map = new HashMap<>();
        map.put("name","강호동");
        return map;
    }

    @GetMapping("day01/doget6")
    @ResponseBody
    public boolean doGet6(){return true;  }


}// class end
