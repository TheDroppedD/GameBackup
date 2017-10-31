import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Model extends JPanel {
	
	static Player player;
	
	public Model() {
		player = new Player(300,300);
	}
	
	
	public static void moveUp() {
		player.setYD(-1);
		player.move();
	}
	public static void moveDown() {
		player.setYD(1);
		player.move();
	}
	public static void moveLeft() {
		player.setXD(-1);
		player.move();
	}
	public static void moveRight() {
		player.setXD(1);
		player.move();
	}

	
	
}
