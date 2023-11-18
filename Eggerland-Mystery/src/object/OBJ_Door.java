package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Door extends Entity{
	
	GamePanel gp;
	public BufferedImage image;
	
	public OBJ_Door(GamePanel gp) {
		
		this.gp = gp;
		
		name = "Door";
		try {
			image = ImageIO.read(getClass().getResource("/object/door.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		collisionOn = true;
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
