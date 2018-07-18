package ch13;

import java.util.Calendar;
import java.util.Date;

public class Cal {
	public static void main(String[] args) {
		// 캘린더 인스턴스 생성 new로 만들 수 없음
		Calendar cal = Calendar.getInstance();
		//Calendar cal = new Calendar();
		System.out.println(cal.get(Calendar.YEAR));
		//월은 0~11 (+1을 해야함)
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		//12시간제
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		//오전 0, 오후 1
		System.out.println(cal.get(Calendar.AM_PM));
		if(cal.get(Calendar.AM_PM)==0){
			System.out.println("오전");
		}else{
			System.out.println("오후");
		}
		//1년중 몇번째 날
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		//월의 몇번째 날
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		//요일(일요일 1 ~ 토요일 7)
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		String yoil="";
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1: yoil = "일요일"; break;
		case 2: yoil = "월요일"; break;
		case 3: yoil = "화요일"; break;
		case 4: yoil = "수요일"; break;
		case 5: yoil = "목요일"; break;
		case 6: yoil = "금요일"; break;
		case 7: yoil = "토요일"; break;
		}
		System.out.println("오늘은 "+yoil+"입니다.");
		System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
		//deprecated method => 권장되지 않는 method
		Date date = cal.getTime(); //java.util.Date
		System.out.println(date.getYear()+1900); //1900을 더함
		System.out.println(date.getMonth()+1);
		System.out.println(date.getDate());
	}
}
