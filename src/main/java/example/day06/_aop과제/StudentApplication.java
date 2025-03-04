package example.day06._aop과제;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    // AOP 구현 클래스 - 패키지명 수정 및 포인트컷 정확하게 지정
    @Aspect
    @Component
    static class StudentAspect {

        // 조건 2: 매개변수 출력/로그 처리 - 모든 컨트롤러 메소드에 적용
        @Before("within(example.day06._aop과제.StudentApplication.StudentController)")
        public void logParameters(JoinPoint joinPoint) {
            String methodName = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();

            System.out.println("[로그] 메소드 " + methodName + " 실행 전");
            if (args.length > 0) {
                System.out.println("[로그] 매개변수: ");
                for (Object arg : args) {
                    System.out.println("[로그] " + arg);
                }
            } else {
                System.out.println("[로그] 매개변수 없음");
            }
        }

        // 조건 3: 리턴값 출력/로그처리 - 모든 컨트롤러 메소드에 적용
        @AfterReturning(
                pointcut = "within(example.day06._aop과제.StudentApplication.StudentController)",
                returning = "result"
        )
        public void logReturnValue(JoinPoint joinPoint, Object result) {
            String methodName = joinPoint.getSignature().getName();
            System.out.println("[로그] 메소드 " + methodName + " 실행 후");
            System.out.println("[로그] 리턴값: " + result);
        }

        // 조건 4: 실행시간 출력/로그 처리 - 모든 컨트롤러 메소드에 적용
        @Around("within(example.day06._aop과제.StudentApplication.StudentController)")
        public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
            String methodName = joinPoint.getSignature().getName();

            // 시작 시간 기록
            long startTime = System.currentTimeMillis();
            System.out.println("[로그] " + methodName + " 메소드 시작 시간: " + startTime + "ms");

            // 메소드 실행
            Object result = joinPoint.proceed();

            // 종료 시간 기록 및 소요 시간 계산
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println("[로그] " + methodName + " 메소드 종료 시간: " + endTime + "ms");
            System.out.println("[로그] " + methodName + " 메소드 실행 시간: " + executionTime + "ms");

            return result;
        }
    }

    // 학생 매퍼 인터페이스 (실제로는 MyBatis 매퍼가 구현)
    interface StudentMapper {
        int save(HashMap<String, Object> map);
        List<Map<String, Object>> findAll();
    }

    // 학생 컨트롤러
    @RestController
    static class StudentController {

        @Autowired
        private StudentMapper studentMapper;

        // 1. 등록
        @PostMapping("/students")
        public int save(@RequestBody HashMap<String, Object> map) {
            System.out.println("StudentController.save");
            System.out.println("map = " + map);

            // return studentMapper.save(map);
            int result = studentMapper.save(map);
            System.out.println("result = " + result); // souv 가장 가까운 변수 출력
            // result = 1 (sql 실행 결과 처리된 레코드 수)

            System.out.println("map = " + map);
            // map = {sno = 4, name = 유재석, math = 90, kor = 100}, sql처리 하기 전 sno는 없었지만 sql 처리된 후 sno 존재.
            return result;
        }

        // 2. 전체조회
        @GetMapping("/students")
        public List<Map<String, Object>> findAll() {
            System.out.println("StudentController.findAll");
            return studentMapper.findAll();
        }
    }

    // 매퍼 구현체 실제로는 MyBatis가 구현
    @Component
    static class StudentMapperImpl implements StudentMapper {

        private List<Map<String, Object>> students = new java.util.ArrayList<>();
        private int nextSno = 1;

        @Override
        public int save(HashMap<String, Object> map) {
            // 학생번호 자동 생성 및 저장
            map.put("sno", nextSno++);

            // 맵을 새로 생성하여 students 리스트에 추가
            Map<String, Object> newStudent = new HashMap<>(map);
            students.add(newStudent);

            return 1; // 성공적으로 1개 레코드 처리
        }

        @Override
        public List<Map<String, Object>> findAll() {
            return students;
        }
    }
}