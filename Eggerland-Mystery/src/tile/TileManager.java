package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager { //Posiciona os blocos no nivel

		GamePanel gp;
		public Tile[] tile;
		public int mapTileNum[][][];
		
		public TileManager(GamePanel gp) {
                    //A posicao dos blocos eh definida por uma matriz em um arquivo .txt
			
			this.gp = gp;
			
			tile = new Tile[10];
			mapTileNum = new int[gp.maxMap][gp.maxScreenCol][gp.maxScreenRow];
			
			getTileImage();
			loadMap("/maps/map1.txt",0);
			loadMap("/maps/map2.txt",1);
			loadMap("/maps/map3.txt",2);
			loadMap("/maps/map4.txt",3);
		}
		
		public void getTileImage() {
			
			try {
                                //O tipo do bloco e definido por sua posicao no vetor 'tile[]'
                            
				tile[0] = new Tile();
				tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/background.png"));
				
				tile[1] = new Tile();
				tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
				tile[1].collision = true;
				
				tile[2] = new Tile();
				tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
				tile[2].collision = true;
				
				tile[3] = new Tile();
				tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
				
				tile[4] = new Tile();
				tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
				tile[4].collision = true;
				
				tile[5] = new Tile();
				tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
				
				tile[6] = new Tile();
				tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door_closed.png"));
				
				
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		public void loadMap(String filePath , int map) { // Define a posicao e tipo dos blocos baseado no arquivo .txt
			
			try {
				InputStream is = getClass().getResourceAsStream(filePath);
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
				int col = 0;
				int row = 0;
				
				while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
					
					String line = br.readLine();
					
					while(col < gp.maxScreenCol) {
						
						String numbers[] = line.split(" ");
						
						int num = Integer.parseInt(numbers[col]);
						
						mapTileNum[map][col][row] = num;
						col++;
					}
					if(col == gp.maxScreenCol) {
						col = 0;
						row++;
					}
				}br.close();
				
			}catch(Exception e) {
				
			}
			
		}
		public void draw(Graphics2D g2) {//Desenha os sprites dos blocos
			
			int col = 0;
			int row = 0;
			int x = 0;
			int y = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				
				int tileNum = mapTileNum[gp.currentMap][col][row];
				
				g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
				col++;
				x += gp.tileSize;
				
				if(col == gp.maxScreenCol) {
					col = 0;
					x = 0;
					row++;
					y += gp.tileSize;
				}
				
			}
			
		}
		
		
}

