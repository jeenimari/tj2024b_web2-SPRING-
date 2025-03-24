package example.day10._멀티스레드;

import java.time.LocalTime;
import java.util.Scanner;

class 시간클래스 implements Runnable{
    @Override
    public void run(){
        try {
            while (true){
                System.out.println(LocalTime.now());
                Thread.sleep(1000);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

class 타이머클래스 extends Thread{

    boolean state = true; // 무한루프 실행여부

@Override
public void run() {
    int second = 0;
    try {
        while (state) {
            Thread.sleep(1000);//1초 일시정지
            second++;
            System.out.println(" 타이머 :  " + second + " 초");
        }

    } catch (Exception e) {
        System.out.println(e);
    }
}
}



public class Example3 {
    public static void main(String[] args) {
        //1.현재 시간을 출력하는 스레드
        시간클래스 runnable = new 시간클래스();//구현객체
        Thread thread1 = new Thread(runnable);
        thread1.start(); //start() 메소드가 run()메소드 호출함.

        타이머클래스 thread2 = new 타이머클래스();
        //2.입력받기
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("타이머 1.on , 2.OFF : ");
            int ch = scan.nextInt();

            if(ch == 1){
                System.out.println("타이머시작");
            }else {
                System.out.println("타이머종료");
                thread2.state = false;
            }
        }
    }
}
