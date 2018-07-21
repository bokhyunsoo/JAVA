package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStream {
	public static void main(String[] args) {
		try {
//텍스트파일이 아닌 binary file(이진파일)로 저장
//윈도우즈 : \
//리눅스 : /		, 드라이브가 없음	
			DataOutputStream dataout=new DataOutputStream(
					new FileOutputStream("d:\\test.dat"));
			dataout.writeInt(123);
			dataout.writeChar('A');
			dataout.writeDouble(3.5);
			dataout.close();  //스트림 닫기(파일이 완성됨)
			System.out.println("저장되었습니다.");
			DataInputStream datain=new DataInputStream(
					new FileInputStream("d:\\test.dat"));
			System.out.println(datain.readInt());
			System.out.println(datain.readChar());
			System.out.println(datain.readDouble());
			datain.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





