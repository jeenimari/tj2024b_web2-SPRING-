package example.day09.model.mapper;

import example.day09.model.dto.BookDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from books")
    public List<BookDto> bookCheck();

    ////추천도서 등록
    @Insert("insert into books(title,author,intruduce,pw) " +
            " values ( #{ title } , #{ author } , #{ intruduce }, #{ pw } )")
    public boolean onCreate(BookDto bookDto);

    //[4]책 추천 수정

    @Update("update books " +
            " set  title = #{ title } , author = #{ author },intruduce = #{ intruduce } "  +
            " where pw = #{ pw } and book_id = #{ book_id }  ")
    public boolean bookUpdate(BookDto bookDto);


    //[5]책 추천 삭제
    @Delete("delete from books where book_id = #{book_id} and pw = #{pw}")
    public boolean bookDelete(int book_id,String pw);


    //[6] 책 추천 상세조회
    @Select("select * from books where book_id =#{book_id}")
    public BookDto bookView(int book_id);
}

