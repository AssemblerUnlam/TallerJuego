package GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.Timer;

import Fruit.Fruit;
import Map.Map;
import Snake.Snake;

public class GameManager {
	private Map map;
	private Fruit currentFruit;
	private ArrayList<Snake> snakes;

	public GameManager() {
		this.map = new Map(800, 600);
		snakes = new ArrayList<Snake>();
	}

	public static void main(String[] args) {
		GameManager manager = new GameManager();
		
		
		/*
		 * Inicialmente la snake empieza solo la cabeza en el punto 0,0
		 * y por defecto comienza a bajar mientras las partes finales de la serpiente avanzan.
		 * Por defecto en la clase snake tiene 3 partes que van bajando.
		 * 
		 */
		
		System.out.println("Comienza el juego.\n======");
		System.out.println("Momento Inicial");
		manager.startGame();
		System.out.println("\n");
		manager.nextMoment();
		System.out.println("\nMomento siguiente 1");
		manager.nextMoment();
		System.out.println("\nMomento siguiente 2");
		manager.nextMoment();
		System.out.println("\nMomento siguiente 3");
		manager.nextMoment();
		System.out.println("\nMomento siguiente 4");
		manager.nextMoment();
		System.out.println("\nMomento siguiente 5");
		manager.nextMoment();

		
	}
	
	
	public void startGame() {
		Snake player1 = this.map.addSnake();
		this.snakes.add(player1);
		this.setFruit(this.map.spawnFruit());
		System.out.println("Cabeza inicio:"+player1.getPosition().toString());
	}

	
	public void nextMoment()
	{
		for (int i = 0; i < this.snakes.size(); i++) {
			Snake snake = snakes.get(i);
			snake.moveToMyOwnDirection();
			CheckCollision(snake,i);
		}
	}
	
	
	
	//Controlo las colisiones de cada serpiente
	private void CheckCollision(Snake currentSnake, int snakeIndex)
	{
		if (this.map.OutOfMap(currentSnake)) {
			currentSnake.killSnake();
		}

		if (currentFruit.CollideTo(currentSnake)) {
			currentSnake.incTail();
			this.setFruit(this.map.spawnFruit());
		}
		
		for (int i = 0; i < this.snakes.size(); i++) {
			if (i == snakeIndex) {
				continue;
			}
			
			Snake snake = snakes.get(i);
			if (snake.CollideTo(currentSnake)) {
				return;
			}
		}
	}
	
	private void setFruit(Fruit fruit)
	{
		this.currentFruit = fruit;	
	}

}
