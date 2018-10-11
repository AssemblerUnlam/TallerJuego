package testsViborita;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Fruit.Fruit;
import GameEngine.GameManager;
import Map.Map;
import Snake.Snake;

public class TestViborita {

	
	Snake snake, snake2;
	GameManager game;
	Map map, map2;
	Fruit fruit;
	
	@Before
	public void setUp(){
		
		snake = new Snake();
		snake2 = new Snake();
		game = new GameManager();
		map = new Map(1000, 1000);
		map2 = new Map(800, 600);
		fruit = new Fruit(new Point(1,0));
	}
	
	@Test
	public void moveToRight(){
		snake.InitializeSnake(new Point(0,0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(1,0), snake.getPosition());
	}
	
	@Test
	public void moveToDown() {
		snake.InitializeSnake(new Point(0,0));
		snake.moveToDown();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(0,1), snake.getPosition());		
	}
	
	@Test
	public void moveToUp() {
		snake.InitializeSnake(new Point(10,10));
		snake.moveToUp();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(10,11), snake.getPosition());		
	}
	
	@Test
	public void moveToLeft() {
		snake.InitializeSnake(new Point(10,10));
		snake.moveToLeft();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(9,10), snake.getPosition());		
	}
	
	@Test
	public void noColisionaConsigoMisma() {
		snake.InitializeSnake(new Point(50, 50));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		snake.moveToDown();
		snake.moveToMyOwnDirection();
		snake.moveToLeft();
		snake.moveToMyOwnDirection();
		snake.moveToUp();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(50, 50), snake.getPosition());
		Assert.assertEquals(false, snake.isDead());
	}
	
	@Test
	public void intentaIrHaciaAtras() {
		snake.InitializeSnake(new Point(10, 10));
		snake.moveToUp();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(10, 11), snake.getPosition());
	}
	
//	@Test
//	public void muereAlSalirDelMapa() {
//		stage.addSnake();
//		player.InitializeSnake(new Point(0 , 1000));
//		player.moveToMyOwnDirection();
//		game.CheckCollision(player, 1);
//		Assert.assertEquals(true, player.isDead());
//	}
//	
//	@Test
//	public void incrementaSuTamañoAlComerUnaFruta() {
//
//		Snake player = new Snake();
//		Fruit fruit = new Fruit(new Point(0, 1 ));
//		player.InitializeSnake(new Point(0, 0));
//		player.moveToMyOwnDirection();
//		game.CheckCollision(player, 1);
//		Assert.assertEquals(4, player.getTailLenght());
//	}
	
	@Test
	public void outOfMap() {

		snake.InitializeSnake(new Point(0,0));
		snake.moveToLeft();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(true, map2.OutOfMap(snake));		
	}
	
	@Test
	public void collideToFruit() {
		snake.InitializeSnake(new Point(0,0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(true, fruit.CollideTo(snake));		
	}
	
	@Test
	public void collideTosnake() {

		snake.InitializeSnake(new Point(0,0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		snake2.InitializeSnake(new Point(2,0));
		snake2.moveToLeft();
		snake2.moveToMyOwnDirection();
		Assert.assertEquals(true, snake.CollideTo(snake2));		
	}
}