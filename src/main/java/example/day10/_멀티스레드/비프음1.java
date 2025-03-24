package example.day10._멀티스레드;

import java.awt.*;

public class 비프음1 implements Runnable {

    @Override //재정의
    public void run(){
        for( int i = 1 ; i <= 5 ; i++ ){
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            toolkit.beep(); // 비프음
            try{ Thread.sleep( 1000 ); }
            catch (Exception e ){  System.out.println(e);  }
        }
    }
}
