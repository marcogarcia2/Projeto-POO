package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Bloco2 extends SuperObject{

	public OBJ_Bloco2() {
		
		name = "Bloco2";
		try {
			image = ImageIO.read(getClass().getResource("/object/box.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}