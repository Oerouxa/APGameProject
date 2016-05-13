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

		bottom.setBackground(Color.BLUE);
		add(bottom, BorderLayout.NORTH);
		top.setBackground(Color.RED);
		add(top, BorderLayout.SOUTH);

	}

	public static void main(String args[]) {
		Game game = new Game();
	}
}
