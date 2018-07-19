package ch16;
//멀티스레드 : 작업단위가 2개 이상
//멀티스레드를 구현하는 방법
//1. Thread를 상속
//2. Runnable을 구현
public class ThreadExam extends Thread {
	public ThreadExam(String name) {
		super(name); // Thread 클래스의 생성자 호출
		// 스레드의 title 설정
	}
	//반드시 오버라이드
	@Override
	public void run() {
		for(int i=1; i<=5; i++){
			//현재 실행중인 스레드의 이름
			System.out.println(Thread.currentThread().getName());
			//cpu의 실행을 1초간 멈춤(필수예외처리)
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ThreadExam e1 = new ThreadExam("thread1");
		ThreadExam e2 = new ThreadExam("thread2");
		ThreadExam e3 = new ThreadExam("thread3");
		e1.start(); // run()이 호출됨
		e2.start();
		e3.start();
	}
}
