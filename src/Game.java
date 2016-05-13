import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

/*
 * Try to set a specific location for the panels
 * download.eclipse.org/egit/updates/
 */
public class Game extends JFrame {
	JPanel bottom = new JPanel();
	JPanel top = new JPanel();

	public Game() {
		setTitle("Game");
		setSize(1000, 350);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		top.setBackground(Color.BLUE);
		add(top);
		// top.setLocation(50, 50);
		bottom.setBackground(Color.RED);
		add(bottom, BorderLayout.SOUTH); // , BorderLayout.SOUTH
		// bottom.setLocation(300, 300);
	}

	public static void main(String args[]) {
		Game game = new Game();
	}
}
