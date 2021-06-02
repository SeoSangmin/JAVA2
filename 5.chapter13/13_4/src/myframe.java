import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
/*
 * 13-4
 * 필름 효과
 * : 양화를 음화로 만들기 (사진을 현상하기 전 필름 효과) 
 */
public class myframe extends JFrame{
	private String[] image_path = {"/Users/seosangmin/Pictures/kim.raw", //0, 380,380, color
			"/Users/seosangmin/Pictures/barbara.raw", //1, 512,512, color
			"/Users/seosangmin/Pictures/girl.raw", //2 256, 256, color
			"/Users/seosangmin/Pictures/GIRL.dat", //3 256,256, NotColor
			"/Users/seosangmin/Pictures/COUPLE256X256.dat", //4, 256,256, NotColor
			"/Users/seosangmin/Pictures/PEPPERS256X256.dat"}; //5 256,256, NotColor
	private int num,W,H,gap;
	private boolean color;
	
	private Panel panel = new Panel();
	myframe(int num, int W, int H, boolean color){
		this.W = W;
		this.H = H; 
		this.num = num;
		this.color = color;
		
		setTitle("14-4 : 필름 효과");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(W,H);
		setVisible(true);
	}
	
	class Panel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//파일 읽기
			int[] data = new int[W*H*3];
			int[][] pix;
			if(color) {
				pix = new int[H][W*3];
			} else {
				pix = new int[H][W];
			}
			
			int n=0, temp;
			FileInputStream fin;
			try {
				fin = new FileInputStream(image_path[num]);
				while((temp = fin.read())!=-1) {
					data[n++] = temp;
				}
			}catch(IOException e) {
				System.out.println("파일을 읽을 수 없습니다.");
			}
			//1dim convert to 2dim
			for(int i=0; i<H; i++) {
				if(color) {
					for(int j=0; j<W*3; j++) {
						pix[i][j] = data[i*W*3+j];
					}
				} else {
					for(int j=0; j<W; j++) {
						pix[i][j] = data[i*W+j];
					}
				}
			}
			//show image on the screen 
			for(int i=0; i<H; i++) {
				if(color) {
					for(int j=0; j<3*(W-1); j+=3) {
						int r = 255-pix[i][j];
						int gr = 255-pix[i][j+1];
						int b = 255-pix[i][j+2];
						g.setColor(new Color(r,gr,b));
						g.drawOval(j/3, i, 1, 1);
					}
				} else {
					for(int j=0;j<W;j++) {
						int rgb = 255-pix[i][j];
						g.setColor(new Color(rgb,rgb,rgb));
						g.drawOval(j, i, 1, 1);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe(5,256,256,false);
	}

}
