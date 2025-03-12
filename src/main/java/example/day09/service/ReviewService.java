package example.day09.service;

import example.day09.model.dto.ReviewDto;
import example.day09.model.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired private ReviewMapper reviewMapper;
    //책별 리뷰 목록조회
    public List<ReviewDto>reviewRead(){
        System.out.println("ReviewService.reviewRead");
        return reviewMapper.reviewRead();
    }

    //[2]리뷰 등록
    public boolean reviewCreate(ReviewDto reviewDto){
        return reviewMapper.reviewCreate(reviewDto);
    }

    //[3]리뷰 삭제
    public boolean reviewDelete(int review_id , String pw){
        System.out.println("ReviewService.reviewDelete");
        System.out.println("review_id = " + review_id);
        return reviewMapper.reviewDelete(review_id,pw);
    }

}// c end
