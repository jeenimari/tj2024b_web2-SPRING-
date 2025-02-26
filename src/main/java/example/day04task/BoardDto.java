package example.day04task;

import lombok.*;

@Setter @Getter @ToString @Builder
@NoArgsConstructor@AllArgsConstructor
public class  BoardDto {

    private int bno;
    private String title;
    private String content;

}
