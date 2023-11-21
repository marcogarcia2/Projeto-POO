package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entity {//Serve de base para todos os monstros e o player
	
    //Parametros de Entidade
	public int x,y;
	public int speed;
	public String direction;
	public String name;
        
	//Area Solida
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX, solidAreaDefaultY;
	
    //Colisao
	public boolean collisionOn = false;
	
	public Projectile projectile;

	public int spriteNumH, spriteNumV;
	
    //Classe de desenho e update, nao implementadas
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
