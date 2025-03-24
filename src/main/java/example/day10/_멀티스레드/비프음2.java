package example.day10._멀티스레드;

import java.awt.*;

public class 비프음2 extends Thread{

    @Override // 재정의
    public void run(){
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // java ui 제공하는 패키지 ( java.awt )
        // 3-1 소리 5번 발생
        for( int i = 1 ; i <= 5 ; i++ ){
            toolkit.beep(); // 비프음( '띵' ) 발생
            // * 스레드 일시정지
            try {  Thread.sleep(1000); // Thread.sleep( 밀리초 ) ; 예외발생
            }catch (Exception e ){  System.out.println( e );  }
        }
    }// f end
}// class end
