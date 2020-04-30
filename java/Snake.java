import Exceptions.OutOfBorderException;

import java.util.LinkedList;


public class Snake {
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	
	public static final int INIT_SNAKE_SIZE = 4;
	
	private LinkedList<Point> _pointList;
	private int _direction;
	public Snake() {
		_pointList = new LinkedList<Point>();
		_direction = WEST;
	}
	
	public void initialize(int borderX, int borderY)
	{
		for (int i=0; i<INIT_SNAKE_SIZE; i++)
		{
			_pointList.addLast(new Point(i+(borderX/2),(borderY/2), borderX, borderY));
		}
	}
	
	public void advance (int dir, Point food) throws OutOfBorderException
	{
		changeDirection(dir);
		Point p = nextPos();
		if (food.get_x()==p.get_x() && food.get_y()==p.get_y())
		{
			eat(new Point (p));
		}
		else
			advance();
	}
	
	public void changeDirection(int dir)
	{
		_direction=dir;
	}
	
	public void eat (Point p)
	{
		_pointList.addLast(p);
	}
	
	
	public Point nextPos() throws OutOfBorderException
	{
		Point pMove = new Point(_pointList.peek());
		Point snakeHead = _pointList.peekLast();
		switch(_direction)
		{
		case NORTH:
			pMove.setY(snakeHead.get_y()-1);
			pMove.setX(snakeHead.get_x());
			break;
		case SOUTH:
			pMove.setY(snakeHead.get_y()+1);
			pMove.setX(snakeHead.get_x());
			break;
		case EAST:
			pMove.setY(snakeHead.get_y());
			pMove.setX(snakeHead.get_x()+1);
			break;
		case WEST:
			pMove.setY(snakeHead.get_y());
			pMove.setX(snakeHead.get_x()-1);
			break;
		}
		return pMove;
	}
	
	public void advance() throws OutOfBorderException
	{
		System.out.println("direction: " + _direction);
		Point pMove = _pointList.removeFirst();
		Point snakeHead = _pointList.peekLast();
		switch(_direction)
		{
		case NORTH:
			pMove.setY(snakeHead.get_y()-1);
			pMove.setX(snakeHead.get_x());
			break;
		case SOUTH:
			pMove.setY(snakeHead.get_y()+1);
			pMove.setX(snakeHead.get_x());
			break;
		case EAST:
			pMove.setY(snakeHead.get_y());
			pMove.setX(snakeHead.get_x()+1);
			break;
		case WEST:
			pMove.setY(snakeHead.get_y());
			pMove.setX(snakeHead.get_x()-1);
			break;
		}
		_pointList.addLast(pMove);
	}
	
	public LinkedList<Point> getList()
	{
		return _pointList;
	}
	
	public boolean isSnake(Point p)
	{
		return true;
	}
	
}
