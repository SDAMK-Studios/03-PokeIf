package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Principal.PainelDeJogo;

public class TileManager {
	
	PainelDeJogo pj;
	Tile[] tile;
	int mapTileNum[][]; //número de bloco do mapa
	
	public TileManager(PainelDeJogo pj) { //criando o construtor TileManager
		
		this.pj = pj;
		
		tile = new Tile[10]; //coloquei por enquanto que vamos criar 10 tipos de blocos, entãoo coloquei um array com o tamanho de 10
		
		mapTileNum = new int[pj.maxScreenCol][pj.maxScreenRow]; //vão receber o arquivo txt com o mapa 
		getTileImage();
		loadMap("/maps/map01.txt");
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile(); // instanciando esse array de tiles e adicionando cada bloco em seu respectivo array
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grama.png"));
			
			tile[1] = new Tile(); // instanciando esse array de tiles
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pedra.png"));
			
			tile[2] = new Tile(); // instanciando esse array de tiles
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/água.png"));
			
			tile[3] = new Tile(); // instanciando esse array de tiles
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/parede.png"));
			
			tile[4] = new Tile(); // instanciando esse array de tiles
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arvore.png"));
			
			tile[5] = new Tile(); // instanciando esse array de tiles
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/areia.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap(String filePath) { //recebe uma string "caminho do arquivo", mais fácil quando for alterar para mapas futuros
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath); // "Pego/recebo" o arquivo txt com o mapa
			BufferedReader br = new BufferedReader(new InputStreamReader(is)); // ler o arquivo de texto
			
			int col = 0;
			int row = 0;
			
			while(col < pj.maxScreenCol && row < pj.maxScreenRow) {
				
				String line = br.readLine(); // lê uma única linha
				
				while(col < pj.maxScreenCol) {
					
					String numbers[] = line.split(" "); // da linha que acabamos de ler vamos armazenar cada número nesse arreio, separando eles pelo espaço " "
					
					int num = Integer.parseInt(numbers[col]); // mudando o numero de string para inteiro
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == pj.maxScreenCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) { // método para desenhar os tiles
		
		int col = 0; //coluna
		int row = 0; //linha
		int x = 0;
		int y = 0;
		
		while (col < pj.maxScreenCol && row < pj.maxScreenRow) {
			
			int tileNum = mapTileNum[col][row];
			
			g2.drawImage(tile[tileNum].image, x, y, pj.tileSize, pj.tileSize, null); //desenhe a grama, aumente de 1 em 1 as colunas, e some a cordenada x com o tamanho do tile(48)
			col++;
			x += pj.tileSize;
			
			if(col == pj.maxScreenCol) { // se a coluna atingir o tamanho máximo da coluna da tela(16), reseta o col e o x, tembem aumentando row e o y
				col = 0;
				x = 0;
				row ++;
				y += pj.tileSize;
			}
		}
	}
}
