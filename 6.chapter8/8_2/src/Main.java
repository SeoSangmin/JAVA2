import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 8-2
 * InputStreamReader로 한글 텍스트 파일 읽기 
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fin = null;
		InputStreamReader in = null;
		
		try {
			fin = new FileInputStream("/Users/seosangmin/new");
			in = new InputStreamReader(fin, "UTF-8");
			int c;
			
			System.out.println("인코딩 문자 집합은 "+in.getEncoding());
			while((c=in.read())!=-1) {
				System.out.print((char)c);
			}
			in.close();
			fin.close();
		} catch(IOException e) {
			System.out.println("입출력 오류");
		}

	}

}
