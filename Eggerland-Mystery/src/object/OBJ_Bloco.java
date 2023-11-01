package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Bloco extends SuperObject{

	public OBJ_Bloco() {
		
		name = "Door";
		try {
			image = ImageIO.read(getClass().getResource("/object/box.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}