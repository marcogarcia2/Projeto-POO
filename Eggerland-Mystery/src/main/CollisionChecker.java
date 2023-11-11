package main;

import entity.Entity;
import exception.OutOfBoundsException;

public class CollisionChecker {

	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) { // checa a colisao
		int entityLeftWorldX = entity.x + entity.solidArea.x;
		int entityRightWorldX = entity.x + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.y + entity.solidArea.y;
		int entityBottomWorldY = entity.y + entity.solidArea.y + entity.solidArea.height; //tem uma gambiarra aqui, foi adicionado o gp.tileSize pq o boneco tava indo um bloco a mais quando andando pra baixos
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		int tileNum1, tileNum2; // duas possíveis colisões
		
		switch(entity.direction) { //preve onde o jogador vai estar depois de se mover
		
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			
			break;
			
		case "down":
			entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
			
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
			
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
	}
	
	public int checkObject(Entity entity, boolean player) {
		//Essa funcao checa se o hitbox do personagem esta em interseccao com algum objeto.
		//Acho melhor ou diminur o hitbox do objeto, porque ele pega direto o objeto;
		
		int index = 999;//Representa o numero do objeto no vetor de objetos
		
		for(int i = 0; i < gp.obj.length; i++) {
			
			if(gp.obj[i] != null) {
				// Get entity's solid area position
				entity.solidArea.x = entity.x + entity.solidArea.x + 4;
				entity.solidArea.y = entity.y + entity.solidArea.y + 4;
				
				// Get the object's solid area positiond
				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;				

				
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					break;
					}
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			} 
		}
		
		return index;
	}
	
	/*
	 * public int checkEntity(Entity entity, Entity[] target) {
	 * 
	 * int index = 999;//Representa o numero do objeto no vetor de objetos
	 * 
	 * for(int i = 0; i < target.length; i++) {
	 * 
	 * if(target[i] != null) {
	 * 
	 * // Get entity's solid area position entity.solidArea.x = entity.x +
	 * entity.solidArea.x; entity.solidArea.y = entity.y + entity.solidArea.y;
	 * 
	 * // Get the object's solid area positiond target[i].solidArea.x = target[i].x
	 * + target[i].solidArea.x; target[i].solidArea.y = target[i].y +
	 * target[i].solidArea.y;
	 * 
	 * 
	 * switch(entity.direction) {
	 * 
	 * case "up": entity.solidArea.y -= entity.speed;
	 * if(entity.solidArea.intersects(target[i].solidArea)) { entity.collisionOn =
	 * true; } break;
	 * 
	 * case "down": entity.solidArea.y += entity.speed;
	 * if(entity.solidArea.intersects(target[i].solidArea)) { entity.collisionOn =
	 * true; } break;
	 * 
	 * case "left": entity.solidArea.x -= entity.speed;
	 * if(entity.solidArea.intersects(target[i].solidArea)) { entity.collisionOn =
	 * true; } break;
	 * 
	 * case "right": entity.solidArea.x += entity.speed;
	 * if(entity.solidArea.intersects(target[i].solidArea)) { entity.collisionOn =
	 * true; break; }
	 * 
	 * }
	 * 
	 * entity.solidArea.x = entity.solidAreaDefaultX; entity.solidArea.y =
	 * entity.solidAreaDefaultY; target[i].solidArea.x =
	 * target[i].solidAreaDefaultX; target[i].solidArea.y =
	 * target[i].solidAreaDefaultY; } }
	 * 
	 * return index; }
	 */
	
	public int checkEntity(Entity entity, Entity[] target) {
	    int index = 999; // Representa o número do objeto no vetor de objetos

	    for (int i = 0; i < target.length; i++) {
	        if (target[i] != null) {
	            // Get entity's solid area position
	            entity.solidArea.x = entity.x + entity.solidArea.x;
	            entity.solidArea.y = entity.y + entity.solidArea.y;

	            // Get the object's solid area position
	            target[i].solidArea.x = target[i].x + target[i].solidArea.x;
	            target[i].solidArea.y = target[i].y + target[i].solidArea.y;

	            switch (entity.direction) {
	                case "up":
	                    entity.solidArea.y -= entity.speed;
	                    if (entity.solidArea.intersects(target[i].solidArea)) {
	                        entity.collisionOn = true;
	                        index = i; // Atribui o índice ao encontrar uma colisão
	                    }
	                    break;

	                case "down":
	                    entity.solidArea.y += entity.speed;
	                    if (entity.solidArea.intersects(target[i].solidArea)) {
	                        entity.collisionOn = true;
	                        index = i; // Atribui o índice ao encontrar uma colisão
	                    }
	                    break;

	                case "left":
	                    entity.solidArea.x -= entity.speed;
	                    if (entity.solidArea.intersects(target[i].solidArea)) {
	                        entity.collisionOn = true;
	                        index = i; // Atribui o índice ao encontrar uma colisão
	                    }
	                    break;

	                case "right":
	                    entity.solidArea.x += entity.speed;
	                    if (entity.solidArea.intersects(target[i].solidArea)) {
	                        entity.collisionOn = true;
	                        index = i; // Atribui o índice ao encontrar uma colisão
	                    }
	                    break;
	            }

	            entity.solidArea.x = entity.solidAreaDefaultX;
	            entity.solidArea.y = entity.solidAreaDefaultY;
	            target[i].solidArea.x = target[i].solidAreaDefaultX;
	            target[i].solidArea.y = target[i].solidAreaDefaultY;
	        }
	    }

	    return index;
	}

}
