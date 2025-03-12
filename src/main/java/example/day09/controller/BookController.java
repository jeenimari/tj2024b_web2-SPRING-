package example.day09.controller;

import example.day09.model.dto.BookDto;
import example.day09.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/day09/books") //공통 url 정의
@CrossOrigin("http://localhost:5173")
public class BookController {
    //(1)서비스 메소드를 사용하기 위한 객체주입
    @Autowired private BookService bookService;

    //[2]책 추천 목록 조회
    @GetMapping("")
    public List<BookDto> bookCheck(){
        System.out.println("BookController.bookCheck");
        return bookService.bookCheck();
    }// fend

    //[3]추천도서 등록
    @PostMapping("")
    public boolean onCreate(@RequestBody BookDto bookDto){
        System.out.println("BookController.onCreate");
        System.out.println("bookDto = " + bookDto);
        return bookService.onCreate(bookDto);
    }

    //[4]책 추천 수정
    @PutMapping("")
    public boolean bookUpdate(@RequestBody BookDto bookDto){
        System.out.println("BookController.bookUpdate");
        System.out.println("bookDto = " + bookDto);
        return bookService.bookUpdate(bookDto);
    }

    //[5]책 추천 삭제
    @DeleteMapping("")
    public boolean bookDelete(@RequestParam int book_id,@RequestParam String pw){
        System.out.println("BookController.bookDelete");
        System.out.println("book_id = " + book_id);
        return bookService.bookDelete(book_id,pw);
    }

    //[6]책 추천 상세조회
    @GetMapping("/detail")
    public BookDto bookView (@RequestParam int book_id){
        System.out.println("BookController.bookView");
        System.out.println("book_id = " + book_id);
        return bookService.bookView(book_id);
    }

}// c end
