import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * 13-3 
 * 이진영상으로 변환 - 맞는지는 모르겠음 
 */

public class myframe extends JFrame{
	int num, W, H, gap;
	boolean color;
	Panel panel;
	String[] image_path = {"/Users/seosangmin/Pictures/kim.raw", //0, 380,380, color
			"/Users/seosangmin/Pictures/barbara.raw", //1, 512,512, color
			"/Users/seosangmin/Pictures/girl.raw", //2 256, 256, color
			"/Users/seosangmin/Pictures/GIRL.dat", //3 256,256, NotColor
			"/Users/seosangmin/Pictures/COUPLE256X256.dat", //4, 256,256, NotColor
			"/Users/seosangmin/Pictures/PEPPERS256X256.dat"}; //5 256,256, NotColor
	myframe(int num, int W, int H, int gap, boolean color){
		this.W = W;
		this.H = H;
		this.gap = gap;
		this.color = color;
		this.num = num;
		setTitle("14-3 : 이진영상으로 변환");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new Panel();
		setContentPane(panel);
		
		setSize(W,H+28); 
		setVisible(true);
	}
	
	class Panel extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//파일 읽기
			int[] rawData;
			int[][] pix;
			if(color) {
				rawData = new int[W*3*H];
				pix = new int[H][W*3];
			} else {
				rawData = new int[W*H*2];
				pix = new int[H][W];
			}
			
			int n=0, temp;
			FileInputStream fin;
			try {
				fin = new FileInputStream(image_path[num]);
				while((temp = fin.read())!=-1) {
					rawData[n++] = temp;
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("파일을 읽을 수 없습니다.");
				return;
			}
			
			//1차원 배열 2차원 배열로 변환
			if(color) {
				for(int i=0; i<H; i++) {
					for(int j=0; j<3*W; j++) {
						pix[i][j] = rawData[i*W*3+j];
					}
				}
			} else {
				for(int i=0; i<H; i++) {
					for(int j=0; j<W; j++) {
						pix[i][j] = rawData[i*W+j];
					}
				}
			}
			
			//화면에 영상 그리기 
			if(color) {
				for(int i=0; i<H; i++) {
					for(int j=0; j<3*(W-1); j+=3) {
						/*
						int red = pix[i][j];
						int green = pix[i][j+1];
						int blue = pix[i][j+2]; */
						int dot = (pix[i][j] +pix[i][j+1] +pix[i][j+2])/3;
						if(dot>gap) {dot = 255;}
						else {dot = 0;}
						g.setColor(new Color(dot, dot, dot));
						g.drawOval(j/3, i, 1, 1);
					}
				}
			} else {
				for(int i=0; i<H; i++) {
					for(int j=0; j<W; j++) {
						int gray = pix[i][j];
						if(gray>gap) {gray = 255;}
						else {gray = 0;}
						g.setColor(new Color(gray,gray,gray));
						g.drawOval(j, i, 1, 1);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe(4,256,256,130,false);
	}

}
