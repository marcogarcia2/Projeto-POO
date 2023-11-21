package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Cobrinha extends Entity{ // Define o inimigo da 1a fase

	GamePanel gp;
	private long timer = 101;
	public BufferedImage left1, right1, down1, down2, image, ball;
	Random random;
	
	public Cobrinha(GamePanel gp) {
		
		this.gp = gp;
		this.direction = "down";
		
		//this.solidArea = new Rectangle(4,4,40,40);
		//solidAreaDefaultX = solidArea.x;
		//solidAreaDefaultY = solidArea.y;
		
		isBall = false;
		random = new Random();
		
		getCobrinhaImage();
		image = down1;
	}
	
	public void getCobrinhaImage() {
		try {
			left1 = ImageIO.read(getClass().getResourceAsStream("/monster/cobrinha_1.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/monster/cobrinha_2.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/monster/cobrinha_3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/monster/cobrinha_4.png"));
			ball = ImageIO.read(getClass().getResourceAsStream("/monster/egg_1.png"));

		} catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	// Aleatoriza as sprites da cobrinha
	public void draw (Graphics2D g2) {
		
		if (isBall == false) {
			
			if (timer > 100) {

				int num = random.nextInt(4);
				
				switch(num) {
				
				case 0:
					image = left1;
					break;
				
				case 1:
					image = right1;
					break;
					
				case 2:
					image = down1;
					break;
				
				case 3:
					image = down2;
					break;
				}
				timer = 0;
			}
			
			else timer++;
			
		}
		else {
			image = ball;
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
