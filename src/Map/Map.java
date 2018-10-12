package Map;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;
import Fruit.Fruit;
import GameEngine.GameObject;
import Snake.Snake;

public class Map {

	private final int MAX_SNAKES_ON_MAP = 4;
	
	private int width;
	private int height;
	private Point[] spawnPoints;
	private int snakesOnMap;
	public final int SCALE = 20;
	

	public Map(int width, int height) {
		this.width = width;
		this.height = height;
		spawnPoints = new Point[MAX_SNAKES_ON_MAP];
		spawnPoints[0] = new Point(0, 0);
		spawnPoints[1] = new Point((width / this.SCALE) - 10, 0);
		spawnPoints[2] = new Point(0, this.height / this.SCALE);
		spawnPoints[3] = new Point(width / this.SCALE, height / this.SCALE);
	
	}

	public Snake addSnake() {
		if (this.snakesOnMap == this.MAX_SNAKES_ON_MAP) {
			return null;
		}
		Snake newSnake = new Snake();
		newSnake.initializeSnake(spawnPoints[snakesOnMap]);
		snakesOnMap++;
		return newSnake;
	}

	//Crea una fruta en una posicion aleatoria dentro del mapa
	public Fruit spawnFruit() {
		int x = ThreadLocalRandom.current().nextInt(this.width / this.SCALE);
		int y = ThreadLocalRandom.current().nextInt(this.height / this.SCALE);

		return new Fruit(new Point(x, y));
	}
	
	//Crea una fruta en el medio del mapa.
	public Fruit spawnInitialFruit() {
		return new Fruit(new Point((width / this.SCALE) / 2, (height / this.SCALE) / 2));
	}
	
	public boolean outOfMap(GameObject object)
	{
		Point point = object.getPosition();
		if (point.x < 0 || point.x * this.SCALE >= this.width || point.y < 0
				|| point.y * this.SCALE >= this.height) {
			return true;
		}
		return false;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public Point getResolution() {
		return new Point(this.width,this.height);
	}
}
