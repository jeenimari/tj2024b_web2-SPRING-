package example.day02._2의존성;

/*
 [  스프링 방법3 : IOC 와 DI ]

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//[1]서비스 클래스
@Component //1.스프링 컨테이너(메모리)에 빈(인스턴스 ) 등록
    // bean : 스프링 컨테이너(메모리)에서 관리하는 인스턴스/객체  .IOC
    // IOC  : 제어의 역전: 개발자가 인스턴스(new) 생성하지 않고 스프링 대신 인스턴스 생성/관리
class SampleService3{

    void method(){
        System.out.println("SampleService3.method");

    }

}// fend

//[2]컨트롤러 클래스
class SampleController3{
    @Autowired // 2.스프링 컨테이너메모리에 등록된 빈(인스턴스) 주입한다. DI dependeny Injection
    private SampleService3 sampleService3;
    public void method(){
        sampleService3.method();
    }



}// fend


public class Example3 {
}
