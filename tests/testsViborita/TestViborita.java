import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import GameEngine.GameManager;
import Map.Map;
import Snake.Snake;

public class TestVibora {
	
	@Test
	public void moveToRight() {
		Snake snake = new Snake();
		snake.InitializeSnake(new Point(0,0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(1,0), snake.getPosition());
	}
	
	@Test
	public void moveToDown() {
		Snake snake = new Snake();
		snake.InitializeSnake(new Point(0,0));
		snake.moveToDown();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(0,1), snake.getPosition());		
	}
	
	@Test
	public void moveToUp() {
		Snake snake = new Snake();
		snake.InitializeSnake(new Point(10,10));
		snake.moveToUp();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(10,11), snake.getPosition());		
	}
	@Test
	public void moveToLeft() {
		Snake snake = new Snake();
		snake.InitializeSnake(new Point(10,10));
		snake.moveToLeft();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(9,10), snake.getPosition());		
	}
	@Test
	public void outOfMap() {
		Snake snake = new Snake();
		Map map = new Map(800, 600);
		snake.InitializeSnake(new Point(0,0));
		snake.moveToLeft();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(true, map.OutOfMap(snake));		
	}
}