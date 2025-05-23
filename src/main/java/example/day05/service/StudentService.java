package example.day05.service;



import example.day05.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
 @Autowired
    StudentMapper studentMapper;



    //1.등록

    public int save(HashMap<String,Object> map){
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        //return studentMapper.save(map);
        int result = studentMapper.save(map);
        System.out.println("result = " + result); //souv 가장 가까운 변수 출력
        //result =1 ( sql 실행 결과 처리된 레코드 수)

        System.out.println("map = " + map);
        //ma ={ sno = 4 , name =유재석 , math=90 ,kor =100} , sql처리 하기 전 sno는 없었지만 sql 처리된 후 sno 존재.
        return result;

    }


    //2. 전체조회

    public List<Map<String,Object>> findAll(){
        System.out.println("StudentController.findAll");
     return studentMapper.findAll();
    }

    //3. 수정


    public int update(Map<String,Object>map){
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return studentMapper.update(map);
    }

    //4.삭제

    public boolean delete(int sno){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentMapper.delete(sno);
    }

    //5. 특정 점수 이상 학생조회

    public List<Map<String,Object>>findStudentScores( int minKor , int minMath){

        return studentMapper.findStudentScores(minKor,minMath);

    }


    //6.여러명의 학생 등록하기
    public boolean saveAll(List<Map<String,Object>>list){
        System.out.println("StudentService.saveAll");
        System.out.println("list = " + list);
        return false;
    }

}
