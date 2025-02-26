package example.day05.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    //인터페이스란? 공통된 메소드들을 추상화해서 각 사용할 클래스에서 구체화
    //인터페이스는 리모콘 같은 존재이다.
    //추상메소드란 ? 메소드의 구현부 { } 를뺴고 선언부만 존재하는 메소드
    //-> 여러곳에서 사용할 메소드를 반환타입 과 매개변수,함수명 만 정의하고 각 사용처에서 구현한다.


    //[1] 등록
    @Insert("insert into student(name,kor,math)values(#{name},#{kor},#{math})")
    @Options(useGeneratedKeys = true , keyProperty = "sno") // keyproperty = 식별키를 말함
    int save(HashMap<String,Object> map);
    //[2] 전체 조회
    //@Select("select * from student ")
    @Select("<script>select*from student</script>")
    List<Map<String,Object>> findAll();



    //minKOR 가 null 일때 실제 SQL표현 : select * from student where 1=1
    //minKor 가 80일때 실제 SQL표현 : select * from student where 1=1 and kor >=80
    //minkor 가 80이고 minMath가 90일때 : select * from student where 1=1 and kor>80 and minMath>=90
    //sql 에서 1=1( true Emt , 강제로 true 필요할때 방법 )
    /*
        [기본]String text= "안녕하세요" + " 유재석입니다";

        [자바15이상]String text =""
                                안녕하세요
                                유재석입니다.
                                """;

    */




    //[3] 수정
    @Update("update student set kor= #{kor}, math = #{math} where sno= #{sno}")
    int update(Map<String,Object>map);
    //[4] 삭제
    @Delete("delete from student where sno = #{sno}")
    boolean delete(@RequestParam int sno);

    //[5] 특정 점수 이상 학생조회

    @Select("""
    <script>select * from student 
            where 1=1 
            <if test ="minKor!= null">
                and kor>=#{minKor}
                </if>
                <if text ="minMath!=null">
                and math>=#{minMath}
                </if>
    </script>""") //java 15 이상부터 (강의는 17) *** *** 템플릿 지원 : 문자열 입력할때 다음줄로 이어지는 방법
    List<Map<String,Object>>findStudentScores(int minKor,int minMath);

    //[6] 여러명의 학생 등록하기
    @Insert("""
        <script>
        insert into student(name,kor,math)
        values
        <foreach collection="list" item="student" separator=",">
        (#{student.name}, #{student.kor}, #{student.math})
        </foreach>
        </script>
        """)

    public boolean saveAll(List<Map<String, Object>> list);

}


