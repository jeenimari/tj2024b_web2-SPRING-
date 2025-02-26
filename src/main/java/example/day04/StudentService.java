package example.day04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StudentService {

    @Autowired private StudentMapper stundentMapper;


    //1.학생점수 등록

    public boolean student(StudentDto studentDto){
        System.out.println("StudentController.student");
        System.out.println("studentDto = " + studentDto);
        boolean result = stundentMapper.student(studentDto);
        return result;
    }


    //2.학생 전체조회

    public List<StudentDto> AllStudent(){
        System.out.println("StudentController.AllStudent");

        return stundentMapper.AllStudent();


    }
    //3.학생 개별  수정

    public int contentcheck( StudentDto studentDto){
        System.out.println("StudentController.contentcheck");
        System.out.println("studentDto = " + studentDto);

        int result = stundentMapper.contentcheck(studentDto);
        return result;

    }

    //4.학생 개별 삭제

    public int sdelete(int sno){
        System.out.println("StudentController.sdelete");
        System.out.println("sno = " + sno);
        int result = stundentMapper.sdelete(sno);
        return result;

    }
}
