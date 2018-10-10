import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import Snake.Snake;

public class TestViborita {
	
	@Test
	public void seMueveDerecha() {
		Snake snake = new Snake();
		snake.InitializeSnake(new Point(0,0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(1,0), snake.getPosition());
	}
	
	@Test
	public void seMueveHaciaAbajo() {
		Snake snake = new Snake();
		snake.InitializeSnake(new Point(0,0));
		snake.moveToDown();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(0,1), snake.getPosition());		
	}
	
}