
/**
 * Game by Georgia Bjarstal, Carla Balboa and Nidhi Yagnik. 
 * The game consists in moving a bird to try to get coins. The 
 * longer you touch a coin, the more points you get.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GetTheCoins implements ActionListener, MouseListener, KeyListener {

	public static GetTheCoins GetTheCoins;

	public final int WIDTH = 1000, HEIGHT = 650;

	public Renderer renderer;

	public Rectangle bird;

	public ArrayList<Rectangle> coins;

	public int ticks, yMotion, score;
	// yMotion is the position of the bird on the frame

	public boolean gameOver, started;

	public Random rand;

	public GetTheCoins() {
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Renderer();
		rand = new Random();

		jframe.add(renderer);
		jframe.setTitle("Get the coins ! by Georgia, Carla and Nidhi");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setResizable(false);
		jframe.setVisible(true);

		bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		coins = new ArrayList<Rectangle>();

		addCoin(true);

		timer.start();
	}

	public void addCoin(boolean start) {
		int width = 50;
		int height = 50;

		if (start) {
			for (int n = 0; n < 1000; n++) { // gives the number of coins in the
												// game
				Random randomHeight = new Random();
				int result = randomHeight.nextInt(HEIGHT - 250) + 50; // position
																		// of
																		// the
																		// coin
																		// in
																		// the
																		// game

				coins.add(new Rectangle(WIDTH + width + (coins.size() - 1) * 300, result, width, height)); // adds
																											// coins
			}
		}
	}

	public void paintCoin(Graphics g, Rectangle coin) {
		g.setColor(Color.yellow); // gives a yellow color to the coin
		g.fillOval(coin.x, coin.y, coin.width, coin.height); // makes the coin
																// round
	}

	public void jump() {
		if (gameOver) {
			bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20); // creates
																			// the
																			// bird
			coins.clear();
			yMotion = 0;
			score = 0;

			addCoin(true);

			gameOver = false; // makes the game restart
		}

		if (!started) {
			started = true;
		} else if (!gameOver) {
			if (yMotion > 0) {
				yMotion = 0;
			}

			yMotion -= 10;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int speed = 10;

		ticks++;

		if (started) {
			for (int i = 0; i < coins.size(); i++) {
				Rectangle coin = coins.get(i);

				coin.x -= speed; // makes the coins move
			}

			if (ticks % 2 == 0 && yMotion < 15) {
				yMotion += 2;
			}

			bird.y += yMotion;

			for (Rectangle coin : coins) {

				if (coin.intersects(bird)) {
					gameOver = false;
					score += 1;
					coin.move(-100, -100); // removes the coin as soon as it is
											// touch
					// add call for method music here
				}
			}

			if (bird.y > HEIGHT - 120 || bird.y < 0) { // border top
				gameOver = true;
			}

			if (bird.y + yMotion >= HEIGHT - 120) { // border bottom
				bird.y = HEIGHT - 120 - bird.height;
				gameOver = true;
			}
		}

		renderer.repaint();
	}

	public void repaint(Graphics g) {
		// color background
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		// color of grass
		g.setColor(Color.green.darker());
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);
		g.setColor(Color.green);
		g.fillRect(0, HEIGHT - 120, WIDTH, 20);

		// color of bird
		g.setColor(Color.magenta);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);

		for (Rectangle coin : coins) {
			paintCoin(g, coin);
		}

		// sets color, font, size for text
		g.setColor(Color.white);
		g.setFont(new Font("Georgia", 1, 40));

		if (!started) {
			g.drawString("Click to start! (try to get the coins)", 75, HEIGHT / 2 - 50);
		}

		if (gameOver) {
			g.drawString("Game Over!     Score : " + String.valueOf(score), 100, HEIGHT / 2 - 50);
		}

		if (!gameOver && started) {
			g.drawString("Score : " + String.valueOf(score), WIDTH / 2 - 25, 100);
		}
	}

	public static void main(String[] args) { // starts the class
		GetTheCoins = new GetTheCoins();
	}

	// allows you to play the game with different keys
	@Override
	public void mouseClicked(MouseEvent e) {
		jump();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

}