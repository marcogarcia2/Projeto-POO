package entity;


import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.MapFileManager;
import object.OBJ_Chest;
import object.OBJ_Eggshot;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;
	public int shotCount, keyCount;
	public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, right1, right2;

	public boolean canShoot;
	public int shotDelay;
	long timeShot;
	
	int timerV, timerH;
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();		
	}
	public void setDefaultValues() {
		/*
		 switch(gp.currentMap) {
		case 0: x = 1*gp.tileSize; y = 1*gp.tileSize; break;
		case 1: x = 9*gp.tileSize; y = 9*gp.tileSize; break;
		case 2: x = 1*gp.tileSize; y = 1*gp.tileSize; break;
		case 3: x = 1*gp.tileSize; y = 1*gp.tileSize; break;
		 */
		
		switch(MapFileManager.readCurrentMap()) {
		//posiciona o boneco de acordo com o nivel;
		case 0:	x = gp.tileSize; y = gp.tileSize; break;
		case 1:	x = 9 * gp.tileSize; y = 3 * gp.tileSize; break;
		case 2:	x = 2 * gp.tileSize; y = 2 * gp.tileSize; break;
		case 3:	x = 6 * gp.tileSize; y = 3 * gp.tileSize; break;
		}
		

		solidArea = new Rectangle(4,4,40,42);
		speed = 3;
		direction = "down";
		canShoot = false;
		shotDelay = 400;
		shotCount = 0;
		keyCount = 0;
		spriteNumH = 1;
		spriteNumV = 1;
		timerV = 0;
		timerH = 0;
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
		
		//solidArea.x = x;
		//solidArea.y = y;
		
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
		try {
			gp.cChecker.checkTile(this);
		} catch(ArrayIndexOutOfBoundsException e) {
			
		}
		//CHECK OBJECT COLLISION
		int objIndex = gp.cChecker.checkObject(this, true);
		pickUpObject(objIndex);
		
		//CHECK MONSTER COLLISION
		int monsterIndex = gp.cChecker.checkEntity(this, gp.monsterList);
		if (monsterIndex != 999 && gp.currentMap != 0) {
			//life--;
			gp.resetGame();
		}
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			
			//IF COLLISION IS FALSE, PLAYER CAN MOVE
			if(collisionOn == false) {
				
				switch(direction) {
				
				case "up": y -= speed; break;
				
				case "down": y += speed; break;
				
				case "left": x -= speed; break;
				
				case "right": x += speed; break;
				
				}
			}
			
			timerV++;
			timerH++;
						  
			if (timerV < 7) 						spriteNumV = 1;
			else if (timerV >= 7 && timerV < 14) 	spriteNumV = 2;
			else if (timerV >= 14 && timerV < 21)	spriteNumV = 3;
			else if (timerV >= 21 && timerV < 28) 	spriteNumV = 2;
			else {
				timerV  = 0;
			}
			
			if (timerH < 7) 						spriteNumH = 1;
			else if (timerH >= 7 && timerH < 14) 	spriteNumH = 2;
			else {
				timerH = 0;
			}
			
			switch(gp.currentMap) {
			
			case 0:
				if(keyCount >= 6) {
					
					gp.obj[gp.currentMap][2] = new OBJ_Chest(gp);
					gp.obj[gp.currentMap][2].x = 9 * gp.tileSize;
					gp.obj[gp.currentMap][2].y = 6 * gp.tileSize;
					
				}
				break;
			case 1:
				if(keyCount >= 5) {
					
					gp.obj[gp.currentMap][2] = new OBJ_Chest(gp);
					gp.obj[gp.currentMap][2].x = 9 * gp.tileSize;
					gp.obj[gp.currentMap][2].y = 9 * gp.tileSize;
					
				}
				break;
				
			case 2:
				if(keyCount >= 1) {
					
					gp.obj[gp.currentMap][2] = new OBJ_Chest(gp);
					gp.obj[gp.currentMap][2].x = 10 * gp.tileSize;
					gp.obj[gp.currentMap][2].y = 10 * gp.tileSize;
					
				}
				break;
				
			case 3:
				if(keyCount >= 3) {
					
					gp.obj[gp.currentMap][2] = new OBJ_Chest(gp);
					gp.obj[gp.currentMap][2].x = 6 * gp.tileSize;
					gp.obj[gp.currentMap][2].y = 10 * gp.tileSize;
					
				}
				break;
				
			}
		}
		
		if (gp.keyH.spacePressed && canShoot && shotCount > 0) {
			
			canShoot = false;
			shotCount--;
			timeShot = System.currentTimeMillis();
			projectile = new OBJ_Eggshot(this.gp);
			projectile.set(this.x, this.y, this.direction, this);
			gp.projectileList.add(projectile);
			
		}
		
		if (!canShoot) {
			
			if (System.currentTimeMillis() - timeShot > shotDelay) {
				canShoot = true;
			}
		}
	}
	
	public void pickUpObject(int i) {
	//Essa funcao eh responsavel pela interacao entre jogador e objeto	
		
		if(i != 999) {
			
			String objectName = gp.obj[gp.currentMap][i].name;
			
			switch(objectName) {
			
			case "Key":
				if(gp.currentMap == 0) shotCount += 2;
				keyCount += 1;
				gp.obj[gp.currentMap][i] = null;
				System.out.println("Keys: " + shotCount);
				gp.ui.showMessage("You got a key!");
				break;
				
			case "Door":
				if(shotCount > 0) {
					gp.obj[gp.currentMap][i] = null;
					shotCount--;
					gp.ui.showMessage("You opened the door");
				}
				else {
					gp.ui.showMessage("You need a key!");
				}
				System.out.println("Keys: " + shotCount);
				break;
				
			case "Chest": // Porta Final do Nivel
				if(gp.currentMap < 3) {
				keyCount = 0;
				gp.currentMap ++;
				MapFileManager.writeCurrentMap(gp.currentMap);
				gp.resetGame();
				}
				else {
					gp.ui.gameFinished = true;
				}
				break;
				
			//controla a movimentacao do bloco verde
			case "Box":
				
				switch(direction) {
				
				case "up":
					gp.obj[gp.currentMap][i].direction = "up";
					break;
					
				case "down":
					gp.obj[gp.currentMap][i].direction = "down";
					break;
					
				case "left":
					gp.obj[gp.currentMap][i].direction = "left";
					break;
					
				case "right":
					gp.obj[gp.currentMap][i].direction = "right";
					break;
				}
			}
		}
	}
	
	/*
	 * void interactMonster(int i) { if (i != 999) {
	 * System.out.println("You are hitting a monster!"); } }
	 */
	
	
	public void draw(Graphics2D g2) {

		BufferedImage image = null;
		
		switch(direction) {
		
		case "up":
			if(keyH.upPressed == false) {
				image = up2;
				timerV = 0;
			}
			else if(spriteNumV == 1) image = up1;
			else if(spriteNumV == 2) image = up2;
			else if(spriteNumV == 3) image = up3;
			
			break;
			
		case "down":
			if(keyH.downPressed == false) {
				image = down2;
				timerV = 0;
			}
			else if(spriteNumV == 1) image = down1;
			else if(spriteNumV == 2) image = down2;
			else if(spriteNumV == 3) image = down3;
			
			break;
			
		case "left":
			if(keyH.leftPressed == false) {
				image = left2;
				timerH = 0;
			}
			else if(spriteNumH == 1) image = left1;
			else if(spriteNumH == 2) image = left2;
			
			break;
			
		case "right":
			
			if(keyH.rightPressed == false) {
				image = right2;
				timerH = 0;
			}
			else if(spriteNumH == 1) image = right1;
			else if(spriteNumH == 2) image = right2;
			
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}
	
}
