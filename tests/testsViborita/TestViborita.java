import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import GameEngine.GameManager;
import Snake.Snake;

public class TestVibora {
	
	@Test
	public void MoveToRight() {
		Snake snake = new Snake();
		snake.InitializeSnake(new Point(0,0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(1,0), snake.getPosition());
	}
	
	@Test
	public void MoveToDown() {
		Snake snake = new Snake();
		snake.InitializeSnake(new Point(0,0));
		snake.moveToDown();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(0,1), snake.getPosition());		
	}
	
	@Test
	public void MoveToUp() {
		Snake snake = new Snake();
		snake.InitializeSnake(new Point(10,10));
		snake.moveToUp();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(10,11), snake.getPosition());		
	}
	@Test
	public void MoveToLeft() {
		Snake snake = new Snake();
		snake.InitializeSnake(new Point(10,10));
		snake.moveToLeft();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(9,10), snake.getPosition());		
	}
}