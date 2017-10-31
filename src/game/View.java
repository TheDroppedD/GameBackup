import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class View extends JPanel {
	
	
	static Player player;
	
	static ImageIcon titleScreen;
	static JLabel label1;
	
	public View() {
		player = new Player(300,300);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, getWidth(), getHeight());
		/*g.setColor(Color.ORANGE);
		g.fillOval(xCoord, yCoord, 50, 50);
		g.drawString("This is an alpha", 200, 400);*/
		
		player.draw(g);
		
		g.dispose();
		repaint();
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	
}
