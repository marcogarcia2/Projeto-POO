package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entity {
	
	public int x,y;
	public int speed;
	public String direction;
	public String name;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	
	public boolean collisionOn = false;
	
	public Projectile projectile;

	public abstract void draw(Graphics2D g2);
	
	//public abstract void draw(Graphics2D g2);
}
