import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")

public class Character extends JFrame {

	public static void main(String[] args) {

		new Character();

	}

	public Character() {

		this.setSize(300, 300);

		this.setTitle("Character");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(new DrawStuff(), BorderLayout.CENTER);

		this.setVisible(true);

	}

	private class DrawStuff extends JComponent {

		public void paint(Graphics g) {

			Graphics2D character = (Graphics2D) g;

			character.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			Shape drawRoundRec = new RoundRectangle2D.Double(0, 0, 50, 50, 45, 45);

			character.setPaint(Color.BLACK);

			character.setColor(Color.RED);

			character.fill(drawRoundRec);

			character.setPaint(Color.BLACK);

			character.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40F));

		}

	}
}