import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

@SuppressWarnings("serial")

public class Obstacle extends JFrame {

	public static void main(String[] args) {

		new Obstacle();

	}

	public Obstacle() {

		this.setSize(500, 500);

		this.setTitle("Obstacle");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(new DrawStuff(), BorderLayout.CENTER);

		this.setVisible(true);

	}

	private class DrawStuff extends JComponent {

		public void paint(Graphics g) {

			Graphics2D graph2 = (Graphics2D) g;

			graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			Shape drawRoundRec = new RoundRectangle2D.Double(25, 25, 50, 50, 45, 45);

			graph2.setPaint(Color.BLACK);

			graph2.setColor(Color.GREEN);

			graph2.fill(drawRoundRec);

			graph2.setPaint(Color.BLACK);

			graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40F));

		}

	}
}
