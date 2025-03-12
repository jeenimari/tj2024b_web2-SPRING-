package example.day09.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int book_id;
    private String title;
    private String author;
    private String intruduce;
    private String reg_date;
    private String pw;


}
