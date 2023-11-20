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
		solidArea = new Rectangle(2,2,44,44);
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
			
			// Checa colisão com monstros
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monsterList);
			if(monsterIndex != 999) {
				System.out.println("Monstro foi alvejado!");
				// System.out.println("colidiu");
				
				// checando se ja é bola ou ainda não
				if (gp.monsterList[gp.currentMap][monsterIndex].isBall == false) {
					gp.monsterList[gp.currentMap][monsterIndex].isBall = true;
					gp.projectileList.remove(this);
				}
				else if (gp.monsterList[gp.currentMap][monsterIndex].isBall == true) {
					gp.monsterList[gp.currentMap][monsterIndex] = null;
					gp.projectileList.remove(this);
				}
			}
			
			// Checa colisão com objetos
			int objIndex = gp.cChecker.checkObject(this, true);
			if (objIndex != 999) {
				gp.projectileList.remove(this);
			}
			
			try { // Caso aconteça algum bug e o projetil saia do mapa
				gp.cChecker.checkTile(this);
			} catch(ArrayIndexOutOfBoundsException e) {
				gp.projectileList.remove(this);
			}	
		}
		
		else { // user != player
				
			// checa colisão com o player
			
			try { 
				if (gp.cChecker.checkPlayer(this, gp.player)) { // MATAR O JOGADOR,
					gp.projectileList.remove(this); 
					gp.player.lifeCount --;
					gp.resetGame();
				} 
			} catch(ArrayIndexOutOfBoundsException e) {
				gp.projectileList.remove(this); 
			}
			
			// Checa colisão com objetos (caixas)
			int objIndex = gp.cChecker.checkObject(this, true); if (objIndex != 999) {
				  gp.projectileList.remove(this); 
			}
			 
			
			// Caso aconteça algum bug e o projetil saia do mapa
			try { 
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
		default: gp.projectileList.remove(this);
		}
		
		timer++;
	}
	
	@Override
	public abstract void draw(Graphics2D g2);// {
		// TODO Auto-generated method stub
		
	//}

	
	
}
