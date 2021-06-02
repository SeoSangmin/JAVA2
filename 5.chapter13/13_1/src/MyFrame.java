import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
/*
 * 13-1
 */
import java.io.InputStreamReader;
/*
 * 13-1
 */
public class MyFrame extends JFrame{
	MyPanel panel = new MyPanel();
	MyFrame(){
		setTitle("영상뷰어 ver0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(panel);
		
		setSize(400,400);
		setVisible(true);
	}
	
	static class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//1.영상파일 읽기
			int data[] = new int[400*400];
			int W, H;
			W = 256;
			H = 256;
			
			int n = 0, temp;
			
			try {
				FileInputStream fin = new FileInputStream("/Users/seosangmin/Pictures/GIRL.dat");
				while((temp = fin.read())!=-1) {
					data[n++]=temp;
				}
				fin.close();
			} catch(IOException e) {
				System.out.println("파일을 읽을 수 없습니다.");
				return;
			}
			
			
			//2.1차원 배열 -> 2차원 배열
			int bright = 0;
			
			int pix[][] = new int[400][400];
			for(int i = 0; i<H; i++) {
				for(int j=0; j<W; j++) {
					pix[i][j] = data[i*W+j] + bright;
					if(pix[i][j] > 255) {pix[i][j] = 255;
					}
				}
			}
			
			//3.화면에 영상 그리기 
			for(int i = 0; i<H; i++) {
				for(int j=0; j<W; j++) {
					g.setColor(new Color(pix[i][j], pix[i][j],pix[i][j]));
					g.drawOval(20+j, 20+i, 1, 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
