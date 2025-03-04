package example.day06.aop;

public class Example1 {


    //===============================AOP 없이 구현된 코드 ================================///

    class TestService {
        //메소드 1
        public void enter1() {
            System.out.println("[코로나]온도 체크");  //(1) 부가기능
            System.out.println("[식당 입장]");       //(2) 비즈니스 로직

        } // fend

        //메소드2
        public void enter2() {
            System.out.println("[코로나]온도 체크");  //(1) 부가기능
            System.out.println("[학원 입장]");      //(2)비즈니스 로직



        }// fend
    }// testservice end

    public class Example2{
        public void main(String[] args) {
            TestService testService = new TestService();

            testService.enter1();
            testService.enter2();
            //단점 유지보수 복잡 하나의 메소드에서 부가기능

        }

    }



}// class end






