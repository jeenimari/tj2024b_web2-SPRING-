package example.day09.controller;

import example.day09.model.dto.ReviewDto;
import example.day09.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/day09/reviews")
@CrossOrigin("http://localhost:5173")
public class ReviewController {
    //서비스 메소드 사용하기 위한 객체 주입
    @Autowired private ReviewService reviewService;

    //책별 리뷰 목록조회
    @GetMapping("")
    public List<ReviewDto> reviewRead(){
        System.out.println("ReviewController.reviewRead");
        return reviewService.reviewRead();
    }// fend


    //리뷰 등록
    @PostMapping("")
    public boolean reviewCreate(@RequestBody ReviewDto reviewDto){
        System.out.println("reviewDto = " + reviewDto);
        System.out.println("ReviewController.reviewCreate");
        return reviewService.reviewCreate(reviewDto);
    }

    //리뷰삭제
    @DeleteMapping("")
    public boolean reviewDelete(@RequestParam int review_id ,@RequestParam String pw ){
        System.out.println("review_id = " + review_id);
        System.out.println("ReviewController.reviewDelete");
        return reviewService.reviewDelete(review_id,pw);
    }
}
