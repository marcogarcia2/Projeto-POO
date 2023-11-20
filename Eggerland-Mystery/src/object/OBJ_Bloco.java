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
		
		solidArea = new Rectangle(1,1,46,46);
		
		name = "Box";
		try {
			image = ImageIO.read(getClass().getResource("/object/box.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		collisionOn = true;
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

		    switch (direction) {
		        case "up":
		            futureY -= gp.tileSize / 30;
		            break;

		        case "down":
		            futureY += gp.tileSize / 30;
		            break;

		        case "left":
		            futureX -= gp.tileSize / 30;
		            break;

		        case "right":
		            futureX += gp.tileSize / 30;
		            break;

		        default:
		            break;
		    }

		    int boxIndex = -1;
		    for (int i = 0; i < gp.obj[gp.currentMap].length; i++) {
		        if (gp.obj[gp.currentMap][i] != null) {
		            if (gp.obj[gp.currentMap][i].equals(this)) {
		                boxIndex = i;
		                break;
		            }
		        }
		    }

		    for (int i = 0; i < gp.obj[gp.currentMap].length; i++) {
		        Entity obj = gp.obj[gp.currentMap][i];
		        if (obj != null && i != boxIndex) {

		            // Verificar se a entidade é uma porta (Door ou DoorOpen)
		            if (obj.name == "Door" || obj.name == "Chest") {
		                continue; // Ignorar a verificação de colisão com portas
		            }

		            int boxX = obj.x;
		            int boxY = obj.y;
		            int boxWidth = obj.solidArea.width;
		            int boxHeight = obj.solidArea.height;

		            if (futureX < boxX + boxWidth &&
		                futureX + this.solidArea.width > boxX &&
		                futureY < boxY + boxHeight &&
		                futureY + this.solidArea.height > boxY) {

		                // Verificar a direção para mover a outra caixa
		                int otherBoxFutureX = obj.x;
		                int otherBoxFutureY = obj.y;

		                switch (direction) {
		                    case "up":
		                        otherBoxFutureY -= gp.tileSize / 30;
		                        break;

		                    case "down":
		                        otherBoxFutureY += gp.tileSize / 30;
		                        break;

		                    case "left":
		                        otherBoxFutureX -= gp.tileSize / 30;
		                        break;

		                    case "right":
		                        otherBoxFutureX += gp.tileSize / 30;
		                        break;

		                    default:
		                        break;
		                }

		                // Se não houver colisão, atualiza a posição da outra caixa
		                if (!checkTileCollision(otherBoxFutureX, otherBoxFutureY)) {
		                    obj.x = otherBoxFutureX;
		                    obj.y = otherBoxFutureY;
		                }

		                return true; // Há colisão com outra caixa
		            }
		        }
		    }

		    return false;
		}

		private boolean checkTileCollision(int futureX, int futureY) {
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
		
		private void moveBlock(String direction) {
		    int futureX = x;
		    int futureY = y;

		    switch (direction) {
		        case "up":
		            futureY -= speed;
		            break;
		        case "down":
		            futureY += speed;
		            break;
		        case "left":
		            futureX -= speed;
		            break;
		        case "right":
		            futureX += speed;
		            break;
		    }

		    if (!checkTileCollision(futureX, futureY)) {
		        // Se não houver colisão, atualiza a posição
		        x = futureX;
		        y = futureY;
		    }
		}

	
	@Override
	public void update() {
		
	    if (direction != null) {
	    	//gp.cChecker.checkTile(this);
	    	
	    	if ( !checkMonsterCollision() && !checkObjectCollision() ) {
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