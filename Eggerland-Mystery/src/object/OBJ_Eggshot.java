package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Eggshot extends Projectile{

	GamePanel gp;
	public BufferedImage image, vertical, horizontal;
	
	public OBJ_Eggshot(GamePanel gp){
		
		super(gp);
		this.gp = gp;
		
		name = "Eggshot";
		speed = 8;
		timer = 0;
		
		getImage();
	}
	
	public void getImage() {
		
		try {
			vertical = ImageIO.read(getClass().getResourceAsStream("/object/eggshot_1.png"));
			horizontal = ImageIO.read(getClass().getResourceAsStream("/object/eggshot_2.png"));
			
		} catch(IOException e) {
			e.printStackTrace();	
		}
	}
	
	public void draw(Graphics2D g2) {
		
		if (this.direction == "up" || this.direction == "down") {
			image = vertical;
		}
		else if (this.direction == "left" || this.direction == "right") {
			image = horizontal;
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
		
	}
}
