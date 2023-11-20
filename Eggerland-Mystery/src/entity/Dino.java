package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import object.OBJ_Fireball;

public class Dino extends Entity {
	
	GamePanel gp;
	BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	int timer, dinoIndex;
	
	public Dino(GamePanel gp, String direction){
		
		this.gp = gp;
		this.direction = direction;
		//this.solidArea = new Rectangle(4,4,40,40);
		awake = false;
		isBall = false;
		timer = 31;
		
		getDinoImage();
		
	}
	
	public void getDinoImage() {
		try {
			
			left1 = ImageIO.read(getClass().getResourceAsStream("/monster/dino_sleep_left.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/monster/dino_awake_left.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/monster/dino_sleep_right.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/monster/dino_awake_right.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/monster/dino_sleep_up.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/monster/dino_awake_up.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/monster/dino_sleep_down.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/monster/dino_awake_down.png"));
			
		} catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	@Override
	public void draw(Graphics2D g2) {
		
		// TODO Auto-generated method stub
		BufferedImage image = null;
		
		switch(direction) {
		
		case "up":
			if (!awake) image = up1;
			else image = up2;
			break;
		
		case "down":
			if (!awake) image = down1;
			else image = down2;
			break;
		
		case "left":
			if (!awake) image = left1;
			else image = left2;
			break;
		
		case "right":
			if (!awake) image = right1;
			else image = right2;
			break;
		}

		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (gp.player.keyCount > 0) {
			awake = true;
		}
		
		if (awake && checkLine(gp.player)) shoot();
	}	
	
	private void shoot() {
		
	
		if (awake && timer > 30) {
			
			projectile = new OBJ_Fireball(this.gp);
			projectile.set(this.x, this.y, this.direction, this);
			gp.projectileList.add(projectile);
			timer = 0;
		}
		timer++;
	}
	
	boolean checkLine (Entity player) {
		
		int playerX = player.x + (player.solidArea.width) / 2;
		int playerY = player.y + (player.solidArea.height) / 2;
		
		switch(direction) {
		
		case "up":
			if (playerX > x && playerX < x + solidArea.width && y > playerY)
				return true;
			break;
			
		case "down":
			if (playerX > x && playerX < x + solidArea.width && y < playerY)
				return true;
			break;
			
			
		case "left":
			if (playerY > y && playerY < y + solidArea.height && x > playerX)
				return true;
			break;
			
		case "right":
			if (playerY > y && playerY < y + solidArea.height && x < playerX)
				return true;
			break;	
		}
				
		return false;
	}
}
