import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TestMovingObj extends JPanel implements ActionListener, KeyListener {
	Timer tm = new Timer(5, this);
	int x = 0, y = 0, velX = 0, velY = 0;
	int length = 50, width = 30;

	public TestMovingObj() {
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, length, width);
	}

	public void actionPerformed(ActionEvent e) {
		if (x < 0) {
			velX = 0;
			x = 0;
		}
		if (x > 530) { // refers to the size of the window
			velX = 0;
			x = 530;
		}
		if (y < 0) {
			velY = 0;
			y = 0;
		}
		if (y > 330) {
			velY = 0;
			y = 330;
		}

		x = x + velX;
		y = y + velY;
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_LEFT) {
			velX = -1;
			velY = 0;
		}
		if (c == KeyEvent.VK_UP) {
			velX = 0;
			velY = -1;
		}
		if (c == KeyEvent.VK_RIGHT) {
			velX = 1;
			velY = 0;
		}
		if (c == KeyEvent.VK_DOWN) {
			velX = 0;
			velY = 1;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		velX = 0;
		velY = 0;
	}

	public static void main(String[] args) {
		TestMovingObj t = new TestMovingObj();
		JFrame jf = new JFrame();
		jf.setTitle("TestMovingObj");
		jf.setSize(600, 400);// jf.setSize(530+50, 330+30);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel bottom = new JPanel();
//		JPanel top = new JPanel();
//		top.setBackground(Color.BLUE);
//		jf.add(top);
		// top.setLocation(50, 50);
		bottom.setBackground(Color.RED);
		jf.add(bottom, BorderLayout.SOUTH); // , BorderLayout.SOUTH
		// bottom.setLocation(300, 300);
		jf.add(t);
	}
}