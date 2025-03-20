package web.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;
import web.model.dto.MemberDto;

@Mapper
public interface MemberMapper {

 //회원가입 -> insert
 @Insert("insert into member(mid,mpwd,mname,mimg)" +
         "values(#{mid},#{mpwd},#{mname},#{mimg})")
 public boolean signUp(@RequestBody MemberDto memberDto);

 //로그인
// @Select("select mno , mid , mname , mimg from member where mid = #{ mid } and mpwd = #{ mpwd }")
// //  boolean login( MemberDto memberDto ); // boolean : select 결과가 있으면 true , 없으면 null 이라서 오류 발생할수 있다.
// public MemberDto login(@RequestBody MemberDto memberDto); // MemberDto : select 결과가 있으면 memberDto 없으면 null

 //[*2*]
 @Select("select mpwd from member where mid = #{mid}")
 public String findPassword(String mid);

 //[*2*] 로그인 비밀번호 검증 성공시 반환할 회원정보
 @Select("select mno,mid,mname,mimg from member where mid =#{mid}")
 public MemberDto login(MemberDto memberDto);

}