package example.day02._1RESTparam;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController    //1.bean 객체 등록 2.HTTP 서블릿지원
@RequestMapping("/day02")
public class RsetController3 {


    @GetMapping("/doget01")
    public void method1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("RsetController3.method1"); //soutm 자동완성 : 현재 함수명 출력함수        req.getParameter("name"); //요청 파라미터 받기
        //[1] 서블릿 방식의 쿼리스트링 받기
        String name = req.getParameter("name");
        System.out.println("name=" + name);// 가장 가까운 변수 출력함수 = " + name);

        //(2)서블릿 방식의 응답하기
        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().println("true");
    }// f end

    //[2]스프링 제공하는 방법
    //@RequestParam : HTTP Request(요청)의 URL 쿼리스트링 매개변수를 매핑하는 어노테이션
    //1.@RequestParam( name = "queryString 매개변수명") 타입 매개변수명
    //-> queryString 매개변수명 과 함수 매개변수명과 동일하면 @RequestParam 생략해도됨

    //2.(name = " name" , defaultValue = " 홍길동 " ) 타입 매개변수명
    //->만약에 queryString 매핑할 매개변수명이 존재하지 않으면 기본값 설정
    //3.(required = true)
    //-> 기본값이 true 하며 , 쿼리스트링 매개변수 필수 여부 설정, 만약에 쿼리스트링 매개변수가 없으면 400 bad Request 에러 응답

    @GetMapping("/doget2")
    public boolean method2(@RequestParam(name="name")String name){
        System.out.println("RestController3.method2");
        System.out.println("name"+name);
        return true;// ResponseBody 사용했을때 자동으로 response를 'application/json 타입으로 응답.
    }

    @GetMapping("/doget3") //+ 자동타입 변환이 가능함
    public int method3(@RequestParam(name="name")String name,
                       @RequestParam(name="age")int age) {

        System.out.println("RsetController3.method3"); // soutm = 메소드명을 자동완성함
        System.out.println("name = " + name + ", age = " + age); // soutp = 매개변수명 자동완성
        return 3;

    }

    @GetMapping("/doget4")
    public String method4(@RequestParam Map<String, String> map) { //여러개의 매개변수를 하나의 map으로 받을 수 있음
        System.out.println("RsetController3.method4");
        System.out.println("map = " + map);
        return "hello"; //리턴 아무거나 쓰삼
    }

    //[4]DTO 이용한 쿼리스트링 매개변수 매핑
    //+  ModelAttribute          vs        RequestParam
    //   생략가능( 기본값 )                  명시해야함
    //   개발자가 만든타입(DTO)                공식적 타입 만 지원 : 기본타입 + List,Map,String
   //    쿼리스트링 /form 첨부파일              쿼리스트링 지원

    //DTO 사용시 쿼리스트링 매개변수와 멤버변수 명이 동일함.
    @GetMapping("/doget5")
    public boolean method5( MemberDto memberDto){
        System.out.println("RsetController3.method5");
        System.out.println("memberDto = " + memberDto);
        return true; //아무거나
    }
}// c end
