import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
/*
 * 13-2
 * 이미지 밝기를 조절 
 * + 슬라이더 생성 
 */

public class Myframe extends JFrame {
	private int W = 256;
	private int H = 256;
	private int compGap = 20;
	PanelforImage panel = new PanelforImage();
	//PanelforBrightnessBox panelbox = new PanelforBrightnessBox();
	JSlider brightSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, 0);
	String[] la = {"IMAGE", "PROCE", "SSING::"};
	JLabel[] label = new JLabel[la.length];
	private int brightness = 0;
	private int tt = 127;
	
	Myframe(){
		setTitle("영상뷰어 ver0.1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		panel.setSize(W,H);
		panel.setLocation(20,30);
		c.add(panel);
		
		//슬라이더 만들기. - 밝기 요소 슬라이드 
		brightSlider.setPaintLabels(true);
		brightSlider.setPaintTicks(true);
		brightSlider.setPaintTrack(true);
		brightSlider.setMajorTickSpacing(25);
		brightSlider.setMinorTickSpacing(10);
		brightSlider.addChangeListener(new changeLi());
		brightSlider.setSize(W, 50);
		brightSlider.setLocation(compGap, 30+W+10);
		c.add(brightSlider);
		
		//글씨 쓰기
		Font fontTitle = new Font("고딕", Font.BOLD, 80);
		for(int i=0; i<la.length; i++) {
			label[i] = new JLabel(la[i]);
			label[i].setFont(fontTitle);
			label[i].setOpaque(true);
			label[i].setBackground(Color.white);
			label[i].setForeground(new Color(tt,tt,tt));
			label[i].setSize(600,70);
			label[i].setLocation(W+compGap*2, 70+70*i);
			c.add(label[i]);
		}
		
		//밝기 시각화
		//panelbox.setSize(600,100);
		//panelbox.setLocation(W+compGap*2, 30+75*3+20);
		//c.add(panelbox);
		
		c.setBackground(new Color(0x00ffffff));
		
		setSize(600, 400);
		setLocation(500, 100);
		setVisible(true);
	}
	/*
	class PanelforBrightnessBox extends JPanel{
		PanelforBrightnessBox(){
			setOpaque(true);
			setBackground(Color.white);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int br = map(brightness, -255,255,0,255);
			g.setColor(new Color(br,br,br));
			g.fillRect(0, 0, 600, 72);
		}
	}*/
	class PanelforImage extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// 파일 입출력
			int data[] = new int[500*500];
			int pix[][] = new int[500][500];
			int n=0, temp;
			
			try {
				FileInputStream fin = new FileInputStream("/Users/seosangmin/Pictures/GIRL.dat");
				while((temp=fin.read())!=-1) { //1차원 배열 data[]에 정보 저장 
					data[n++] = temp;
				}
				
			}catch(Exception e) {
				System.out.println("파일 오류");
				return;
			}
			
			// 1차원 배열 -> 2차원 배열
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					pix[i][j] = data[i*W+j];
				}
			}
			
			//영상 나타내기 (+밝기 요소)
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					int color = pix[i][j] + brightness;
					if(color >255) {color = 255;}
					if(color < 0) {color = 0;}
					g.setColor(new Color(color, color, color));
					g.drawOval(j, i, 1, 1);
				}
			} 
			
		}
	}
	
	class changeLi implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider s = (JSlider)e.getSource();
			brightness = map(s.getValue(), -100,100,-255,255);
			//System.out.println("slider value : "+s.getValue()+", map value : "+brightness);
			tt = map(brightness,-255,255,0,255);
			//Myframe.this.getContentPane().setBackground(new Color(tt,tt,tt));
			Myframe.this.repaint();
			for(int i=0; i<label.length; i++) {
				label[i].setForeground(new Color(tt,tt,tt));
			}
		}
	}
	
	//map함수
		public int map(int x, int range1min, int range1max, int range2min, int range2max) {
			int target;
			int range1gap = range1max - range1min;
			int range2gap = range2max - range2min;
			target = (int)((range2gap)*(x-range1min)/range1gap + range2min);
			return target;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Myframe();
	}

}
