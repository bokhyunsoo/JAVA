package ch16;

public class RunnableExam implements Runnable{

	@Override
	public void run() {
		for(int i=1; i<=5; i++){
			//현재 실행중인 스레드의 이름
			System.out.println(Thread.currentThread().getName()+"==>"+i);
			//cpu의 실행을 강제로 멈춤
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		RunnableExam e1 = new RunnableExam();
		//new Thread(스레드구현객체, "스레드이름")
		Thread t1 = new Thread(e1,"thread1");
		Thread t2 = new Thread(e1,"thread2");
//		run()을 직접 호출 => main thread가 실행됨
//		t1.run();
//		t2.run();
		t1.start(); //run()이 호출됨
		t2.start();
	}
	
}
