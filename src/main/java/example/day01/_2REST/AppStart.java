package example.day01._2REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//1.@SpringBootApplication: @Configuration 어노테이션 포함하며 , Spring 컨테이너(메모리)에 bean(객체)설정을 등록할 수 있도록 도와주는 어노테이션
//2.@EnableAutoConfiguration: 스프링부트가 자동으로 필요한 bean객체 설정
//웹서버인 내장형 'tomcat'을 설정한다.
//3.@ComponentScan
    //현재클래스 기준으로 동일한 패키지 및 하위 패키지를 자동으로 스캔한다.
    //스캔대상 : Spring 컨테이터(메모리)에 등록할 대상 bean(객체)
    //스캔 어노테이션 : @component, @Service, @Repository, @Controller, @RestController 등등 MVC 어노테이션
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
        //1.Spring 컨테이너(메모리) 초기화
        //2.자동 설정이 적용
        //3. 내장형 웹서버( 톰캣) 실행됨
    }

} //class end
