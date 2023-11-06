package entity;


import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Chest;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;
	public int hasKey = 0;
	public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, right1, right2;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		solidArea = new Rectangle(8,8,32,32);
			/*
		    solidArea.x = 0;
			solidArea.y = 0;
			solidArea.width = gp.tileSize; //Esses valores determinam o hitbox do personagem, 0, 0 e (gp.tileSize) por padrao
			solidArea.width = gp.tileSize;
			*/
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		
		x = 48;
		y = 48;
		speed = 4;
		direction = "down";
	}
	public void getPlayerImage() {
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/lolo_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/lolo_up_2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/lolo_up_3.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/lolo_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/lolo_down_2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player/lolo_down_3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/lolo_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/lolo_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/lolo_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/lolo_right_2.png"));

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			if(keyH.upPressed == true) {
				direction = "up";
			}
			else if(keyH.downPressed == true) {
				direction = "down";
			}
			else if(keyH.leftPressed == true) {
				direction = "left";
			}
			else if(keyH.rightPressed == true) {
				direction = "right";
			}
			
			//CHECK COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			//CHECK OBJECT COLLISION
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			//CHECK MONSTER COLLISION
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monsterList);
			interactMonster(monsterIndex);
			
			//IF COLLISION IS FALSE, PLAYER CAN MOVE
			if(collisionOn == false) {
				
				switch(direction) {
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
				
			}
	
			
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 3;
				}
				else if(spriteNum == 3) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			
			if(hasKey == 6) {
				gp.obj[2] = new OBJ_Chest();
				gp.obj[2].worldX = 9 * gp.tileSize;
				gp.obj[2].worldY = 6 * gp.tileSize;
				
			}
		}
	}
	
	public void pickUpObject(int i) {
	//Essa funcao eh responsavel pela interacao entre jogador e objeto	
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				hasKey++;
				gp.obj[i] = null;
				System.out.println("Keys: " + hasKey);
				gp.ui.showMessage("You got a key!");
				break;
			case "Door":
				if(hasKey > 0) {
					gp.obj[i] = null;
					hasKey--;
					gp.ui.showMessage("You opened the door");
				}
				else {
					gp.ui.showMessage("You need a key!");
				}
				System.out.println("Keys: " + hasKey);
				break;
			case "Boots":
				speed += 2;
				gp.obj[i] = null;
				gp.ui.showMessage("Speed Up!");
				break;
			case "Chest":
				gp.ui.gameFinished = true;
				break;
				
			//controla a movimentacao do bloco verde
			case "Bloco":
				switch(direction) {
				case "up":
					gp.obj[i].worldY = gp.obj[i].worldY - gp.tileSize/4;
					break;
				case "down":
					gp.obj[i].worldY = gp.obj[i].worldY + gp.tileSize/4;
					break;
				case "left":
					gp.obj[i].worldX = gp.obj[i].worldX - gp.tileSize/4;
					break;
				case "right":
					gp.obj[i].worldX = gp.obj[i].worldX + gp.tileSize/4;
					break;
				}
			}
		}
	}
	
	void interactMonster(int i) {
		if (i != 999) {
			System.out.println("You are hitting a monster!");
		}
	}
	
	
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			if(spriteNum == 3) {
				image = up3;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			if(spriteNum == 3) {
				image = down3;
			}
			break;
		case "left":
			if(spriteNum == 1 || spriteNum == 3) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1 || spriteNum == 3) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}
	
}
