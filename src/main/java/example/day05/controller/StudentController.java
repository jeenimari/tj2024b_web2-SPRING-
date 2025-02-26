package example.day05.controller;




import example.day05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/day05/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //1.등록
    @PostMapping("")
    public int save(@RequestBody HashMap<String,Object>map){
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        return studentService.save(map);
    }


    //2. 전체조회
    @GetMapping("")
    public List<Map<String,Object>> findAll(){
        System.out.println("StudentController.findAll");
        return null;
    }

    //3. 수정

    @PutMapping("")
    public int update(@RequestBody Map<String,Object>map){
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return 1;
    }

    //4.삭제
    @DeleteMapping("")
    public boolean delete(@RequestParam int sno){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return true;
    }

    //5. 특정 점수 이상 학생조회

    @GetMapping("/find/scores")
    public List<Map<String,Object>>findStudentScores(
            @RequestParam int minKor ,
            @RequestParam int minMath){
        System.out.println("StudentController.findStudentScores");
        System.out.println("minKor = " + minKor + ", minMath = " + minMath);
        return studentService.findStudentScores(minKor, minMath);
    }

    //[6] 여러명의 학생 등록하기
    @PostMapping("/save//all")
    public boolean saveAll(@RequestBody List<Map<String,Object>> list){
        System.out.println("StudentController.saveAll");
        System.out.println("list = " + list);
        return false; //샘플
    }

}
