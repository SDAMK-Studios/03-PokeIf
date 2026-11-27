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
		
		mapTileNum = new int[pj.maxWorldCol][pj.maxWorldRow]; //vão receber o arquivo txt com o mapa 
		getTileImage();
		loadMap("/maps/ifce.txt");
	}
	
	public void getTileImage() {
		try {
			
			tile[0] = new Tile(); // instanciando esse array de tiles e adicionando cada bloco em seu respectivo array
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grama.png"));
			
			tile[1] = new Tile(); 
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pedra.png"));
			
			tile[2] = new Tile(); 
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/água.png"));
			
			tile[3] = new Tile(); 
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/parede.png"));
			
			tile[4] = new Tile(); 
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arvore.png"));
			
			tile[5] = new Tile(); 
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
			
			while(col < pj.maxWorldCol && row < pj.maxWorldRow) {
				
				String line = br.readLine(); // lê uma única linha
				
				while(col < pj.maxWorldCol) {
					
					String numbers[] = line.split(" "); // da linha que acabamos de ler vamos armazenar cada número nesse arreio, separando eles pelo espaço " "
					
					int num = Integer.parseInt(numbers[col]); // mudando o numero de string para inteiro
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == pj.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) { // método para desenhar os tiles
		
		int WorldCol = 0; //coluna
		int WorldRow = 0; //linha
		
		while (WorldCol < pj.maxWorldCol && WorldRow < pj.maxWorldRow) {
			
			int tileNum = mapTileNum[WorldCol][WorldRow];
			
			int worldX = WorldCol * pj.tileSize; //O world é a posição no mapa
			int worldY = WorldRow * pj.tileSize;
			int screenX = worldX - pj.player.worldX + pj.player.screenX; //O screen é onde vamos desenhar na tela
			int screenY = worldY - pj.player.worldY + pj.player.screenY;
			
			//Basicamente é feito para desenhar os blocos no mapa somente onde a tela passar, deixando o jogo mais leve
			if(worldX + pj.tileSize > pj.player.worldX - pj.player.screenX &&
			   worldX - pj.tileSize < pj.player.worldX + pj.player.screenX && 
			   worldY + pj.tileSize > pj.player.worldY - pj.player.screenY && 
			   worldY - pj.tileSize < pj.player.worldY + pj.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, pj.tileSize, pj.tileSize, null); 
				
			}
			
			WorldCol++;
			
			if(WorldCol == pj.maxWorldCol) { // Se a coluna atingir o tamanho máximo da coluna da tela(16), reseta o col e o x, tembem aumentando row e o y
				WorldCol = 0;
				WorldRow++;
			}
		}
	}
}