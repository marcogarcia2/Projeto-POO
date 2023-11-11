package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	} 
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}
		if(code == KeyEvent.VK_SPACE) {
			spacePressed = true;
			System.out.println("espaço");
		}	
		if(code == KeyEvent.VK_P) {
			 if(gp.gameState == gp.playState){
				 gp.gameState = gp.pauseState;
			 }
			 else if(gp.gameState == gp.pauseState) {
				 gp.gameState = gp.playState;
			 }
		}
		if(code == KeyEvent.VK_R) {
			switch(gp.currentMap) {
			case 0: gp.tileM.loadMap("/maps/map1.txt", 0); break;
			case 1: gp.tileM.loadMap("/maps/map2.txt", 1); break;
			}
		}	
		if(code == KeyEvent.VK_O) {
			//Salva o nivel atual 
			MapFileManager.writeCurrentMap(gp.currentMap);
		}
		if(code == KeyEvent.VK_I) {
			//Reinicia o arquivo de Save
			MapFileManager.writeCurrentMap(0);
			MapFileManager.readCurrentMap();
		
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if(code == KeyEvent.VK_SPACE) {
			spacePressed = false;
		}
	}

}
