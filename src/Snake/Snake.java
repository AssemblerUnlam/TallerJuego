package Snake;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import GameEngine.GameObject;
import GameEngine.ICollide;
import GameEngine.ITangible;

public class Snake extends GameObject {

	private final int START_LEN = 3;
	private ArrayList<Point> snakeParts = new ArrayList<Point>();
	private int tailLenght;
	private Point directionV = new Point(0, 1);// Seteado por defecto para que avance hacia abajo.
	private boolean dead;

	public Snake() {
		// listeners = new HashSet<ICollisionListener>();
	}

	public void InitializeSnake(Point newHead) {
		this.setPosition(newHead);
		tailLenght = this.START_LEN;
		snakeParts.clear();
		this.setColor(Color.BLUE);
		for (int i = 0; i <= this.START_LEN - 1; i++) {
			addPart();
		}

		dead = false;
	}

	public void stopMove() {
		this.directionV = new Point(0, 0);

	}

	public void moveToRight() {
		if (this.directionV.x + 1 == 0) {
			return;
		}
		this.directionV = new Point(1, 0);
	}

	public void moveToLeft() {
		if (this.directionV.x - 1 == 0) {
			return;
		}
		this.directionV = new Point(-1, 0);
	}

	public void moveToUp() {
		if (this.directionV.y - 1 == 0) {
			return;
		}
		this.directionV = new Point(0, -1);
	}

	public void moveToDown() {
		if (this.directionV.y + 1 == 0) {
			return;
		}
		this.directionV = new Point(0, 1);
	}

	public boolean moveToMyOwnDirection() {
		Point head = new Point(this.getPosition());

		if(this.dead) {
			return false;
		}
			

		this.snakeParts.add(new Point(head.x, head.y ));
		this.setPosition(new Point(head.x + this.directionV.x, head.y + this.directionV.y));
		System.out.println("Avanza cabeza: "+this.getPosition().toString());
		
		//Remuevo el punto de la posicion anterior.
		snakeParts.remove(0);
		
		for (Point point : snakeParts) {
			System.out.println("Parte: "+point.toString());
		}
		System.out.println("---------");
		return true;
	}

	public ArrayList<Point> getParts() {
		return this.snakeParts;
	}

	public void addPart(Point p) {
		this.snakeParts.add(p);
	}

	public void addPart() {
		Point head = this.getPosition();
		this.snakeParts.add(new Point(head.x, head.y));
	}

	public int getTailLenght() {
		return this.tailLenght;
	}

	public void killSnake() {
		this.dead = true;
	}

	public void incTail() {
		this.tailLenght++;
		addPart();
	}

	public boolean isDead() {
		// TODO Auto-generated method stub
		return this.dead;
	}

	@Override
	public boolean CollideTo(ICollide object) {
		for (Point point : snakeParts) {
			if (point.equals(((ITangible) object).getPosition())) {
				return true;
			}
		}
		return this.getPosition().equals(object.getPosition());
	}
}
