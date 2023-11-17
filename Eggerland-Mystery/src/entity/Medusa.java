package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import object.OBJ_Fireball;

public class Medusa extends Entity {
	
	GamePanel gp;
	BufferedImage imgsleep, imgawake;
	int timer;
	
	public Medusa(GamePanel gp){
		
		this.gp = gp;
		this.direction = "down";
		this.solidArea = new Rectangle(4,4,40,40);
		awake = false;
		isBall = false;
		timer = 0;
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
		else 		image = imgawake;

		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}	
}
