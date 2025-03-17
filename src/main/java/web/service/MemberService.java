package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

@Service
@RequiredArgsConstructor // final 필드에 대해서 생략 가능

public  class MemberService {

    private final MemberMapper memberMapper;
//서비스와 매퍼연결 오토와일드

    //[1]회원가입

    public boolean signUp(@RequestBody MemberDto memberDto){
        System.out.println("MemberService.signUp");
        System.out.println("memberDto = " + memberDto);
        return memberMapper.signUp(memberDto);
    }

    //[2]로그인
    public MemberDto login(@RequestBody MemberDto memberDto) {
        System.out.println("memberDto = " + memberDto);
        System.out.println("MemberController.login");
        MemberDto result =  memberMapper.login(memberDto);
        return result;


    }



    //수정

    //삭제

}
