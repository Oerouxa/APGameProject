import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
// Anime Rocks!
class TestMovingObj extends JPanel implements ActionListener, KeyListener{
 Timer tm = new Timer(5, this);
 int x=0, y=0, velX=0, velY=0;
 
 public TestMovingObj(){
  tm.start();
  addKeyListener(this);
  setFocusable(true);
  setFocusTraversalKeysEnabled(false);
 }
 
 public void paintComponent(Graphics g) {
  super.paintComponent(g);
  g.setColor(Color.RED);
  g.fillRect(x, y, 50, 30);
 }
 
 public void actionPerformed(ActionEvent e) {
  if (x < 0){
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
  jf.setSize(600, 400);
  jf.setVisible(true);
  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  jf.add(t);
 }
}