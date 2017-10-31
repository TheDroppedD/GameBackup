import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Controller extends JFrame implements KeyListener{
	
	public static Model logic = new Model();
	public static View screen = new View();
	
	
	public Controller() {
		
		
		this.setTitle("Controller");
		this.setSize(new Dimension(1200,1200));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		setBackground(Color.RED);
		addKeyListener(this);
		
		screen.titleScreen = new ImageIcon(getClass().getResource("images/titlescreen1.png"));
		screen.label1 = new JLabel(screen.titleScreen);
	
		add(screen.label1);
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_UP || c == KeyEvent.VK_W) {
			logic.moveUp();
			screen.player.setYD(-1);
		}
		if(c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S) {
			logic.moveDown();
			screen.player.setYD(1);
		}
		if(c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
			logic.moveLeft();
			screen.player.setXD(-1);
		}
		if(c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D) {
			logic.moveRight();
			screen.player.setXD(1);
		}
		if(c == KeyEvent.VK_H) { //help
			System.out.println(logic.player.x);
			System.out.println(logic.player.y);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		logic.player.setXD(0);
		logic.player.setYD(0);
		screen.player.setXD(0);
		screen.player.setYD(0);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	
	public static void main(String[] args) {
		
		
		Controller theGame = new Controller();
		theGame.add(screen);
		
		
	

		
	}
}
