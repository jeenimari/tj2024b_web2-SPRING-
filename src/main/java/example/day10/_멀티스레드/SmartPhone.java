package example.day10._멀티스레드;

import java.util.Scanner;

// 음악 플레이어 스레드
class Task1 extends Thread {
    private boolean playing = true;

    @Override
    public void run(){
        try{
            while (playing){
                System.out.println("음악재생중");
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println("음악플레이어가 중단되었습니다.");
        }
    }//f end

    public void setPlaying(boolean playing){
        this.playing = playing;
    }
}

// 웹 브라우저 스레드
class Web extends Thread{
    private boolean browser = true;

    @Override
    public void run(){
        try{
            while (browser){
                System.out.println("웹서핑중");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("웹부라우저 중단되었습니다.");
        }
    }

    //웹서핑 상태 제어 메소드
    public void setBrowser(boolean browser){
        this.browser = browser;
    }
}

// 스마트폰 클래스
public class SmartPhone{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        //스레드 객체 생성
        Task1 task1 = null;
        Web web = null;

        System.out.println("스마트폰 시작");

        while (running){
            System.out.println("1. 뮤직 ON/OFF | 2. 웹서핑 ON/OFF | 0. 종료");
            System.out.print(">> ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1: // 음악 ON/OFF
                    if (task1 == null || !task1.isAlive()) {
                        // 음악 시작
                        task1 = new Task1();
                        task1.start();
                        System.out.println("음악 시작!");
                    } else {
                        // 음악 종료
                        task1.setPlaying(false);
                        task1.interrupt();
                        System.out.println("음악 종료!");
                    }
                    break;

                case 2: // 웹서핑 ON/OFF
                    if (web == null || !web.isAlive()) {
                        // 웹서핑 시작
                        web = new Web();
                        web.start();
                        System.out.println("웹서핑 시작!");
                    } else {
                        // 웹서핑 종료
                        web.setBrowser(false);
                        web.interrupt();
                        System.out.println("웹서핑 종료!");
                    }
                    break;

                case 0: // 종료
                    running = false;

                    // 실행 중인 스레드가 있으면 종료
                    if (task1 != null && task1.isAlive()) {
                        task1.setPlaying(false);
                        task1.interrupt();
                    }

                    if (web != null && web.isAlive()) {
                        web.setBrowser(false);
                        web.interrupt();
                    }

                    System.out.println("스마트폰 종료...");
                    break;

                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }

        scan.close();
    }
}