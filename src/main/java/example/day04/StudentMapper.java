package example.day04;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    //1점수등록
    @Insert("insert into student (name,kor,math) values (#{name} ,#{kor},#{math});")
    boolean student(StudentDto studentDto);

    //2전체조회 sql
    @Select("select * from student")
    List<StudentDto>AllStudent();
    //3개별조회 sql
    @Update("update student set name =#{name},kor=#{kor},math=#{math} where sno = #{sno}" )
    StudentDto getStudent(int sno);
    int contentcheck(StudentDto studentDto);

    //개별 삭제
    @Delete("delete from student where sno = #{sno}")
    int sdelete(int sno);




}
