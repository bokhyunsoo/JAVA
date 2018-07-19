package ch16;

public class Atm extends Thread {
	private long depositMoney = 100000;
	@Override
	public void run() {
		for(int i=1; i<=10; i++){
			withDraw(10000);
		}
	}
	// synchronized : 동기화(순차적인 처리)
	public synchronized void withDraw(int money){
		//현재 실행중인 스레드의 이름
		String name = Thread.currentThread().getName();
		if(depositMoney > 0){
			depositMoney = depositMoney - money;
			System.out.println(name+"-잔액:"+depositMoney);
		}else{
			System.out.println(name+"-잔액이 없습니다.");
		}
	}
}
