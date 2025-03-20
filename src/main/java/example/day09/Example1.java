package example.day09;


import lombok.Builder;

@Builder
class MemberDto{
    private String name; //멤버변수
    private int age;   //멤버변수

    public MemberDto(String name,int age){
        this.name = name;
        this.age =age;
    }
}


public class Example1 {
    public static void main(String[] args) {
        //(1)객체 MemberDto 생성할때 멤버변수에 초기값을 대입하는 방법(!!생성자!)
//        MemberDto memberDto = new MemberDto("유재석",40);
//        MemberDto memberDto1 = new MemberDto(); // 존재하지않는 생성자 사용.
//        MemeberDto memeberDto2 = new MemberDto("유재석"); //정의된 생성자의 매개변수를 일치하지않아서.

        //생성자 규칙 :
        // 1.정의(만든)된 생성자만 사용 가능
        // 2.매개변수 순서와 타입,개수 일치 해야함.
        // 다양한 생성자를 사용하면 복잡도 올라간다.->builder pattern
        //!빌더패턴 @Builder : 복잡한 객체 생성 과정을 단순화 해주는 디자인 패턴
        //(2)롬복 제공하는 @Builder 어노테이션 객체 생성
            //클래스명.builder().필드명(초기값).필드명(초기값).build():빌더 객체를 생성
        MemberDto memberDto5 = MemberDto.builder().name("유재석").age(40).build();
    }
}
