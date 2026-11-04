package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

import Principal.KeyHandler;
import Principal.PainelDeJogo;

public class Player extends Entity {
	
	PainelDeJogo pj;
	KeyHandler KeyH;
	
	public Player(PainelDeJogo pj, KeyHandler KeyH) {
		
		this.pj = pj;
		this.KeyH = KeyH;
		
		setDefaultValues();
	}
	public void setDefaultValues() { //Vamos transferir as coisas que fazemos no painel de jogo para essa nova classe, por motivos de organização
		
		x = 100;
		y = 100;
		speed = 4;
	}
	public void update() {
		
		if(KeyH.upPressed == true) {
			y -= speed; //para a posição ser alterada e causar a impressão que o player tá se movendo
		}
		else if(KeyH.downPressed == true) {
			y += speed;
		}
		else if(KeyH.leftPressed == true) {
			x -= speed;
		}
		
		else if(KeyH.rightPressed == true) {
			x += speed;
		}
	}
	public void draw(Graphics2D g2) {
		
		g2.setColor(Color.white); //definindo a cor como branca
		
		g2.fillRect(x, y, pj.titleSize, pj.titleSize); //criando um retangulo com x = 100, y = 100, largura e tamanho 48x48 
	
	}
}
