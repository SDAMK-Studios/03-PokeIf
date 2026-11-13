package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import Principal.PainelDeJogo;

public class TileManager {
	
	PainelDeJogo pj;
	Tile[] tile;
	
	public TileManager(PainelDeJogo pj) { //criando o construtor TileManager
		
		this.pj = pj;
		
		tile = new Tile[10]; //coloquei por enquanto que vamos criar 10 tipos de blocos, entãoo coloquei um array com o tamanho de 10
		
		getTileImage();
		
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile(); // instanciando esse array de tiles e adicionando cada bloco em seu respectivo array
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grama.png"));
			
			tile[1] = new Tile(); // instanciando esse array de tiles
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pedra.png"));
			
			tile[2] = new Tile(); // instanciando esse array de tiles
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/agua.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) { // método para desenhar os tiles
		
		g2.drawImage(tile[0].image, 0, 0, pj.titleSize, pj.titleSize, null);
		
	}
}
