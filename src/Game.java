import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class Game extends JFrame {
	JPanel bottom = new JPanel();
	JPanel top = new JPanel();

	public Game() {
		setTitle("Game");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		bottom.setBackground(Color.BLUE);
		add(bottom);
		top.setBackground(Color.RED);
		add(top, BorderLayout.SOUTH);
	}

	public static void main(String args[]) {
		Game game = new Game();
	}
}
