package example.day04task;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    //1.글쓰기

    @Insert("INSERT INTO board (title, content) VALUES (#{title}, #{content})")

    boolean write (BoardDto boardDto);






    //2.전체 글 조회


    @Select("SELECT * FROM board")

    List<BoardDto> AllContents();



    //3.개별 글 조회
    @Update("UPDATE board SET title = #{title}, content = #{content} WHERE bno = #{bno}")
    BoardDto view(int bno);





    //4.개별 글 수정

    @Update("UPDATE board SET title = #{title}, content = #{content} WHERE bno = #{bno}")

    boolean editPost(BoardDto boardDto);



    //5.개별 글 삭제

    @Delete("DELETE FROM board WHERE bno = #{bno}")
    boolean deletePost(int bno);
}
