package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;

public abstract class Projectile extends Entity{
	
	GamePanel gp;
	Entity user;	
	public int timer;
	
	public Projectile (GamePanel gp) {
		this.gp = gp;
		timer = 0;
		solidArea = new Rectangle(8,8,32,32);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
	
	public void set(int x, int y, String direction, Entity user) {
		
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.user = user;	
	}
	
	public void update() {
		
		if (this.collisionOn) {
			gp.projectileList.remove(this);
		}
		
		if (user == gp.player) {
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monsterList);
			System.out.println(monsterIndex);
			if(monsterIndex != 999) {
				System.out.println("AAAAA");
				// System.out.println("colidiu");
				
				// checando se ja é bola ou ainda não
				if (gp.monsterList[monsterIndex].isBall == false) {
					gp.monsterList[monsterIndex].isBall = true;
					gp.projectileList.remove(this);
				}
				else if (gp.monsterList[monsterIndex].isBall == true) {
					gp.monsterList[monsterIndex] = null;
					gp.projectileList.remove(this);
			
				}

			}
			
			
			try { // Caso aconteça algum bug e o projetil saia do mapa
				gp.cChecker.checkTile(this);
			} catch(ArrayIndexOutOfBoundsException e) {
				gp.projectileList.remove(this);
			}	
		}
		
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
