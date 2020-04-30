import Exceptions.OutOfBorderException;

public class Point {
	
	private int _xBorder;
	private int _yBorder;
	private int _x;
	private int _y;
	
	public Point (int x, int y, int xBorder, int yBorder)
	{
		_x=x;
		_y=y;
		_xBorder = xBorder;
		_yBorder = yBorder;
	}
	
	public void setPoint(int x, int y) throws OutOfBorderException
	{
		setX(x);
		setY(y);
	}
	
	public Point(Point p)
	{
		_x=p._x;
		_y=p._y;
		_xBorder = p._xBorder;
		_yBorder = p._yBorder;
	}
	
	public void setX(int x) throws OutOfBorderException {
		if (x>=_xBorder || x<0)
			throw new OutOfBorderException();
		_x = x;
	}
	
	public void setY(int y) throws OutOfBorderException {
		if (y>=_yBorder || y<0)
			throw new OutOfBorderException();
		_y = y;
	}
	
	
	public int get_x() {
		return _x;
	}

	public int get_y() {
		return _y;
	}

    public static class WinException extends Exception {
        public WinException() {
            super("Win Exception");
        }
    }
}
