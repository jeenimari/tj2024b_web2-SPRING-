package example.day03.mv2_3tire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//현재 클래스와 동일 패키지와 하위패키지들의 컴포넌트 들을 스캔한다
//컴포넌트(모듈/레고조각)란? MVC패턴의 계층 클래스들
//@Component 또는: RestController @controller @Service @Repository @configuration

public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);

    }
}
