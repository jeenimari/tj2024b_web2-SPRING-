package example.day02._2의존성;
/*
   - 스프링없이 객체( 인스턴스) 를 직접 생성하여 메소드 사용
   - 단점 : 강한 결합으로 유지보수 어려움

 */
//[1] 서비스클래스
class SampleService1{
    void method1(){
        System.out.println("SamleService1.method1"); //함수이름 호출

    }// f end

}
//[2] 컨트롤러 클래스
class SampleController{
    // 컨트롤러에서 서비스 클래스의 메소드 호출
    //다른 클래스의 메소드를 호춣하는 방법
    SampleService1 sampleService1 = new SampleService1();
    public void method(){
        sampleService1.method1(); //서비스 클래스의 메소드호출
    }// fend
}// c end

public class Example1 {


}// class end
