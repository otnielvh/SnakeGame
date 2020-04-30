import java.util.LinkedList;


public class SnakeGameLogic {
	Snake snake;
	Point food;
	
	public SnakeGameLogic() {
		snake = new Snake();
	}
	
	public void initialize(int xBorder, int yBorder)
	{
		//initialize food and snake
		food = new Point(xBorder/2, yBorder/2, xBorder, yBorder);
		snake.initialize(xBorder, yBorder);
	}
	
	public void advanceSnake()
	{
		
	}
	
	public LinkedList<Point> getSnakeList()
	{
		return snake.getList();
	}
	
	public Snake getSnake()
	{
		return snake;
	}
	
	public Point getFood()
	{
		return food;
	}
	
	public void eat(Point p)
	{
		//put in new food
		snake.eat(p);
	}
	
}
