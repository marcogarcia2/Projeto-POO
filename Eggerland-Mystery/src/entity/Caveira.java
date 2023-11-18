package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Caveira extends Entity{

	GamePanel gp;
	private long timer = 0;
	public boolean awake = false;
	public BufferedImage sleep, angry1, angry2;
	
	public Caveira (GamePanel gp) {
		
		this.gp = gp;
		
		//solidArea = new Rectangle(4,4,40,40);
//		solidAreaDefaultX = solidArea.x;
//		solidAreaDefaultY = solidArea.y;
//		
		collisionOn = true;
		
		getCaveiraImage();
	}
	
	
	public void getCaveiraImage() {
		try {
			sleep = ImageIO.read(getClass().getResourceAsStream("/monster/skull_sleep.png"));
			angry1 = ImageIO.read(getClass().getResourceAsStream("/monster/skull_angry_1.png"));
			angry2 = ImageIO.read(getClass().getResourceAsStream("/monster/skull_angry_2.png"));
			
		} catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;

		if (!awake) {
			image = sleep;
		}
		
		else if (awake) {
			
			if (timer < 50) {
				image = angry1;
			}
			else if (timer >= 50 && timer < 100) {
				image = angry2;
			}
			else {
				image = angry1;
				timer = 0;
			}
			
			timer++;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);	
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
