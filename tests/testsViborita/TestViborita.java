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
		game.setFruit(fruit);
	}
	
	@Test
	public void moveToRight(){
		snake.initializeSnake(new Point(0,0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(1,0), snake.getPosition());
	}
	
	@Test
	public void moveToDown() {
		snake.initializeSnake(new Point(0,0));
		snake.moveToDown();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(0,1), snake.getPosition());		
	}
	
	@Test
	public void moveToUp() {
		snake.initializeSnake(new Point(10,10));
		snake.moveToUp();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(10,11), snake.getPosition());		
	}
	
	@Test
	public void moveToLeft() {
		snake.initializeSnake(new Point(10,10));
		snake.moveToLeft();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(9,10), snake.getPosition());		
	}
	
	@Test
	public void noColisionaConsigoMisma() {
		snake.initializeSnake(new Point(50, 50));
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
		snake.initializeSnake(new Point(10, 10));
		snake.moveToUp();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(new Point(10, 11), snake.getPosition());
	}
	
	@Test
	public void muereAlSalirDelMapa() {
		map.addSnake();
		snake.initializeSnake(new Point(0 , 1000));
		snake.moveToMyOwnDirection();
		game.checkCollision(snake, 0);
		Assert.assertEquals(true, snake.isDead());
	}
	
	@Test
	public void incrementaSuTamañoAlComerUnaFruta() {
		fruit.setPosition(new Point (1, 0));
		snake.initializeSnake(new Point(0, 0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		game.checkCollision(snake, 0);
		Assert.assertEquals(4, snake.getTailLenght());
	}
	
	@Test
	public void outOfMap() {

		snake.initializeSnake(new Point(0,0));
		snake.moveToLeft();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(true, map2.outOfMap(snake));		
	}
	
	@Test
	public void collideToFruit() {
		snake.initializeSnake(new Point(0,0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		Assert.assertEquals(true, fruit.collideTo(snake));		
	}
	
	@Test
	public void collideTosnake() {

		snake.initializeSnake(new Point(0,0));
		snake.moveToRight();
		snake.moveToMyOwnDirection();
		snake2.initializeSnake(new Point(2,0));
		snake2.moveToLeft();
		snake2.moveToMyOwnDirection();
		Assert.assertEquals(true, snake.collideTo(snake2));		
	}
}