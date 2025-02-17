package example.day01._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller//해당 클래스는 controller 임을 알림(어노테이션 기능 주입)
//1.해당클래스는 Spring 컨테이너(메모리 ) bean(객체)등록함.
//2.Spring Controller는 기본적으로 HTTP 서블릿 지원함 ( 별도로 extend 상속받지않음)

public class RestController1 {



    //[1]RequestMapping :
    //-1.value 속성에 매핑할 HTTP 주소 정의함 . *http://localhost:8080/ 프로젝트명을 쓰지않음 jsp에서는 사용함
    //-2. method = RequestMethod.POST/GET/PUT/DELETE 선택해서 사용
    @RequestMapping(value = "/day01/doget",method = RequestMethod.GET)
    public void doGet(){
        System.out.println("day01 doGet executed");
    }

    //[2]
    @RequestMapping(value = "/day01/dopost",method = RequestMethod.POST)
    public void doPost(){
        System.out.println("day01 doPost executed");
    }

    //[3]
    @RequestMapping(value = "/day01/doput",method = RequestMethod.PUT)
    public void doPut(){
        System.out.println("day01 doPut executed");
    }

    //[4]
    @RequestMapping(value = "/day01/dodelete",method = RequestMethod.DELETE)
    public void doDelete(){
        System.out.println("day01 doDelete executed");
    }
    //[1-1]
    @GetMapping("/day01/doget2")
    public void doGet2(){
        System.out.println("day01 doGet2 executed");
    }


    //[2-1]
    @PostMapping("/day01/dopost2")
    public void doPost2(){
        System.out.println("day01 doPost2 executed");
    }

    //[3-1]
    @PutMapping("/day01/doput2")
    public void doPut2(){
        System.out.println("day01 doPut2 executed");
    }

    //[4-1]
    @DeleteMapping("/day01/dodelete2")
    public void doDelete2(){
        System.out.println("day01 doDelete2 executed");
    }
}//class end
