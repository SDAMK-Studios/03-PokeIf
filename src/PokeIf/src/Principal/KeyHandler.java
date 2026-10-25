package Principal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public boolean upPressed, downPressed, leftPressed, rightPressed; //para cima, baixo, esquerda e direita 

	@Override
	public void keyTyped(KeyEvent e) { // esse método é meio inútl, usamos apenas o outros 2 na maioria das vezes
		
	}

	@Override
	public void keyPressed(KeyEvent e) { // Quando eu apertar a tecla
		
		int code = e.getKeyCode(); //retorna o número da tecla(tipo o código da tecla ex -> 65 = a e etc)
		
		if(code == KeyEvent.VK_W) { // Se eu apertar a tecla W, faça oque eu te pedir
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
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) { // Quando eu não estiver apertando a tecla
		
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
		
		
	}

}
