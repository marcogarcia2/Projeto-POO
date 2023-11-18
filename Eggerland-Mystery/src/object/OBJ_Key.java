package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity{
	
	GamePanel gp;
	public BufferedImage image;
	
	public OBJ_Key(GamePanel gp) {
	
		this.gp = gp;
		
		//solidArea = new Rectangle(16,16,16,16);
		
		name = "Key";
		try {
			image = ImageIO.read(getClass().getResource("/object/coin_1.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//collision = true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
	
}
