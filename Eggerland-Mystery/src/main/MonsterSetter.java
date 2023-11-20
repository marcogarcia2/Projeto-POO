package main;

import entity.Caveira;
import entity.Cobrinha;
import entity.Dino;
import entity.Medusa;

public class MonsterSetter {
	
	GamePanel gp;
	
	public MonsterSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setMonsters() {
		
		int mapNum = 0;
		
		gp.monsterList[mapNum][0] = new Cobrinha(gp);
		gp.monsterList[mapNum][0].x = 2 * gp.tileSize;
		gp.monsterList[mapNum][0].y = 11 * gp.tileSize;
		
		gp.monsterList[mapNum][1] = new Cobrinha(gp);
		gp.monsterList[mapNum][1].x = 6 * gp.tileSize;
		gp.monsterList[mapNum][1].y = 11 * gp.tileSize;
		
		gp.monsterList[mapNum][2] = new Cobrinha(gp);
		gp.monsterList[mapNum][2].x = 11 * gp.tileSize;
		gp.monsterList[mapNum][2].y = 7 * gp.tileSize;
		
		
		mapNum = 1;
		
		
		gp.monsterList[mapNum][0] = new Caveira(gp);
		gp.monsterList[mapNum][0].x = 5 * gp.tileSize;
		gp.monsterList[mapNum][0].y = 6 * gp.tileSize;
		
		gp.monsterList[mapNum][1] = new Caveira(gp);
		gp.monsterList[mapNum][1].x = 7 * gp.tileSize;
		gp.monsterList[mapNum][1].y = 6 * gp.tileSize;
		
		
		mapNum = 2;
		
		gp.monsterList[mapNum][0] = new Dino(gp, "up");
		gp.monsterList[mapNum][0].x = 4 * gp.tileSize;
		gp.monsterList[mapNum][0].y = 8 * gp.tileSize;
		
		gp.monsterList[mapNum][1] = new Dino(gp, "left");
		gp.monsterList[mapNum][1].x = 8 * gp.tileSize;
		gp.monsterList[mapNum][1].y = 8 * gp.tileSize;
		
		gp.monsterList[mapNum][2] = new Dino(gp, "down");
		gp.monsterList[mapNum][2].x = 8 * gp.tileSize;
		gp.monsterList[mapNum][2].y = 4 * gp.tileSize;
		
		gp.monsterList[mapNum][3] = new Dino(gp, "right");
		gp.monsterList[mapNum][3].x = 4 * gp.tileSize;
		gp.monsterList[mapNum][3].y = 4 * gp.tileSize;
		
		mapNum = 3;
		
		gp.monsterList[mapNum][0] = new Medusa(gp);
		gp.monsterList[mapNum][0].x = 4 * gp.tileSize;
		gp.monsterList[mapNum][0].y = 7 * gp.tileSize;
		
		gp.monsterList[mapNum][1] = new Medusa(gp);
		gp.monsterList[mapNum][1].x = 8 * gp.tileSize;
		gp.monsterList[mapNum][1].y = 7 * gp.tileSize;
			
	}
}
