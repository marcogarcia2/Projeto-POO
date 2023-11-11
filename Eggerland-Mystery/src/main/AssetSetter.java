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
		
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 3 * gp.tileSize;
		gp.obj[0].worldY = 5 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Door();
		gp.obj[1].worldX = 14 * gp.tileSize;
		gp.obj[1].worldY = 1 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Key();
		gp.obj[3].worldX = 3 * gp.tileSize; 
		gp.obj[3].worldY = 7 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Boots();
		gp.obj[4].worldX = 11 * gp.tileSize;
		gp.obj[4].worldY = 6 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Key();
		gp.obj[5].worldX = 7 * gp.tileSize;
		gp.obj[5].worldY = 7 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Key();
		gp.obj[6].worldX = 11 * gp.tileSize;
		gp.obj[6].worldY = 8 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Key();
		gp.obj[7].worldX = 11 * gp.tileSize;
		gp.obj[7].worldY = 9 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Key();
		gp.obj[8].worldX = 11 * gp.tileSize;
		gp.obj[8].worldY = 11 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Bloco();
		gp.obj[9].worldX = 3 * gp.tileSize;
		gp.obj[9].worldY = 6 * gp.tileSize;
		
		gp.obj[10] = new OBJ_Bloco();
		gp.obj[10].worldX = 7 * gp.tileSize;
		gp.obj[10].worldY = 6 * gp.tileSize;
		
	}
}
