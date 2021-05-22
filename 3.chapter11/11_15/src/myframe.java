import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-15
 */
public class myframe extends JFrame{
	private int r, g, b;
	private JLabel coloreLa = new JLabel("SLIDER EXAMPLE");
	private JSlider[] slider = new JSlider[3];
	
	myframe(){
		setTitle("11-15");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		for(int i=0; i<3; i++) {
			slider[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
			slider[i].setPaintLabels(true);
			slider[i].setPaintTicks(true);
			slider[i].setPaintTrack(true);
			slider[i].setMajorTickSpacing(50);
			slider[i].setMinorTickSpacing(10);
			slider[i].addChangeListener(new changeLi());
			c.add(slider[i]);
		}
		slider[0].setForeground(Color.red);
		slider[1].setForeground(Color.green);
		slider[2].setForeground(Color.blue);
		
		coloreLa.setFont(new Font("맑은고딕", Font.BOLD, 30));
		coloreLa.setOpaque(true);
		coloreLa.setBackground(Color.white);
		c.add(coloreLa);
		
		setSize(300,300);
		setLocation(600,150);
		setVisible(true);
	}
	
	class changeLi implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			r = slider[0].getValue();
			g = slider[1].getValue();
			b = slider[2].getValue();
			
			coloreLa.setBackground(new Color(r,g,b));
			getContentPane().setBackground(new Color(255-r,255-g,255-b));
			coloreLa.setForeground(new Color(255-r,255-g,255-b));
			
			/* - 위랑 반대 색.
			coloreLa.setBackground(new Color(255-r,255-g,255-b));
			getContentPane().setBackground(new Color(r,g,b));
			coloreLa.setForeground(new Color(r,g,b));
			*/
		}
	}

	public static void main(String[] args) {
		new myframe();
	}
}
