import java.io.FileOutputStream;

public class Main {

	public static void main(String[] args) {
		byte b[] = {7,51,3,4,-1,24};
		try {
			FileOutputStream fout = 
					new FileOutputStream("");
			for(int i=0; i<b.length;i++) {
				fout.write(b[i]); //배열b의 바이너리를 그대로 기록 
			}
			fout.close();
		}
		
	}

}
