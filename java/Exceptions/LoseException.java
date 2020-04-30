package Exceptions;

public class LoseException extends Exception {
	
	public LoseException(String str)
	{
		super(str);
	}
	
	public LoseException() {
		super("You lost the game");
	}
}
