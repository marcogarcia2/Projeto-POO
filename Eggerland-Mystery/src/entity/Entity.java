package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entity {
	
	public int x,y;
	public int speed;
	public String direction;
	public String name;
	
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	
	public int solidAreaDefaultX, solidAreaDefaultY;
	
	public boolean collisionOn = false;
	
	public Projectile projectile;

	public int spriteNumH, spriteNumV;
	
	public abstract void update();
	public abstract void draw(Graphics2D g2);
	
	public boolean isBall; // exclusivo da cobrinha
	public boolean awake = true;

	//public void update() {
		// TODO Auto-generated method stub
		
	//}
	
	//public abstract void draw(Graphics2D g2);
	//public abstract void update();
}
