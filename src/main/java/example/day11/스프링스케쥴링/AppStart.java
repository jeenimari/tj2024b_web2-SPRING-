package example.day11.스프링스케쥴링;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }

}
