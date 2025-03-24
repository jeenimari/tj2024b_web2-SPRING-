package example.day10._멀티스레드;

//User1 클래스
class User1 extends Thread{
    Calculator calculator;
    @Override
    public void run(){
        calculator.setMemory(100);
    }
}// c end

//User2 클래스
class User2 extends Thread{
    Calculator calculator;
    @Override
    public void run(){
        calculator.setMemory(200);
    }
}

//Calculator 클래스
class Calculator{
    public int memory; //멤버변수

    public synchronized void setMemory(int memory){
        this.memory = memory;
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

//실행클래스
public class Example4 {
    public static void main(String[] args) {
        //1. 계산기 객체 생성
        Calculator calculator = new Calculator();
        //2.각 객체에 동일한 계산기 대입
        User1 user1 = new User1();
        user1.calculator = calculator;
        User2 user2 = new User2();
        user2.calculator = calculator;
        //??
        user1.calculator.memory = 100;
        System.out.println(user2.calculator.memory); // 100

        user1.start(); //200; ?? 100이아니라 200이나옴 why?각 객체가 계산기에 대입하여 병렬처리
        user2.start(); //200; user2가 원래 user1이 일시정지 되는 동안 바꿔치기 해버림 그래서 200출력됨
    }
}
