import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MazeGame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MazeGame() {

		super("Maze Game");
	//	MazeGame maze = new MazeGame();
		setSize(750, 750);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		//super.add(maze);
	}

	int x = 0, y = 0, velX = 0, velY = 0;

	public void createBlackSquare(Graphics g) {
		g.drawRect(x, y, 50, 50);
		g.setColor(Color.RED);
		// g.fillRect(x, y, 50, 50);
	}

	public static void main(String[] args) {
		// MazeGame maze = new MazeGame();
		// JFrame jf = new JFrame();
		// jf.setTitle("TestMovingObj");
		// jf.setSize(600, 400);
		// jf.setVisible(true);
		// jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// jf.add(t);
	}

}
