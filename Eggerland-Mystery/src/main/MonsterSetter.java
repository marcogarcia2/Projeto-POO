package main;

import entity.Caveira;
import entity.Cobrinha;

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
		
		
		gp.monsterList[mapNum][1] = new Caveira(gp);
		gp.monsterList[mapNum][1].x = 3 * gp.tileSize;
		gp.monsterList[mapNum][1].y = 1 * gp.tileSize;
			
	}
}
