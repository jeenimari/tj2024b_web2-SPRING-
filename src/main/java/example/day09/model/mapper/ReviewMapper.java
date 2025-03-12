package example.day09.model.mapper;

import example.day09.model.dto.ReviewDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewMapper {

    @Select("select * from reviews")
    public List<ReviewDto>reviewRead();


    //리뷰등록
    @Insert("insert into reviews(book_id ,content,pw ) " +
            " values ( #{ book_id } , #{ content } ,#{ pw } )")
    public boolean reviewCreate(ReviewDto reviewDto);


    //리뷰삭제
    @Delete("delete from reviews where review_id = #{review_id} and pw = #{pw}")
    public boolean reviewDelete(int review_id , String pw);

}
