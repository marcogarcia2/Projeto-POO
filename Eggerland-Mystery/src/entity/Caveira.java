package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import object.OBJ_Bloco;

public class Caveira extends Entity{

	Random random;
	GamePanel gp;
	private long timer = 0, actionTimer = 0;
	public boolean awake = false;
	public BufferedImage sleep, angry1, angry2;
	
	public Caveira (GamePanel gp) {
		
		this.gp = gp;
		direction = "down";
		solidArea = new Rectangle(1,1,46,46);
//		solidAreaDefaultX = solidArea.x;
//		solidAreaDefaultY = solidArea.y;
//		
		random = new Random();
		collisionOn = true;
		speed = 3;
		getCaveiraImage();
	}
	
	
	public void getCaveiraImage() {
		try {
			sleep = ImageIO.read(getClass().getResourceAsStream("/monster/skull_sleep.png"));
			angry1 = ImageIO.read(getClass().getResourceAsStream("/monster/skull_angry_1.png"));
			angry2 = ImageIO.read(getClass().getResourceAsStream("/monster/skull_angry_2.png"));
			
		} catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;

		if (!awake) {
			image = sleep;
		}
		
		else if (awake) {
			
			if (timer < 50) {
				image = angry1;
			}
			else if (timer >= 50 && timer < 100) {
				image = angry2;
			}
			else {
				image = angry1;
				timer = 0;
			}
			
			timer++;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);	
		
	}
	
	private boolean checkMonsterCollision() {

		int monsterIndex = gp.cChecker.checkEntity(this, gp.monsterList);
		if (monsterIndex != 999) {

			return false;
		}

		return true;
	}
	
//	private boolean checkObjectCollision() {
//	    int futureX = this.x;
//	    int futureY = this.y;
//
//	    switch (direction) {
//	        case "up":
//	            futureY -= gp.tileSize / 30;
//	            break;
//	        case "down":
//	            futureY += gp.tileSize / 30;
//	            break;
//	        case "left":
//	            futureX -= gp.tileSize / 30;
//	            break;
//	        case "right":
//	            futureX += gp.tileSize / 30;
//	            break;
//	        default:
//	            break;
//	    }
//
//	    for (int i = 0; i < gp.obj[gp.currentMap].length; i++) {
//	        Entity obj = gp.obj[gp.currentMap][i];
//	        if (obj != null && obj != this) {
//
//	            // Verificar se a entidade é uma porta (Door ou DoorOpen)
//	            if (obj.name.equals("Door") || obj.name.equals("Chest")) {
//	                continue; // Ignorar a verificação de colisão com portas
//	            }
//
//	            int boxX = obj.x;
//	            int boxY = obj.y;
//	            int boxWidth = obj.solidArea.width;
//	            int boxHeight = obj.solidArea.height;
//
//	            if (futureX < boxX + boxWidth &&
//	                futureX + this.solidArea.width > boxX &&
//	                futureY < boxY + boxHeight &&
//	                futureY + this.solidArea.height > boxY) {
//
//	                // Verificar a direção para mover a outra entidade
//	                int otherBoxFutureX = obj.x;
//	                int otherBoxFutureY = obj.y;
//
//	                switch (direction) {
//	                    case "up":
//	                        otherBoxFutureY -= gp.tileSize / 30;
//	                        break;
//	                    case "down":
//	                        otherBoxFutureY += gp.tileSize / 30;
//	                        break;
//	                    case "left":
//	                        otherBoxFutureX -= gp.tileSize / 30;
//	                        break;
//	                    case "right":
//	                        otherBoxFutureX += gp.tileSize / 30;
//	                        break;
//	                    default:
//	                        break;
//	                }
//
//	                // Se não houver colisão, atualiza a posição da outra entidade
//	                if (!checkTileCollision(otherBoxFutureX, otherBoxFutureY)) {
//	                    obj.x = otherBoxFutureX;
//	                    obj.y = otherBoxFutureY;
//	                } else {
//	                    return true; // Há colisão com outra entidade
//	                }
//	            }
//	        }
//	    }
//	    
//	    return false;
//	}
	
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

	    for (int i = 0; i < gp.obj[gp.currentMap].length; i++) {
	        Entity obj = gp.obj[gp.currentMap][i];
	        if (obj != null && obj != this) {

	            // Verificar se a entidade é uma porta (Door ou DoorOpen)
	            if (obj.name.equals("Door") || obj.name.equals("Chest")) {
	                continue; // Ignorar a verificação de colisão com portas
	            }

	            // Ignorar colisão com objetos da classe OBJ_Bloco
	            if (obj instanceof OBJ_Bloco) {
	                continue;
	            }

	            int boxX = obj.x;
	            int boxY = obj.y;
	            int boxWidth = obj.solidArea.width;
	            int boxHeight = obj.solidArea.height;

	            if (futureX < boxX + boxWidth &&
	                futureX + this.solidArea.width > boxX &&
	                futureY < boxY + boxHeight &&
	                futureY + this.solidArea.height > boxY) {

	                // Verificar a direção para mover a outra entidade
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

	                // Se não houver colisão, atualiza a posição da outra entidade
	                if (!checkTileCollision(otherBoxFutureX, otherBoxFutureY)) {
	                    obj.x = otherBoxFutureX;
	                    obj.y = otherBoxFutureY;
	                } else {
	                    return true; // Há colisão com outra entidade
	                }
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
	
	private void moveEntity(String direction) {
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
	    
	    if ( !checkTileCollision(futureX, futureY) ) {
	        // Se não houver colisão, atualiza a posição
	        x = futureX;
	        y = futureY;
	    }
	}

	


	@Override
	public void update() {
		
		actionTimer++;
		
	    //if (gp.player.keyCount == 5 && !checkMonsterCollision() && !checkObjectCollision()) {
	    if (!checkMonsterCollision() && !checkObjectCollision()) {
		
	    	
	    	awake = true;
	    	
	    	if (actionTimer >= 30){
	    		
	    		actionTimer = 0;
	    	
		        int rand = random.nextInt(4);
		
		        switch (rand) {
		            case 0:
		                direction = "up";
		                break;
		            case 1:
		                direction = "down";
		                break;
		            case 2:
		                direction = "left";
		                break;
		            case 3:
		                direction = "right";
		                break;
		        }
	    	}
	        
	        moveEntity(direction);
	    }
	    
	}

}
