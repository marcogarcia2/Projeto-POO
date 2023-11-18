package object;

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Bloco extends SuperObject{

	GamePanel gp;
	
	public OBJ_Bloco(GamePanel gp) {
		
		this.gp = gp;
		
		solidArea = new Rectangle(0,0,48,48);
		
		name = "Bloco";
		try {
			image = ImageIO.read(getClass().getResource("/object/box.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
	
	// para conseguir detectar a colisão
	public void update() {
		
		solidArea.x = worldX;
		solidArea.y = worldY;		
		
	}
	
}