package example.day04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    //스프링 컨테이너 빈 주입 (싱글톤 대신 씀)
    @Autowired private StudentService studentService;


    //1.학생점수
    @PostMapping("/day04/student")
    public boolean student(@RequestBody StudentDto studentDto){
        System.out.println("StudentController.student");
        System.out.println("studentDto = " + studentDto);
        boolean result = studentService.student(studentDto);
        return result;
    }


    //2.학생 전체조회
    @GetMapping("/day04/student")
    public List<StudentDto>AllStudent(){
        System.out.println("StudentController.AllStudent");
        System.out.println();
        return studentService.AllStudent();


    }
    //3.학생 개별  수정
    @PutMapping("/day04/student")
    public int contentcheck(@RequestBody StudentDto studentDto){
        System.out.println("StudentController.contentcheck");
        System.out.println("studentDto = " + studentDto);

        int result = studentService.contentcheck(studentDto);
        return result;

    }

    //4.학생 개별 삭제
    @DeleteMapping("/day04/student")
    public int sdelete(@RequestParam("sno")int sno){
        System.out.println("StudentController.sdelete");
        System.out.println("sno = " + sno);
        int result = studentService.sdelete(sno);
        return result;

    }

}// class end
