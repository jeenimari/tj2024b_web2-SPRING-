package example.day10._멀티스레드;

class 작업스레드A  extends Thread{
    @Override
    public void run(){
        try{
            int count = 1;
            while (true){
                Thread.sleep(1000);
                Thread.currentThread().setName("작업스레드A"); //스레드 이름 정의/만들기 함수
                count++; //변수 증가
                System.out.println("현재 스레드명:" + Thread.currentThread().getName()+"count:" + count);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}



public class Example2 {
    //(1) main 스레드
    public static void main(String[] args) {
        //작업 스레드 생성 3가지방법

        //1.작업 스레스 생성
        작업스레드A thread1 = new 작업스레드A();
        //(3) 작업스레스 실행
        thread1.start();
        try {
            int count = 1;
            while (true) {
                Thread.sleep(1000);
                count++;
                System.out.println("현재 스레드명:" + Thread.currentThread().getName() + "count:" + count);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        //2.


        //3.
    } //m end
}// c end
