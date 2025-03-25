package example.day11._스레드풀;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1{

    //*main함수 안에 main 스레드 내장(코드를 읽어드리는 역할)내장
    public static void main(String[] args) {
        //
        for(int i = 1; i<=5 ; i++){
         //(1)작업 스레드 생성
            String name = "thread"+i;
         Thread thread = new Thread(new Runnable() { //익명 구현체
             @Override  //스레드는 항상 예외처리를 해줘야함.
             public void run() {
                 System.out.println("작업스레드: 실행중"+name);
                 try {
                     Thread.sleep(1500); //1.5초 스레드 일시정지
                 }catch (Exception e){
                     System.out.println(e);
                 }
             }
         });   //작업 스레드 정의 end
            thread.start(); //여러 작업 스레드간의 실행순서 보장안됨
        }
        //[2]반복문 이용하여 반복문 횟수만큼 지정된 작업 스레드에 배정하여 실행 , 스레드풀
            //(1)스레드풀 생성(고정 된 스레드 개수 )
        ExecutorService executorService = Executors.newFixedThreadPool(3);
            //(2)반복문
        for(int i= 1; i<=10; i++){
            String name = "thread"+i;
            //(3)새로운 스레드가 아닌 스레드풀에 정의한 스레드를 등록한다.
            executorService.submit(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(2000); //2초 스레드 일시정지
                    }catch (Exception e){
                        System.out.println(e);
                        System.out.println("작업스레드: 실행중"+name);
                    }
                }
            });
        }
    }// m end
}// c end
