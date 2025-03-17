package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //게터세터 투스트링 포함
@AllArgsConstructor //전체 생성자
@NoArgsConstructor // 빈 생성자
@Builder //빌더패턴

public class MemberDto {
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mimg;

}
