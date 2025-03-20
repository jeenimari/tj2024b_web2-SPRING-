package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile uploadfile; // [FORM전송] 등록시 업로드 된 파일의 바이트 인터페이스 (1개)
    // private List<MultipartFile> uploadfiles; // 등록시 여러개 업로드 된 파일 (여러개)
}
