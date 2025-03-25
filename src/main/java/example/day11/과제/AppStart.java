package example.day11.과제;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
        System.out.println("===================================================");
        System.out.println("        자동 재고 관리 시스템이 시작되었습니다        ");
        System.out.println("===================================================");
        System.out.println("- 30초마다 모든 제품의 재고는 3개씩 감소합니다.");
        System.out.println("- 1분마다 모든 제품 정보를 조회하여 console에 출력합니다.");
        System.out.println("- 5분마다 재고가 10 이하인 상품의 재고를 20개 추가합니다.");
        System.out.println("===================================================");



    }
}
