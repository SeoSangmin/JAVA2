import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
/*
 * 11-1
 */
public class myframe extends JFrame{
	myframe(){
		setTitle("11-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null); 
		
		//1. "Magenta/Yellow Button"
		JButton COLOR_BTN = new JButton("Magenta/Yellow Button");
		COLOR_BTN.setBorderPainted(false);
		COLOR_BTN.setBackground(Color.yellow); //배경색 설정 
		COLOR_BTN.setOpaque(true); //투명도 조절 
		COLOR_BTN.setForeground(Color.magenta); //글자색 설정 
		COLOR_BTN.setFont(new Font("Arial",Font.ITALIC, 20)); //폰트 설정 
		COLOR_BTN.setSize(490,40); 
		COLOR_BTN.setLocation(5,5);
		c.add(COLOR_BTN);
		
		//2. Disabled Button 
		JButton DISABLED_BTN = new JButton("Disabled Button");
		DISABLED_BTN.setBorderPainted(false); 
		DISABLED_BTN.setForeground(Color.gray); //글자색 설정 
		DISABLED_BTN.setEnabled(false); //버튼 비활성화 
		DISABLED_BTN.setSize(300,30);
		DISABLED_BTN.setLocation(100,50);
		c.add(DISABLED_BTN);
		
		//3. getX(), getY() 
		JButton GET_X_Y_BTN = new JButton("getX(), getY()");
		GET_X_Y_BTN.setSize(200, 30);
		GET_X_Y_BTN.setLocation(150, 85);
		GET_X_Y_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				setTitle(String.valueOf(b.getX())+
						","+String.valueOf(b.getY()));
			}
		});
		c.add(GET_X_Y_BTN);
		
		setSize(500,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}
