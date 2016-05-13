
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MazeGame extends JFrame {

	/*
	 * The idea behind this game is to be able to manipulate a graphic. Once
	 * this is possible, create a maze game. When it is done, we will move to
	 * the next game.
	 */

	private static final long serialVersionUID = 1L;

	public MazeGame() {

		super("Maze Game");
		// MazeGame maze = new MazeGame();
		setSize(1000, 350);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		// super.add(maze);
	}

	int x = 0, y = 0, velX = 0, velY = 0;

	public void createBlackSquare(Graphics g) {
		g.drawRect(x, y, 50, 50);
		g.setColor(Color.BLACK);
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
