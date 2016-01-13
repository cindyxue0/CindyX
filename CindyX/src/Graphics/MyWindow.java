package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyWindow extends JFrame implements KeyListener {

	int width = 500;
	int height = 500;
	Hero girl;
	Hero boy;
	boolean itemPickedUp;
	BufferedImage landscape;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyWindow();
	}

	public MyWindow() {
		// the following are JFrame methods
		girl = new Hero("Girl", "/images/heroes/toadette.png", 200, 200);
		boy = new Hero("Boy", "/images/heroes/toad.png", 50, 50);
		itemPickedUp = false;
		landscape = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) landscape.getGraphics();
		paintLandscape(g2);
		setVisible(true);
		setSize(width, height);// units in px
		setLocation(200, 150);// 200 px right, 150 px down
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// static constant
														// reference for special
														// close operation
		addKeyListener(this);

	}

	public void paint(Graphics g) {
		// Graphics is a crayon box
		// Graphics2D is like an art kit(more stuff)
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		// g2.setColor(Color.white);
		// g2.fillRect(0, 0, width, height);
		g2.setColor(new Color(50, 100, 200));
		g2.fillRect(0, 0, width, height);

		g2.drawImage(landscape, 0, 0, null);
		// g2.setColor(Color.red);
		// g2.fillOval(100, 200, 100, 100);
		// g2.setColor(Color.blue);
		// g2.drawOval(100, 200, 100, 100);
		//
		// // x,y,width,height,startDEG,lengthDEG
		// g2.drawArc(50, 350, 200, 100, 0, 180);
		//
		// // String,x,y
		// g2.drawString("Strings are drawn like this", 150, 450);
		//
		// for (int x = 0; x < width; x += 10) {
		//
		// // lines:startX,startY,endX,endY
		// g2.drawLine(0, 0, x, height);
		//
		// }
		// for (int y = 0; y < height; y += 10) {
		//
		// // lines:startX,startY,endX,endY
		// g2.drawLine(0, y, width, height);
		//
		// }

		
		// boy = new Hero("Boy", "/images/heroes/toad.png", 100, 100);
		
		if(Math.abs(girl.getX()-boy.getX())+Math.abs(girl.getY()-boy.getY())<10){
			itemPickedUp= true;
		}
		
		if (!itemPickedUp)
			g2.drawImage(boy.getImage(), boy.getX(), boy.getY(), null);
		g2.drawImage(girl.getImage(), girl.getX(), girl.getY(), null);
		// int squareD = 20;
		// int margin = 2;
		// int c = 255;
		// for (int x = 0; x < width; x += squareD + margin) {
		// for (int y = 0; y < height; y += squareD + margin) {
		// if(c>255){
		// c=0;
		// }
		// g2.fillRect(x, y, squareD, squareD);
		// g2.setColor(new Color(0,0,c));
		// c++;
		// }
		//
		// }

		// draw the bufferedImage on the canvas
		g.drawImage(image, 0, 0, null);
	}

	public void paintLandscape(Graphics2D g2) {
		Polygon beach = new Polygon();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			girl.moveUp();
		} else if (key == KeyEvent.VK_DOWN) {
			girl.moveDown();
		} else if (key == KeyEvent.VK_RIGHT) {
			girl.moveRight();
		} else if (key == KeyEvent.VK_LEFT) {
			girl.moveLeft();
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
