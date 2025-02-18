package example.day02._3과제;


import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor
public class BoardDto {
    private String title;
    private String content;

    private int bno;
}
