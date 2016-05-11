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

	private static final long serialVersionUID = 1L;

	public MazeGame() {

		super("Maze Game");
		// MazeGame maze = new MazeGame();
		setSize(750, 750);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		// super.add(maze);
	}

	int x = 0, y = 0, velX = 0, velY = 0;

	public void createBlackSquare(Graphics g) {
		g.drawRect(x, y, 50, 50);
		g.setColor(Color.RED);
		// g.fillRect(x, y, 50, 50);
	}

	private class DrawStuff extends JComponent {

		public void paint(Graphics g) {

			Graphics2D character = (Graphics2D) g;

			character.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			//Shape drawRoundRec = new RoundRectangle2D.Double(0, 0, 50, 50, 45, 45);

			character.setPaint(Color.BLACK);

			character.setColor(Color.RED);

		//	character.fill(drawRoundRec);

			character.setPaint(Color.BLACK);

			character.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40F));

		}

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
