package web.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.MemberDto;
import web.service.MemberService;

@RestController //@ResponseBody 지원 restApi 지원하는 컨트롤러 빈 등록
@RequestMapping("/api/member")//클래스내 http 매핑 주소의 공통 url 정의할때 사용
//1.페이지 url :ex) member/signup
//2.Rest url : 1. /member/signup.do : 뒤에 do를 붙이는 경우( 과거) 2./api/member: (최근)
@RequiredArgsConstructor
//final 필드에 대해서 자동으로 생성자를 지원하므로 @Autowired 주입 안해도됨
public class MemberController {

    private final MemberService memberService;

    //서비스 사용하기위한 객체주입 오토와일드
    //[1]회원가입
    @PostMapping("/signup")
    public boolean signUp(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.signUp");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberService.sigunUp(memberDto);
        System.out.println("result=" + result);
        return result;
    }

    //[2]로그인
    @PostMapping("/login")
    public boolean login(@RequestBody MemberDto memberDto , HttpServletRequest req){
        System.out.println("memberDto = " + memberDto);
        System.out.println("MemberController.login");
        MemberDto result = memberService.login(memberDto);
       if(result ==null){return false;} //서비스 결과가 null이면 로그인 실패
       else{
          HttpSession session = req.getSession(); //세션 호출
           session.setAttribute("loginDto",result); //세션 객체내 새로운 속성추가,로그인 성공한 결과정보를 loginDto라는 이름으로 저장.
           session.setMaxInactiveInterval(60*10); // 세션 유지 시간[초] : 60*10 =>10분
           return true; // 로그인 성공처리
       }  //서비스 결과가 null이 아니면 로그인 성공 =>세션에 로그인 성공한 dto를 저장

    }// f end

    //[3]로그아웃
    @GetMapping("/logout")
    public boolean logout(HttpServletRequest request){

        HttpSession session =request.getSession();  //1.세션호출
        if(session == null)return false;
//        session.invalidate(); //2.세션속성 초기화
        session.removeAttribute("loginDto"); //세션내 특정 속성만 초기화.
       return true;

    }

    //[4]로그인 상태 확인 , 내정보 보기(마이페이지)
    @GetMapping("/info")
    public MemberDto info(HttpServletRequest request){
        HttpSession session = request.getSession();//1.세션호출
        if(session == null){return null;} //2.만약 세션이 존재하지 않으면 null
       Object object =  session.getAttribute("loginDto"); //3.로그인 성공시 저장한 loginDto의 로그인 정보를 꺼냄
        MemberDto memberDto = (MemberDto)object;
        return memberDto; // 5.로그인된 정보 반환
    }





}
