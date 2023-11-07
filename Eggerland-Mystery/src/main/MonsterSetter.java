package main;

import entity.Caveira;
import entity.Cobrinha;

public class MonsterSetter {
	
	GamePanel gp;
	
	public MonsterSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setMonsters() {
		
		gp.monsterList[0] = new Cobrinha(gp);
		gp.monsterList[0].x = 2 * gp.tileSize;
		gp.monsterList[0].y = 11 * gp.tileSize;
		
		gp.monsterList[1] = new Cobrinha(gp);
		gp.monsterList[1].x = 6 * gp.tileSize;
		gp.monsterList[1].y = 11 * gp.tileSize;
		
		gp.monsterList[2] = new Cobrinha(gp);
		gp.monsterList[2].x = 11 * gp.tileSize;
		gp.monsterList[2].y = 7 * gp.tileSize;
		
		/*
		gp.monsterList[1] = new Caveira(gp);
		gp.monsterList[1].x = 3 * gp.tileSize;
		gp.monsterList[1].y = 1 * gp.tileSize;
		*/
		
		
	}
}
