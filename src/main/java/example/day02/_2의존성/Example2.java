package example.day02._2의존성;
/*
    [고전적인 방법 2 : 싱글톤 생성]
    스프링 없이 싱글톤 객체(인스턴스)를 직접 생성하여 메소드 사용
    이유 : 프로그램 내 하나의 인스턴스 필요할때 사용

*/
//[1]서비스 클래스
class SampleService2{
    //싱글톤 만들기
    //(1)
    private static SampleService2 instance = new SampleService2();
    private SampleService2(){}
    public static SampleService2 getInstance(){return instance;}

    void method(){
        System.out.println("SampleService2.method");

    }
}// class end

//[2]컨트롤러 클래스
class SampleController2{
    SampleService2 sampleService2 = SampleService2.getInstance();
    public void method(){
        sampleService2.method();
    }
}// class end

public class Example2 {


}
