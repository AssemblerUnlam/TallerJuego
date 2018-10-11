package testsViborita;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import Fruit.Fruit;
import GameEngine.GameManager;
import Map.Map;
import Snake.Snake;

public class TestViborita {
	
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
	public void noColisionaConsigoMisma() {
		Snake player = new Snake();
		player.InitializeSnake(new Point(50, 50));
		player.moveToRight();
		player.moveToMyOwnDirection();
		player.moveToDown();
		player.moveToMyOwnDirection();
		player.moveToLeft();
		player.moveToMyOwnDirection();
		player.moveToUp();
		player.moveToMyOwnDirection();
		Assert.assertEquals(new Point(50, 50), player.getPosition());
		Assert.assertEquals(false, player.isDead());
	}
	
	@Test
	public void intentaIrHaciaAtras() {
		Snake player = new Snake();
		player.InitializeSnake(new Point(10, 10));
		player.moveToUp();
		player.moveToMyOwnDirection();
		Assert.assertEquals(new Point(10, 11), player.getPosition());
	}
	
	@Test
	public void muereAlSalirDelMapa() {
		GameManager game = new GameManager();
		Map stage = new Map(1000, 1000);
		Snake player = new Snake();
		stage.addSnake();
		player.InitializeSnake(new Point(0 , 1000));
		player.moveToMyOwnDirection();
		game.CheckCollision(player, 1);
		Assert.assertEquals(true, player.isDead());
	}
	
	@Test
	public void incrementaSuTamañoAlComerUnaFruta() {
		GameManager game = new GameManager();
		Snake player = new Snake();
		Fruit fruit = new Fruit(new Point(0, 1 ));
		player.InitializeSnake(new Point(0, 0));
		player.moveToMyOwnDirection();
		game.CheckCollision(player, 1);
		Assert.assertEquals(4, player.getTailLenght());
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
	
	@Test
	public void collideToFruit() {
		Snake snake = new Snake();
		Fruit fruit = new Fruit(new Point(1,0));
		snake.InitializeSnake(new Point(0,0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(true, fruit.CollideTo(snake));		
	}
	
	@Test
	public void collideTosnake() {
		Snake snake1 = new Snake();
		Snake snake2 = new Snake();
		snake1.InitializeSnake(new Point(0,0));
		snake1.moveToRight();
		snake1.moveToMyOwnDirection();
		snake2.InitializeSnake(new Point(2,0));
		snake2.moveToLeft();
		snake2.moveToMyOwnDirection();
		Assert.assertEquals(true, snake1.CollideTo(snake2));		
	}
}