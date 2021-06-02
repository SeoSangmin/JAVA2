import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("/Users/seosangmin/new");
			in = new InputStreamReader(fin, "US-ASCII");
			int c;
			
			System.out.println("인코딩 문자 집합은 "+in.getEncoding());
			while((c=in.read())!= -1) {
				System.out.print(c);
			}
			in.close();
			fin.close();
		} catch(IOException e) {
			System.out.println("입출력 오류");
		}
	}

}
