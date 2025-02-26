package example.day03._과제;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

   // @Insert("insert into day03board(title,content)values(#{title},#{content})")
    //[1]등록 SQL 매퍼
    boolean write(BoardDto boardDto);

    //@Select("select * from day03board")
    //[2]전체조회 SQL 처리하는 매퍼
    List<BoardDto>findAll();
    //@Select("select * from day03board where bno = #{bno}")
    //[3]개별조회 SQL 처리하는 매퍼
    BoardDto find(int bno);
    //@Update("update day03board set title=#{title},content=#{content} where bno =#{bno}")
    //[4]개별수정 처리하는 매퍼
    int update(BoardDto boardDto);
    //@Delete("delete form day03board where bno = #{bno}")
    //[5]개별삭제 SQL 처리하는 매퍼
    int delete(int bno);

}
