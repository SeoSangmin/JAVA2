import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
/*
 * 12-9
 */

public class myframe extends JFrame {
	Panel panel = new Panel();
	myframe(){
		setTitle("12-9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBackground(Color.white);
		setContentPane(panel);
		
		setSize(500,500);
		setVisible(true);
	}
	
	class Panel extends JPanel{
		private Vector<Point> vStart = new Vector<Point>();
		private Vector<Point> vEnd = new Vector<Point>();
		public Panel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					Point startP = e.getPoint();
					vStart.add(startP);
				}
				
				public void mouseReleased(MouseEvent e) {
					Point endP = e.getPoint();
					vEnd.add(endP);
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.PINK);
			for(int i=0; i<vStart.size(); i++) {
				Point s = vStart.elementAt(i);
				Point e = vEnd.elementAt(i);
				g.drawLine((int)s.getX(), (int)s.getY(), 
						   (int)e.getX(), (int)e.getY());
			}
		}
	}
	public static void main(String[] args) {
		new myframe();
	}

}
