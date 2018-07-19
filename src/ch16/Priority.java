package ch16;

public class Priority extends Thread{
	public static void main(String[] args) {
		Priority e1 = new Priority();
		Priority e2 = new Priority();
		//스레드의 이름 설정
		e1.setName("thread1");
		e2.setName("thread2");
		System.out.println("e1 기본 우선순위"+e1.getPriority());
		System.out.println("e2 기본 우선순위"+e2.getPriority());
		//스레드의 우선순위 설정
		//최소 우선순위(1)
		e1.setPriority(Thread.MIN_PRIORITY);
		//최대 우선순위(10)
		e2.setPriority(Thread.MAX_PRIORITY);
		e1.start(); //run() method가 호출됨
		e2.start();
	}
	@Override
	public void run() {
		for(int i=1; i<=10; i++){
			System.out.println(Thread.currentThread().getName()+"==>"+i);
		}
	}
}
