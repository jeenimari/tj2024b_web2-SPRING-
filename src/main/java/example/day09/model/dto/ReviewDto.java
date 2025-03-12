package example.day09.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ReviewDto {
    private int book_id;
    private int review_id;
    private String content;
    private String pw;
    private String reg_date;

}
