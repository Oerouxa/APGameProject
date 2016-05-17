

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GetTheCoins implements ActionListener, MouseListener, KeyListener {

	public static GetTheCoins GetTheCoins;

	public final int WIDTH = 1000, HEIGHT = 650;

	public Renderer renderer;

	public Rectangle bird;

	public ArrayList<Rectangle> coins;

	public int ticks, yMotion, score;

	public boolean gameOver, started;

	public Random rand;

	public GetTheCoins() {
		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Renderer();
		rand = new Random();

		jframe.add(renderer);
		jframe.setTitle("Get the coins !");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setResizable(false);
		jframe.setVisible(true);

		bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		coins = new ArrayList<Rectangle>();

		addCoin(true); // add more than 1 ?

		timer.start();
	}

	public void addCoin(boolean start) {
		int space = 300;
		int width = 100;
		int height = 50 + rand.nextInt(300);

		if (start) {
			// add coins
		} else {
			// add coins
		}
	}

	public void paintCoin(Graphics g, Rectangle coin) {
		g.setColor(Color.green.darker());
		g.fillRect(coin.x, coin.y, coin.width, coin.height);
	}

	public void jump() {
		if (gameOver) {
			bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			coins.clear();
			yMotion = 0;
			score = 0;

			gameOver = false;
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
	public void actionPerformed(ActionEvent e) { // part to be changed asap
		int speed = 10; // if changed, count points changed

		ticks++;

		if (started) {
			// for (int i = 0; i < coins.size(); i++) {
			// Rectangle coin = coins.get(i);
			//
			// coin.x -= speed;
			// }

			if (ticks % 2 == 0 && yMotion < 15) {
				yMotion += 2;
			}

			// for (int i = 0; i < coins.size(); i++) {
			// Rectangle coin = coins.get(i);
			//
			// if (coin.x + coin.width < 0) {
			// coins.remove(coin);
			//
			// if (coin.y == 0) {
			// addcoin(false);
			// }
			// }
			// }

			bird.y += yMotion;

			/**
			 * collision detection ? if touched die.
			 */

			// for (Rectangle coin : coins) {
			// if (coin.y == 0 && bird.x + bird.width / 2 > coin.x +
			// coin.width / 2 - 10
			// && bird.x + bird.width / 2 < coin.x + coin.width / 2 + 10) {
			// score++;
			// }
			//
			// if (coin.intersects(bird)) {
			// gameOver = true;
			//
			// if (bird.x <= coin.x) {
			// bird.x = coin.x - bird.width;
			//
			// } else {
			// if (coin.y != 0) {
			// bird.y = coin.y - bird.height;
			// } else if (bird.y < coin.height) {
			// bird.y = coin.height;
			// }
			// }
			// }
			// }

			if (bird.y > HEIGHT - 120 || bird.y < 0) {
				gameOver = true;
			}

			if (bird.y + yMotion >= HEIGHT - 120) {
				bird.y = HEIGHT - 120 - bird.height;
				gameOver = true;
			}
		}

		renderer.repaint();
	}

	public void repaint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.orange);
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);

		g.setColor(Color.green);
		g.fillRect(0, HEIGHT - 120, WIDTH, 20);

		g.setColor(Color.red);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);

		for (Rectangle coin : coins) {
			paintCoin(g, coin);
		}

		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 100));

		if (!started) {
			g.drawString("Click to start!", 75, HEIGHT / 2 - 50);
		}

		if (gameOver) {
			g.drawString("Game Over!", 100, HEIGHT / 2 - 50);
		}

		if (!gameOver && started) {
			g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
		}
	}

	public static void main(String[] args) {
		GetTheCoins = new GetTheCoins();
	}

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