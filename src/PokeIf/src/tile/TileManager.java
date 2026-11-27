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
	public void draw(Graphics2D g2) {
	    
	    // Começa a varrer a matriz do mapa a partir da coluna 0 e linha 0
	    int worldCol = 0;
	    int worldRow = 0;
	    
	    // Percorre toda a grelha do mundo (50x50) definida no ifce.txt
	    while(worldCol < pj.maxWorldCol && worldRow < pj.maxWorldRow) {
	        
	        // Descobre qual o número do bloco (ex: 0=grama, 1=pedra, 4=árvore) nesta posição
	        int tileNum = mapTileNum[worldCol][worldRow];
	        
	        // Converte a posição da grelha em pixels reais do mundo
	        int worldX = worldCol * pj.tileSize;
	        int worldY = worldRow * pj.tileSize;
	        
	        // Calcula a posição onde o bloco deve aparecer na tela em relação ao jogador (Câmara)
	        int screenX = worldX - pj.player.worldX + pj.player.screenX;
	        int screenY = worldY - pj.player.worldY + pj.player.screenY;
	        
	        // Otimização: Desenha apenas os blocos que estão dentro da área visível do monitor (com margem de 1 tile)
	        if (worldX + pj.tileSize > pj.player.worldX - pj.player.screenX &&
	            worldX - pj.tileSize < pj.player.worldX + pj.player.screenX &&
	            worldY + pj.tileSize > pj.player.worldY - pj.player.screenY &&
	            worldY - pj.tileSize < pj.player.worldY + pj.player.screenY) {
	            
	            // Desenha a imagem do bloco correspondente na tela
	            g2.drawImage(tile[tileNum].image, screenX, screenY, pj.tileSize, pj.tileSize, null);
	        }
	        
	        // Avança para a próxima coluna
	        worldCol++;
	        
	        // Quando chega ao fim da linha do mundo, salta para a linha seguinte (quebra de linha do while)
	        if(worldCol == pj.maxWorldCol) {
	            worldCol = 0;
	            worldRow++;
	        }
	    }
	}
}