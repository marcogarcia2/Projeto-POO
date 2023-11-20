package main;

import entity.Entity;
//import exception.OutOfBoundsException;

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
			tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			
			break;
			
		case "down":
			entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
			
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
			
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
			
		//default: break;
		}
	}
	
	public int checkObject(Entity entity, boolean player) {
		//Essa funcao checa se o hitbox do personagem esta em interseccao com algum objeto.
		//Acho melhor ou diminur o hitbox do objeto, porque ele pega direto o objeto;
		
		int index = 999;//Representa o numero do objeto no vetor de objetos
	
		for(int i = 0; i < gp.obj[gp.currentMap].length; i++) {
			
			if(gp.obj[gp.currentMap][i] != null) {
				// Get entity's solid area position
				entity.solidArea.x = entity.x + entity.solidArea.x;
				entity.solidArea.y = entity.y + entity.solidArea.y;
				// Get the object's solid area positiond
				gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].x + gp.obj[gp.currentMap][i].solidArea.x;
				gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].y + gp.obj[gp.currentMap][i].solidArea.y;				

				
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
						if(gp.obj[gp.currentMap][i].collisionOn == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
						if(gp.obj[gp.currentMap][i].collisionOn == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
						if(gp.obj[gp.currentMap][i].collisionOn == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
						if(gp.obj[gp.currentMap][i].collisionOn == true) {
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
				gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].solidAreaDefaultX;
				gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].solidAreaDefaultY;
			} 
		}
		
		return index;
	}
	
	
	public int checkEntity(Entity entity, Entity[][] target) {
	    int index = 999; // Representa o número do objeto no vetor de objetos

	    for (int i = 0; i < target[gp.currentMap].length; i++) {
	        if (target[gp.currentMap][i] != null) {
	            // Get entity's solid area position
	            entity.solidArea.x = entity.x + entity.solidArea.x;
	            entity.solidArea.y = entity.y + entity.solidArea.y;

	            // Get the object's solid area position
	            target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].x + target[gp.currentMap][i].solidArea.x;
	            target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].y + target[gp.currentMap][i].solidArea.y;

	            switch (entity.direction) {
	                case "up":
	                    entity.solidArea.y -= entity.speed;
	                    if (entity.solidArea.intersects(target[gp.currentMap][i].solidArea)) {
	                        entity.collisionOn = true;
	                        index = i; // Atribui o índice ao encontrar uma colisão
	                    }
	                    break;

	                case "down":
	                    entity.solidArea.y += entity.speed;
	                    if (entity.solidArea.intersects(target[gp.currentMap][i].solidArea)) {
	                        entity.collisionOn = true;
	                        index = i; // Atribui o índice ao encontrar uma colisão
	                    }
	                    break;

	                case "left":
	                    entity.solidArea.x -= entity.speed;
	                    if (entity.solidArea.intersects(target[gp.currentMap][i].solidArea)) {
	                        entity.collisionOn = true;
	                        index = i; // Atribui o índice ao encontrar uma colisão
	                    }
	                    break;

	                case "right":
	                    entity.solidArea.x += entity.speed;
	                    if (entity.solidArea.intersects(target[gp.currentMap][i].solidArea)) {
	                        entity.collisionOn = true;
	                        index = i; // Atribui o índice ao encontrar uma colisão
	                    }
	                    break;
	            }

	            entity.solidArea.x = entity.solidAreaDefaultX;
	            entity.solidArea.y = entity.solidAreaDefaultY;
	            target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].solidAreaDefaultX;
	            target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].solidAreaDefaultY;
	        }
	    }

	    return index;
	}
	
	public boolean checkPlayer(Entity monster, Entity player) {
	    
	    // Get monster or projectile's solid area position
	    monster.solidArea.x = monster.x + monster.solidArea.x;
	    monster.solidArea.y = monster.y + monster.solidArea.y;

        // Get the player's solid area position
        player.solidArea.x = player.x + player.solidArea.width;
        player.solidArea.y = player.y + player.solidArea.height;
        
        if (monster.solidArea.intersects(player.solidArea)) { 
        	monster.collisionOn = true;
        	System.out.println("Acertou o player");
            return true;
        }
        
        return false;
	}
	
	public int checkKeyCollision(Entity entity, Entity key) {
	    int index = 999;

	    // Get entity's solid area position
	    entity.solidArea.x = entity.x + entity.solidArea.x;
	    entity.solidArea.y = entity.y + entity.solidArea.y;

	    // Get the Key's solid area position
	    key.solidArea.x = key.x + key.solidArea.x;
	    key.solidArea.y = key.y + key.solidArea.y;

	    if (entity.solidArea.intersects(key.solidArea)) {
	        entity.collisionOn = true;
	        index = 0; // Assumindo que só há uma Key no mapa
	    }

	    entity.solidArea.x = entity.solidAreaDefaultX;
	    entity.solidArea.y = entity.solidAreaDefaultY;
	    key.solidArea.x = key.solidAreaDefaultX;
	    key.solidArea.y = key.solidAreaDefaultY;

	    return index;
	}

}
