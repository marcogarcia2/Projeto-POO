package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Cobrinha extends Entity{

	GamePanel gp;
	private long timer = 0;
	public BufferedImage left1, right1, down1, down2, ball;
	
	public Cobrinha(GamePanel gp) {
		
		this.gp = gp;
		this.direction = "down";
		
		this.solidArea = new Rectangle(4,4,40,40);
		//solidAreaDefaultX = solidArea.x;
		//solidAreaDefaultY = solidArea.y;
		
		isBall = false;
		
		getCobrinhaImage();
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
	
	public void draw (Graphics2D g2) {
		
		BufferedImage image = null;
		
		if (isBall == false) {
			
			if (timer < 100) {
				image = left1;
			}
			else if (timer >= 100 && timer < 200) {
				image = down1;
			}
			else if (timer >= 200 && timer < 300) {
				image = down2;
			}
			else if (timer >= 300 && timer < 400) {
				image = right1;
			}
			else if (timer >= 400 && timer < 500) {
				image = down2;
			}
			else if (timer >= 500 && timer < 600) {
				image = down1;
			}
			else {
				image = left1;
				timer = 0;
			}
			timer++;
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
