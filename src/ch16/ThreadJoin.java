package ch16;

public class ThreadJoin extends Thread {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"스레드가 시작되었습니다.");
		// 새로운 스레드가 생성되고 start()를 호출하면
		// 새로운 작업단위가 만들어지고 run() method가 실행됨
		ThreadJoin e = new ThreadJoin();
		e.setName("thread1"); //스레드의 이름
		e.start();
		try {
			e.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"스레드가 종료되었습니다.");
	}
	@Override
	public void run() {
		//현재 실행중인 스레드의 이름
		System.out.println(Thread.currentThread().getName()+"스레드가 시작되었습니다.");
		try {
			Thread.sleep(1000); //cpu의 실행을 강제로 멈춤
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"스레드가 종료되었습니다.");
	}
}
