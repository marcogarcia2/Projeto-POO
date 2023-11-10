package entity;

import java.awt.Graphics2D;

import main.GamePanel;

public abstract class Projectile extends Entity{
	
	GamePanel gp;
	Entity user;
	public int timer;
	
	public Projectile (GamePanel gp) {
		this.gp = gp;
		timer = 0;
	}
	
	public void set(int x, int y, String direction, Entity user) {
		
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.user = user;	
	}
	
	public void update() {
		
		switch(direction) {
		case "up": y -= speed; break;
		case "down": y += speed; break;
		case "left": x -= speed; break;
		case "right": x += speed; break;
		}
		
		timer++;
	}
	
	@Override
	public abstract void draw(Graphics2D g2);// {
		// TODO Auto-generated method stub
		
	//}

	
	
}
