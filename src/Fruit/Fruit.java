package Fruit;

import java.awt.Color;
import java.awt.Point;

import GameEngine.GameObject;
import GameEngine.ICollide;
import GameEngine.ITangible;

public class Fruit extends GameObject{
	//Puedo ponerle un multiplicador por si la fruta es mas grande.
		
	public Fruit(Point spawn)
	{
		super(spawn,Color.RED);
	}

	@Override
	public boolean collideTo(ICollide object) {
		
		if (this.getPosition().equals(((ITangible)object).getPosition())) {
			return true;
		}
		return false;
	}
	
	
}
