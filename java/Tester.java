import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class Tester {
	
	public static void main(String args[])
	{
		SnakePanel snakePanel = new SnakePanel();
		JFrame frame = new JFrame();
		frame.add(snakePanel);
		frame.setSize(400, 400);
		frame.setVisible(true);
		snakePanel.initialize();
		
	}
}
