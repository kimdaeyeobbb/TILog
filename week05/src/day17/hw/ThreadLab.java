package day17.hw;

public class ThreadLab {
    public static void main(String[] args) throws Exception {
        Thread mainThread = Thread.currentThread();
        System.out.println("[ 프로그램 시작 ]");
        System.out.println("작업 스레드명: "+mainThread.getName());
        System.out.println("---------------------");

        ThreadUpper threadUp = new ThreadUpper("ThreadUpper");
        System.out.println("\n작업 스레드명: "+ threadUp.getName());
        threadUp.start();
        threadUp.join();

        ThreadLower threadLow = new ThreadLower("ThreadLower");
        System.out.println("\n작업 스레드명: "+threadLow.getName());
        threadLow.start();
        threadLow.join();

        ThreadNumber threadNum = new ThreadNumber("ThreadNumber");
        System.out.println("\n작업 스레드명: " + threadNum.getName());
        threadNum.start();
        threadNum.join();

        ThreadJAVA threadJAVA = new ThreadJAVA("ThreadJAVA");
        System.out.println("\n작업 스레드명: "+threadJAVA.getName());
        threadJAVA.start();
        threadJAVA.join();

        System.out.println("MAIN 수행 종료");
    }
}

class ThreadUpper extends Thread{
    public ThreadUpper(String name){
        super(name);
    }

    public void run() {
        while (true) {
            try {
                char[] alphabets = new char[26];
                char ch = 'A';
                System.out.println("알파벳 대문자 출력을 시작합니다.");
                for (int i = 0; i < alphabets.length; i++) {
                    alphabets[i] = ch++;
                    System.out.println(alphabets[i]);
                    Thread.sleep(2000);  // 2초에 한번씩 출력하게 만들기 위함
                }
                System.out.println("알파벳 대문자 출력을 종료합니다.");
                break;
            } catch (InterruptedException e) {
                System.out.println("child interrupted");
            }
            System.out.println("Existing child thread");
        }
    }
}

class ThreadLower extends Thread{
    public ThreadLower(String name){
        super(name);
    }

    public void run() {
        while (true) {
            try {
                char[] alphabets = new char[26];
                char ch = 'a';
                System.out.println("알파벳 소문자 출력을 시작합니다.");
                for (int i = 0; i < alphabets.length; i++) {
                    alphabets[i] = ch++;
                    System.out.println(alphabets[i]);
                    Thread.sleep(3000);  // 3초에 한번씩 출력하게 만들기 위함
                }
                System.out.println("알파벳 소문자 출력을 종료합니다.");
                break;
            } catch (InterruptedException e) {
                System.out.println("child interrupted");
            }
            System.out.println("Existing child thread");
        }
    }
}

class ThreadNumber extends Thread{
    public ThreadNumber(String name){
        super(name);
    }
    public void run() {
        while (true) {
            try {
                System.out.println("1~30 숫자를 출력을 시작합니다.");
                for (int num = 1; num <= 30; num++) {
                    System.out.println(num);
                    Thread.sleep(1000);  // 1초에 한번씩 출력하게 만들기 위함
                }
                System.out.println("1~30 숫자를 출력을 종료합니다.");
                break;
            } catch (InterruptedException e) {
                System.out.println("child interrupted");
            }
            System.out.println("Existing child thread");
        }
    }
}

class ThreadJAVA extends Thread{
    public ThreadJAVA(String name){
        super(name);
    }
    public void run(){
        while(true){
            try{
                System.out.println("JAVA 10번 출력을 시작합니다.");
                for(int i=0; i<10; i++){
                    System.out.println("JAVA");
                    Thread.sleep(5000);
                }
                System.out.println("JAVA 10번 출력을 종료합니다.");
                break;
            } catch (InterruptedException e) {
                System.out.println("child interrupted");
            }
            System.out.println("Existing child thread");
        }
    }
}