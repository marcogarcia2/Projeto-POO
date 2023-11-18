package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Bloco;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {//Posiciona o Objeto na coordenada desejada OBS: ler o arquivo txt do mapa para saber onde posicionar
		
		int mapNum = 0;
		
		gp.obj[mapNum][0] = new OBJ_Key(gp);
		gp.obj[mapNum][0].x = 3 * gp.tileSize;
		gp.obj[mapNum][0].y = 5 * gp.tileSize;
		
		gp.obj[mapNum][1] = new OBJ_Door(gp);
		gp.obj[mapNum][1].x = 14 * gp.tileSize;
		gp.obj[mapNum][1].y = 1 * gp.tileSize;
		
		gp.obj[mapNum][3] = new OBJ_Key(gp);
		gp.obj[mapNum][3].x = 3 * gp.tileSize; 
		gp.obj[mapNum][3].y = 7 * gp.tileSize;
		
		gp.obj[mapNum][5] = new OBJ_Key(gp);
		gp.obj[mapNum][5].x = 7 * gp.tileSize;
		gp.obj[mapNum][5].y = 7 * gp.tileSize;
		
		gp.obj[mapNum][6] = new OBJ_Key(gp);
		gp.obj[mapNum][6].x = 11 * gp.tileSize;
		gp.obj[mapNum][6].y = 8 * gp.tileSize;
		
		gp.obj[mapNum][7] = new OBJ_Key(gp);
		gp.obj[mapNum][7].x = 11 * gp.tileSize;
		gp.obj[mapNum][7].y = 9 * gp.tileSize;
		
		gp.obj[mapNum][8] = new OBJ_Key(gp);
		gp.obj[mapNum][8].x = 11 * gp.tileSize;
		gp.obj[mapNum][8].y = 11 * gp.tileSize;
		
		gp.obj[mapNum][9] = new OBJ_Bloco(gp);
		gp.obj[mapNum][9].x = 3 * gp.tileSize;
		gp.obj[mapNum][9].y = 6 * gp.tileSize;
		
		gp.obj[mapNum][10] = new OBJ_Bloco(gp);
		gp.obj[mapNum][10].x = 7 * gp.tileSize;
		gp.obj[mapNum][10].y = 6 * gp.tileSize;
		
	    mapNum = 1;
	   
	    gp.obj[mapNum][0] = new OBJ_Key(gp);
		gp.obj[mapNum][0].x = 3 * gp.tileSize;
		gp.obj[mapNum][0].y = 1 * gp.tileSize;
		
		gp.obj[mapNum][1] = new OBJ_Key(gp);
		gp.obj[mapNum][1].x = 3 * gp.tileSize;
		gp.obj[mapNum][1].y = 10 * gp.tileSize;
		
		gp.obj[mapNum][2] = new OBJ_Key(gp);
		gp.obj[mapNum][2].x = 5 * gp.tileSize;
		gp.obj[mapNum][2].y = 7 * gp.tileSize;
		
		gp.obj[mapNum][3] = new OBJ_Key(gp);
		gp.obj[mapNum][3].x = 7 * gp.tileSize;
		gp.obj[mapNum][3].y = 11 * gp.tileSize;
		
		gp.obj[mapNum][4] = new OBJ_Key(gp);
		gp.obj[mapNum][4].x = 7 * gp.tileSize;
		gp.obj[mapNum][4].y = 1 * gp.tileSize;
		
		gp.obj[mapNum][5] = new OBJ_Bloco(gp);
		gp.obj[mapNum][5].x = 3 * gp.tileSize;
		gp.obj[mapNum][5].y = 11 * gp.tileSize;
		
		gp.obj[mapNum][6] = new OBJ_Bloco(gp);
		gp.obj[mapNum][6].x = 6 * gp.tileSize;
		gp.obj[mapNum][6].y = 7 * gp.tileSize;
			
		gp.obj[mapNum][7] = new OBJ_Bloco(gp);
		gp.obj[mapNum][7].x = 9 * gp.tileSize;
		gp.obj[mapNum][7].y = 6 * gp.tileSize;
		
		gp.obj[mapNum][8] = new OBJ_Bloco(gp);
		gp.obj[mapNum][8].x = 8 * gp.tileSize;
		gp.obj[mapNum][8].y = 3 * gp.tileSize;
		
		gp.obj[mapNum][10] = new OBJ_Bloco(gp);
		gp.obj[mapNum][10].x = 10 * gp.tileSize;
		gp.obj[mapNum][10].y = 2 * gp.tileSize;
	
	    gp.obj[mapNum][9] = new OBJ_Bloco(gp);
		gp.obj[mapNum][9].x = 3 * gp.tileSize;
		gp.obj[mapNum][9].y = 9 * gp.tileSize;
		
		mapNum = 2;
		
		gp.obj[mapNum][0] = new OBJ_Key(gp);
		gp.obj[mapNum][0].x = 6 * gp.tileSize;
		gp.obj[mapNum][0].y = 6 * gp.tileSize;
		
		gp.obj[mapNum][1] = new OBJ_Key(gp);
		gp.obj[mapNum][1].x = 6 * gp.tileSize;
		gp.obj[mapNum][1].y = 6 * gp.tileSize;
		
		gp.obj[mapNum][2] = new OBJ_Key(gp);
		gp.obj[mapNum][2].x = 6 * gp.tileSize;
		gp.obj[mapNum][2].y = 6 * gp.tileSize;
		
		gp.obj[mapNum][3] = new OBJ_Key(gp);
		gp.obj[mapNum][3].x = 6 * gp.tileSize;
		gp.obj[mapNum][3].y = 6 * gp.tileSize;
		
		gp.obj[mapNum][4] = new OBJ_Key(gp);
		gp.obj[mapNum][4].x = 6 * gp.tileSize;
		gp.obj[mapNum][4].y = 6 * gp.tileSize;
		
		gp.obj[mapNum][5] = new OBJ_Bloco(gp);
		gp.obj[mapNum][5].x = 10 * gp.tileSize;
		gp.obj[mapNum][5].y = 10 * gp.tileSize;
		
		
		mapNum = 3;
		
		gp.obj[mapNum][0] = new OBJ_Key(gp);
		gp.obj[mapNum][0].x = 6 * gp.tileSize;
		gp.obj[mapNum][0].y = 7 * gp.tileSize;
		
		gp.obj[mapNum][1] = new OBJ_Key(gp);
		gp.obj[mapNum][1].x = 8 * gp.tileSize;
		gp.obj[mapNum][1].y = 3 * gp.tileSize;
		
		gp.obj[mapNum][2] = new OBJ_Key(gp);
		gp.obj[mapNum][2].x = 4 * gp.tileSize;
		gp.obj[mapNum][2].y = 3 * gp.tileSize;
		
		gp.obj[mapNum][3] = new OBJ_Bloco(gp);
		gp.obj[mapNum][3].x = 6 * gp.tileSize;
		gp.obj[mapNum][3].y = 8 * gp.tileSize;
		
		gp.obj[mapNum][4] = new OBJ_Bloco(gp);
		gp.obj[mapNum][4].x = 2 * gp.tileSize;
		gp.obj[mapNum][4].y = 5 * gp.tileSize;
		
		gp.obj[mapNum][5] = new OBJ_Bloco(gp);
		gp.obj[mapNum][5].x = 3 * gp.tileSize;
		gp.obj[mapNum][5].y = 6 * gp.tileSize;
		
		gp.obj[mapNum][6] = new OBJ_Bloco(gp);
		gp.obj[mapNum][6].x = 10 * gp.tileSize;
		gp.obj[mapNum][6].y = 5 * gp.tileSize;
		
		gp.obj[mapNum][7] = new OBJ_Bloco(gp);
		gp.obj[mapNum][7].x = 9 * gp.tileSize;
		gp.obj[mapNum][7].y = 6 * gp.tileSize;
		
		
		
	}
}
