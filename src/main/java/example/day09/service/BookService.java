package example.day09.service;

import example.day09.model.dto.BookDto;
import example.day09.model.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired private BookMapper bookMapper;
    //[2]책 추천 목록 조회
    public List<BookDto>bookCheck(){
        System.out.println("BookService.bookCheck");
        return bookMapper.bookCheck();
    }
    //[3]추천도서 등록
    public boolean onCreate(BookDto bookDto){
        return bookMapper.onCreate(bookDto);
    }

    //[4]책 추천 수정

    public boolean bookUpdate(BookDto bookDto){
        return bookMapper.bookUpdate(bookDto);

    }
    //[5]책 추천 삭제
    public boolean bookDelete(int book_id,String pw){
        System.out.println("BookService.bookDelete");
        System.out.println("book_id = " + book_id);
        return bookMapper.bookDelete(book_id,pw);
    }

    //[6]책 상세조회
    public BookDto bookView(int book_id){
        System.out.println("BookService.bookView");
        System.out.println("book_id = " + book_id);
        return bookMapper.bookView(book_id);
    }

}//  c end
