package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Bloco extends Entity{

	GamePanel gp;
	BufferedImage image;	
	
	public OBJ_Bloco(GamePanel gp) {
		
		this.gp = gp;
		//direction = null;
		this.speed = gp.player.speed;
		
		solidArea = new Rectangle(0,0,48,48);
		
		name = "Bloco";
		try {
			image = ImageIO.read(getClass().getResource("/object/box.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collisionOn = true;
	}
	
	// move o bloco se não há colisão
	private void moveBlock(String direction) {
	    switch (direction) {
	        case "up":
	            y -= speed;
	            break;
	        case "down":
	            y += speed;
	            break;
	        case "left":
	            x -= speed;
	            break;
	        case "right":
	            x += speed;
	            break;
	    }
	    solidArea.x = x;
	    solidArea.y = y;
	}
	
	private boolean checkMonsterCollision() {
		if (direction != null) {
			int monster = gp.cChecker.checkEntity(this, gp.monsterList);
			if (monster != 999) return true;
		}
		
		return false;
	}
	
	private boolean checkObjectCollision() {
		
		int futureX = this.x;
		int futureY = this.y;
		
		switch(direction) {
		
		case "up":
			futureY -= gp.tileSize/30;
			break;
		
		case "down":
			futureY += gp.tileSize/30;
			break;
		
		case "left":
			futureX -= gp.tileSize/30;
			break;
			
		case "right":
			futureX += gp.tileSize/30;
			break;
			
		default: break;
		}
		
		// encontra o índice desta caixa
		
		int boxIndex = -1;
		for (int i = 0; i < gp.obj[gp.currentMap].length; i++) {
			if (gp.obj[gp.currentMap][i].equals(this)) {
				boxIndex = i;
				break;
			}
		}
		
		
		for (int i = 0; i < gp.obj[gp.currentMap].length; i++) {
	        Entity obj = gp.obj[gp.currentMap][i];
	        if (obj != null && i != boxIndex) {
	        
	            // Verificar se a entidade é uma porta (Door ou DoorOpen)
	            if (obj.name.equals("Door") || obj.name.equals("Chest")) {
	                continue; // Ignorar a verificação de colisão com portas
	            }
	            int boxX = obj.x;
	            int boxY = obj.y;
	            int boxWidth = obj.solidArea.width;
	            int boxHeight = obj.solidArea.height;

	            if (futureX < boxX + boxWidth &&
	                futureX + gp.obj[gp.currentMap][i].solidArea.width > boxX &&
	                futureY < boxY + boxHeight &&
	                futureY + gp.obj[gp.currentMap][i].solidArea.height > boxY) {
	                
	            	return true; // Há colisão com uma caixa
	            }
	        }
	    }
		
		
		return false;
	}
	
	private boolean checkTileCollision() {
		
		int futureX = this.x;
		int futureY = this.y;
		
		switch(direction) {
		
		case "up":
			futureY -= gp.tileSize/30;
			break;
		
		case "down":
			futureY += gp.tileSize/30;
			break;
		
		case "left":
			futureX -= gp.tileSize/30;
			break;
			
		case "right":
			futureX += gp.tileSize/30;
			break;
			
		default: break;
		}
		
		int boxLeftCol = futureX / gp.tileSize;
		int boxRightCol = (futureX + this.solidArea.width) / gp.tileSize;
		int boxTopRow = futureY / gp.tileSize;
		int boxBottomRow = (futureY + this.solidArea.height) / gp.tileSize;
		
		for (int col = boxLeftCol; col <= boxRightCol; col++) {
	        for (int row = boxTopRow; row <= boxBottomRow; row++) {
	            if (gp.tileM.tile[gp.tileM.mapTileNum[gp.currentMap][col][row]].collision) {
	                return true; // Há colisão
	            }
	        }
	    }
		
		return false;
	}	
	
	
	@Override
	public void update() {
		
	    if (direction != null) {
	    	//gp.cChecker.checkTile(this);
	    	
	    	if ( !checkMonsterCollision() && !checkTileCollision() && !checkObjectCollision() ) {
	    		System.out.println("B");
	    		moveBlock(direction);
	    	}
	        direction = null; // Redefine a direção após mover o bloco
	    }
	}



	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
	
}