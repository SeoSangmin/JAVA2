import java.io.FileInputStream;
import java.io.IOException;

public class HeaderParsing {
	
	static int int_Data(byte[] int_byte) {
		int result = ( (int_byte[0]&0xff) | (int_byte[1]&0xff)<<8 
				| (int_byte[2]&0xff)<<16 | (int_byte[3]&0xff)<<24 );
		return result;
	}
	
	static short short_Data(byte[] short_byte) {
		short result = (short) ( (short_byte[0]&0xff) | (short_byte[1]&0xff)<<8 );
		return result;
	}

	public static void main(String[] args) {
		
		String bmpPath = "/Users/seosangmin/Pictures/X-logo.bmp";
		FileInputStream fin;
		
		char bfType[] = new char[2];
		int bfSize, bfOffbits, biWidth, biHeight;
		
		//2바이트, 4바이트 단위로 읽을 때 사용할 배열 두 개 생성 
		byte short_byte[] = new byte[2]; //2바이트 - short 사이즈 배열 
		byte int_byte[] = new byte[4];  //4바이트 - int 사이즈 배열 
		
		long startTime = System.currentTimeMillis();
		try {
			fin = new FileInputStream(bmpPath);
			//파일을 열어둔 채로 읽기. 일단 맨 앞의 두 바이트만.
			bfType[0] = (char)fin.read();
			bfType[1] = (char)fin.read();
			
			fin.read(int_byte); //FileInputStream 에 오버라이딩된 메소드. read()
			//read()는 1비트씩 정보를 읽음. 하지만 read(byte[size]) -> size바이트씩 읽어서 배열에 저장 
			
			bfSize = int_Data(int_byte);
			
			//지금은 관심 없는 리벌스 데이터 각각 2바이트는 넘긴다.
			fin.read(int_byte);
			
			//오프셋은 출력해보자. 오프셋 : 픽셀데이터 시작 위치
			fin.read(int_byte);
			bfOffbits = int_Data(int_byte);
			
			//이제 여기부터 읽을 데이터는 DIB 헤더이다. 맨 처음 4바이트는 DIB헤더 사이즈.
			fin.read(int_byte); //40바이트인 것을 알고 있으니 일단 출력하지 않고 넘어가자.
			fin.read(int_byte); //영상의 가로크기 
			biWidth = int_Data(int_byte);
			fin.read(int_byte); //영상의 세로크기 
			biHeight = int_Data(int_byte);
			
			fin.close();
			
		}catch(IOException e) {
			System.out.println("파일 읽기 오류");
			return;
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("bfType : "+(char)bfType[0]+(char)bfType[1]);
		System.out.println("bfSize : "+ bfSize+"(Byte)");
		System.out.println("bfOffbits : "+ bfOffbits);
		System.out.println("biSize : 40B, biWidth : "+biWidth+ ", biHeight : "+biHeight);
		System.out.println("소요 시간 : "+(endTime-startTime)/1000.0+"sec");

	}

}
