package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import entity.Projectile;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

	
	//SCREEN SETTINGS
	final int originalTileSize = 16; 
	final int scale = 3;
	
	public final int tileSize = originalTileSize  * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 13;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	//MAPAS
	public final int maxMap = 10;
	public int currentMap;
	
	//FPS 
	int FPS = 60;
	
	//SYSTEM
	TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public MonsterSetter monsterSetter = new MonsterSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	//ENTITY AND OBJECT
	public Player player = new Player(this,keyH);
	public SuperObject obj[][] = new SuperObject[maxMap][256]; //SuperObject[] recebe o numero de objetos simultaneos
	//public ArrayList<Entity> monsterList = new ArrayList<>();
	public Entity[][] monsterList = new Entity[maxMap][10];
	public ArrayList<Projectile> projectileList = new ArrayList<>();
	
	//GAME STATE
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	
	// Set players's default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		currentMap = MapFileManager.readCurrentMap();
	}
	
	public void setupGame() {
		
		aSetter.setObject();
		monsterSetter.setMonsters();
		
		gameState = playState;
	}

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void resetGame() {
		player.setDefaultValues();
		setupGame();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / (drawInterval);
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				//UPDATE: update information
				update();
				//DRAW: draw the screen with updated info
				repaint();
				delta--;
				drawCount++;
			}

			if(timer >= 1000000000) {
				/* System.out.println("FPS:" + drawCount); */
				drawCount = 0;
				timer = 0;
			}
		}
	}
	public void update() {
		
		if(gameState == playState) {
			player.update();
		}
		if(gameState == pauseState) {
			// nada
		}
		
		for (int i = 0; i < monsterList.length; i++) {
			if (monsterList[currentMap][i] != null) {
				monsterList[currentMap][i].update(); 
			}
		}
		
		
		for (int i = 0; i < projectileList.size(); i++) {
			if (projectileList.get(i) != null) {
				projectileList.get(i).update();
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		// TILE
		tileM.draw(g2);
		
		//OBJECT
		for(int i = 0; i < obj[1].length; i++) {
			if(obj[currentMap][i] != null) {
				obj[currentMap][i].draw(g2, this);
			}
		}
		
		// MONSTERS
		for (int i = 0; i < monsterList[1].length; i++) {
			if (monsterList[currentMap][i] != null) {
				monsterList[currentMap][i].draw(g2);
			}
		}
		
		// PROJECTILES
		for (int i = 0; i < projectileList.size(); i++) {
			if (projectileList.get(i) != null) {
				projectileList.get(i).draw(g2);
			}
		}
		
		// PLAYER
		player.draw(g2);
		
		//UI
		ui.draw(g2);
		
		g2.dispose();
	}
	
}
