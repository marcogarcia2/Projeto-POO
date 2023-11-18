package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import object.OBJ_Bullet;
import object.OBJ_Fireball;

public class Medusa extends Entity {
	
	GamePanel gp;
	BufferedImage imgsleep, imgawake;
	int timer;
	
	public Medusa(GamePanel gp){
		
		this.gp = gp;
		this.direction = "down";
		this.solidArea = new Rectangle(4,4,40,40);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		awake = false;
		isBall = false;
		timer = 11;
		getMedusaImage();
	}
	
	public void getMedusaImage() {
		try {
			
			imgsleep = ImageIO.read(getClass().getResourceAsStream("/monster/medusa_sleep.png"));
			imgawake = ImageIO.read(getClass().getResourceAsStream("/monster/medusa_awake.png"));
		} catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	@Override
	public void draw(Graphics2D g2) {
		
		// TODO Auto-generated method stub
		BufferedImage image = null;
		
		if (!awake) image = imgsleep;
		else image = imgawake;

		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}

	void checkLine(Entity player) {
		
		int playerX = player.x + (player.solidArea.width) / 2;
		int playerY = player.y + (player.solidArea.height) / 2;
		
		
		if (playerX > x && playerX < x + solidArea.width){
			direction = "up";
			awake = true;
		}
		
		else if (playerY > y && playerY < y + solidArea.height) {
			awake = true;
			if (playerX < x) direction = "left";
			else if (playerX > x) direction = "right";
		}
		
		else {
			awake = false;
		}
		
		System.out.println(direction);
		
	}
	
	void shoot() {
		
		if (timer > 10) {
			projectile = new OBJ_Bullet(gp);
			projectile.set(x, y, direction, this);
			gp.projectileList.add(projectile);
			timer = 0;
		}
		timer++;
	}
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		checkLine(gp.player);
		if (awake) shoot();
	}	
}
