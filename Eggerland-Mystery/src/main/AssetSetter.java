package main;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Bloco;
import object.OBJ_Bloco2;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {//Posiciona o Objeto na coordenada desejada OBS: ler o arquivo txt do mapa para saber onde posicionar
		
		int mapNum = 0;
		
		gp.obj[mapNum][0] = new OBJ_Key();
		gp.obj[mapNum][0].worldX = 3 * gp.tileSize;
		gp.obj[mapNum][0].worldY = 5 * gp.tileSize;
		
		gp.obj[mapNum][1] = new OBJ_Door();
		gp.obj[mapNum][1].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][1].worldY = 1 * gp.tileSize;
		
		gp.obj[mapNum][3] = new OBJ_Key();
		gp.obj[mapNum][3].worldX = 3 * gp.tileSize; 
		gp.obj[mapNum][3].worldY = 7 * gp.tileSize;
		
		
		gp.obj[mapNum][5] = new OBJ_Key();
		gp.obj[mapNum][5].worldX = 7 * gp.tileSize;
		gp.obj[mapNum][5].worldY = 7 * gp.tileSize;
		
		gp.obj[mapNum][6] = new OBJ_Key();
		gp.obj[mapNum][6].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][6].worldY = 8 * gp.tileSize;
		
		gp.obj[mapNum][7] = new OBJ_Key();
		gp.obj[mapNum][7].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][7].worldY = 9 * gp.tileSize;
		
		gp.obj[mapNum][8] = new OBJ_Key();
		gp.obj[mapNum][8].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][8].worldY = 11 * gp.tileSize;
		
		gp.obj[mapNum][9] = new OBJ_Bloco();
		gp.obj[mapNum][9].worldX = 3 * gp.tileSize;
		gp.obj[mapNum][9].worldY = 6 * gp.tileSize;
		
		
		gp.obj[mapNum][4] = new OBJ_Bloco();
		gp.obj[mapNum][4].worldX = 7 * gp.tileSize;
		gp.obj[mapNum][4].worldY = 6 * gp.tileSize;
		
			
		
		mapNum = 1;
		
		gp.obj[mapNum][0] = new OBJ_Bloco();
		gp.obj[mapNum][0].worldX = 3 * gp.tileSize;
		gp.obj[mapNum][0].worldY = 9 * gp.tileSize;
		
		gp.obj[mapNum][1] = new OBJ_Key();
		gp.obj[mapNum][1].worldX = 3 * gp.tileSize; 
		gp.obj[mapNum][1].worldY = 10 * gp.tileSize;
		
		gp.obj[mapNum][2] = new OBJ_Bloco();
		gp.obj[mapNum][2].worldX = 3 * gp.tileSize;
		gp.obj[mapNum][2].worldY = 11 * gp.tileSize;
		
		gp.obj[mapNum][3] = new OBJ_Key();
		gp.obj[mapNum][3].worldX = 3 * gp.tileSize; 
		gp.obj[mapNum][3].worldY = 10 * gp.tileSize;
		
		gp.obj[mapNum][4] = new OBJ_Key();
		gp.obj[mapNum][4].worldX = 3 * gp.tileSize; 
		gp.obj[mapNum][4].worldY = 10 * gp.tileSize;
		
		gp.obj[mapNum][5] = new OBJ_Key();
		gp.obj[mapNum][5].worldX = 3 * gp.tileSize; 
		gp.obj[mapNum][5].worldY = 10 * gp.tileSize;
		
		gp.obj[mapNum][6] = new OBJ_Key();
		gp.obj[mapNum][6].worldX = 3 * gp.tileSize; 
		gp.obj[mapNum][6].worldY = 10 * gp.tileSize;
		
		gp.obj[mapNum][7] = new OBJ_Key();
		gp.obj[mapNum][7].worldX = 3 * gp.tileSize; 
		gp.obj[mapNum][7].worldY = 10 * gp.tileSize;
		
		
		
		
		
				
	}
}
 