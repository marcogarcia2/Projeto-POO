package main;

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
		
	
		
		
		
	}
}
