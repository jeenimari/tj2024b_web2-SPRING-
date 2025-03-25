package example.day11.과제;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;


    //[1]
    @Scheduled(cron = "*/30 * * * * *") //3초마다 실행
    public void 재고감소(){
        System.out.println("재고감소 작동" + LocalTime.now());
        boolean result = taskMapper.재고감소();
        if(result){
            System.out.println("재고감소 3개 성공");
        }else {
            System.out.println("재고감소 실패");
        }

    }

    //[2]
    @Scheduled(cron = "0 */1 * * * *") //
    public void 모든제품조회(){
        System.out.println("모든제품조회 "+ LocalTime.now());
        List<HashMap<String,String>>제품목록 = new ArrayList<>();
        제품목록 = taskMapper.모든제품조회();
        System.out.println("제품목록");
        System.out.println("제품 id | 제품명 | 재고수량 ");
        System.out.println("=========================");

        for(HashMap<String,String>제품 : 제품목록){
            System.out.println(제품.toString());
            System.out.println("=======================");
        }
    }//f end

    //[3]
    @Scheduled(cron = "0 */5 * * * *")

    public void 재고추가(){
        System.out.println("재고추가" + LocalTime.now());
        boolean result = taskMapper.재고추가();
        if(result){
            System.out.println("5분마다 재고 10이하 상품 20가 추가");
        }else {
            System.out.println(">>재고추가실패");
        }
    }

}// class end
