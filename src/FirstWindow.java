import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;

public class FirstWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public FirstWindow() {
		super("Georgia Nidhi Carla");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel p = new JPanel(new GridBagLayout());

		JButton b = new JButton("Maze");
		JButton c = new JButton("Level 1");

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "Good job!");
				MazeGame maze = new MazeGame();
				maze.setVisible(true);

			}
		});

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 15, 15, 15);

		gbc.gridx = 0;
		gbc.gridy = 0;

		p.add(b, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;

		p.add(c, gbc);

		add(p);

	}
}
