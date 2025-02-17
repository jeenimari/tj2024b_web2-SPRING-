//package example.day01._1어노테이션;
//
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//import java.lang.reflect.Method;
//
//class SuperClass{ //상위 클래스 // 부모 클래스
//    public  void method1(){} //메소드
//
//}
//
//class SubClass extends SuperClass{ // 하위클래스 //자식클래스
//
//    @Override // 부모클래스의 메소드를 재정의(내부코드 수정)한다.
//    public void method1() {
//        super.method1();
//    }//f end
//    @Deprecated // 더이상 사용하지 않는 코드 임을 알림
//    public void method2(){
//
//    }// c end
//}
////[1]어노테이션 만들기
//@Retention(RetentionPolicy.RUNTIME)//런타임 까지 유지 한다는 뜻
//    @Target(ElementType.METHOD) //해당 어노테이션은 메소드에만 적용한다는 뜻
//@interface MyAnnotation1{
//    String value1();
//
//}
//
////[2]어노테이션 사용하기
//class TestClass{
//    @MyAnnotation1(value1 = "어노테이션값 주입해서 아래 코드에서 사용") // 실행중에 주입이됨
//    public void method3(){
//    //vlaue1 이라는 걸 사용 할 수 있다.( 내부적으로)
//
//
//    }// f end
//
//
//}// class end
//
//public class Example {
//    public static void main(String[] args) {
//        SubClass subClass = new SubClass(); //SubClass 객체 생성
//        subClass.method1(); //SubClass의 method1() 호출
//        subClass.method2(); //SubClass의 method2() 호출 // 비권장(더 이상 사용하지 않는메소드)
//
//    try {
//        Method method = testClass.class.getMethod("method3");
//       Annotation1 annotation = method.getAnnotation(Anootation1.class); //
//        System.out.println(anootation1.value1());
//    }catch (Exception e){
//        System.out.println(e);}
//
//    }// f end
//
//}// class end
//
///*
//인텔리제이 자동완성(대소문자 구별)
//1.자동완성 할 문자 몇개 입력하면 자동으로 아래에 여러가지 추천코드 나옴
//2.내가 자동완성 할 코드를 키보드 방향키 이동후 엔터
//
//[2]tapnine 플러그인 자동완성


