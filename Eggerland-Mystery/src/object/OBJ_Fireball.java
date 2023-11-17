package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Fireball extends Projectile{

	GamePanel gp;
	public BufferedImage up, left, right, down;
	
	public OBJ_Fireball(GamePanel gp){
		
		super(gp);
		this.gp = gp;
		
		name = "Fireball";
		speed = 20;
		timer = 0;
		
		getImage();
	}
	
	public void getImage() {
		
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/object/fireball_up.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/object/fireball_down.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/object/fireball_left.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/object/fireball_right.png"));
			
		} catch(IOException e) {
			e.printStackTrace();	
		}
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		switch(direction) {
		
		case "up": image = up; break;
		case "down": image = down; break;
		case "left": image = left; break;
		case "right": image = right; break;
		
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}
