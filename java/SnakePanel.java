import Exceptions.OutOfBorderException;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ListIterator;

import javax.swing.JPanel;

public class SnakePanel extends JPanel {

	private final static int PS=15;		//Point Scale
	SnakeGameLogic snakeGame;

	public SnakePanel() {
		snakeGame = new SnakeGameLogic();
		addKeyListener(new Listener());
		setFocusable(true);
	}

	public void initialize()
	{
		snakeGame.initialize(getWidth()/PS, getHeight()/PS);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Point p;
		ListIterator<Point> i = snakeGame.getSnakeList().listIterator();

		//draw snake

		while (i.hasNext())
		{
			p=i.next();
			g.draw3DRect(p.get_x()*PS, p.get_y()*PS,PS,PS, true);			
		}
		//draw food
		p=snakeGame.getFood();
		g.drawOval(p.get_x()*PS, p.get_y()*PS, PS, PS);

	}

	private class Listener extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) {
			myEvent(e);
			super.keyPressed(e);
		}

		
		private void myEvent(KeyEvent e)
		{
			if (e.getKeyCode()==KeyEvent.VK_UP)
			{
				try {
					System.out.println("move up");
					snakeGame.getSnake().advance(Snake.NORTH, snakeGame.getFood());
				} catch (OutOfBorderException e1) {
					System.out.println("You lost");
					e1.printStackTrace();
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT)
			{
				try {
					System.out.println("move right");
					snakeGame.getSnake().advance(Snake.EAST, snakeGame.getFood());
				} catch (OutOfBorderException e1) {
					System.out.println("You lost");
					e1.printStackTrace();
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT)
			{
				try {
					System.out.println("move Left");
					snakeGame.getSnake().advance(Snake.WEST, snakeGame.getFood());
				} catch (OutOfBorderException e1) {
					System.out.println("You lost");
					e1.printStackTrace();
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN)
			{
				try {
					System.out.println("move down");
					snakeGame.getSnake().advance(Snake.SOUTH, snakeGame.getFood());
				} catch (OutOfBorderException e1) {
					System.out.println("You lost");
					e1.printStackTrace();
				}
			}
			repaint();
		}
	}

}
