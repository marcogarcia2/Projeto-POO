package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Bullet extends Projectile{
	///////// AUMENTAR A AREA DO PROJETIL /////////////
	GamePanel gp;
	public BufferedImage vertical, horizontal;
	
	public OBJ_Bullet(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		name = "Bullet";
		speed = 30;
		timer = 0;
		
		getImage();
	}
	
	public void getImage() {
		
		try {
			vertical = ImageIO.read(getClass().getResourceAsStream("/object/medusa_shot_1.png"));
			horizontal = ImageIO.read(getClass().getResourceAsStream("/object/medusa_shot_2.png"));
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		BufferedImage image = null;
		
		switch(direction) {
		
		case "up": image = vertical; break;
		case "down": image = vertical; break;
		case "left": image = horizontal; break;
		case "right": image = horizontal; break;
		
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}	
}
