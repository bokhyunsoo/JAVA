package ch21_jdbc;

import java.util.List;
import java.util.Scanner;

public class CarManage {
	CarDAO dao=new CarDAO(); //dao 인스턴스 생성
	void delete(){
		Scanner scan=new Scanner(System.in);
		System.out.print("삭제할 차량번호를 입력하세요:");
		String license_number=scan.nextLine();
		int result=dao.deleteCar(license_number);
		if(result==1){
			System.out.println("삭제되었습니다.");
		}else{
			System.out.println("차량번호를 확인하세요.");
		}
	}
	void insert(){
		Scanner scan=new Scanner(System.in);
		System.out.print("차량번호:");
		String license_number=scan.nextLine();
		System.out.print("제조사:");
		String company=scan.nextLine();
		System.out.print("타입:");
		String type=scan.nextLine();
		System.out.print("제조연도:");
		int year=scan.nextInt();
		System.out.print("연비:");
		int efficiency=scan.nextInt();
		CarDTO dto=new CarDTO(
				license_number,company,type,year,efficiency);
		dao.insertCar(dto);
		System.out.println("추가되었습니다.");
	}
	void list(){
		List<CarDTO> items=dao.listCar(); //레코드 목록 리턴 
		System.out.println(
				"차량번호\t\t연도\t제조사\t타입\t연비");
		System.out.println("========================================================");
		for(CarDTO dto : items){
			System.out.print(dto.getLicense_number()+"\t\t");
			System.out.print(dto.getYear()+"\t");
			System.out.print(dto.getCompany()+"\t");
			System.out.print(dto.getType()+"\t");
			System.out.print(dto.getEfficiency()+"\n");
		}
	}
	public static void main(String[] args) {
		CarManage car=new CarManage();
		Scanner scan=new Scanner(System.in);
		while(true){
			System.out.println(
"작업을 선택하세요(1:목록 2:추가 3:삭제 0:종료):");
			int code=scan.nextInt();
			switch(code){
			case 0:
				scan.close();
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 1:	car.list(); break; 
			case 2: car.insert(); break;
			case 3: car.delete(); break;
			}
		}
	}
}








