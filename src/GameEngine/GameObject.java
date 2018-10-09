package GameEngine;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class GameObject implements ICollide {

	private Point position;
	private Color color;

	public GameObject() {

	}

	public GameObject(Point position, Color color) {
		this.position = position;
		this.color = color;

	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public boolean CollideTo(ICollide object) {
		if (object.getPosition().equals(this.getPosition())) {
			return true;
		}
		return false;
	}

}
