package Principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PainelDeJogo extends JPanel implements Runnable{ //implementando o Runnable para rodar o Thread
	
	// CONFIGURAÇÃO DA TELA
	final int originalTitleSize = 16; // 16x16 formato "original" dos blocos de mapa e dos NPCs do jogo
	final int scale = 3; // escala
	
	final int titleSize = originalTitleSize * scale; // 48x48 formato "real" dos blocos de mapa e dos NPCs do jogo
	final int maxScreenCol = 16; //Coluna Máxima da tela final(blocos na horizontal)
	final int maxScreenRow = 12; //Linha Máxima da tela final (blocos na vertical) - ficando em uma proporção 16/12 -> 4/
	final int screenWidth = titleSize * maxScreenCol; //A largura da tela terá o tamanho do bloco vezes as colunas da tela máxima ou seja 768 pixels
	final int screenHeight = titleSize * maxScreenRow; //O tamanho da tela terá o tamanhi do bloco vezes as linhas da tela máxima ou seja 576 pixel
	// ou seja a tela terá o tamanho 768 x 576 por enquanto
	
	//FPS
	int FPS = 60; //definindo o FPS como 60
	
	KeyHandler KeyH = new KeyHandler();
	Thread gameThread; //Ele mantem o seu programa aberto até eu fechar, muito útil para jogos 2d para rodar os 
	
	//Definindo posição padrão do jogador
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public PainelDeJogo() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //Definindo a dimensão da tela com as variáveis criadas anteriormente
		this.setBackground(Color.black); //Definindo a cor de fundo como preta
		this.setDoubleBuffered(true); //Isso serve para uma melhor renderização
		this.addKeyListener(KeyH); //Para o painel de jogo começar a reconhecer a entrada de teclas
		this.setFocusable(true); // Faz que esse Painel de jogo seja focado em receber entradas de dados
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override //foi gerado automaticamente junto com o void run(quando cliquei na lâmpada)
	public void run() { // Quando executamos o gameThread.start ele automaticamente chama o método run 
		
		//MÉTODO delta
		double drawInterval = 1000000000/FPS; // intervalo de desenho de 1bilhão de nanosegundos( = 1 segundo), dividido por 60(FPS), ou sea a cada 0.016s é desenhado na tela
		double delta = 0; 
		long lastTime = System.nanoTime(); // tempo anterior
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		while(gameThread != null) { //enquanto a Thread existir ele vai executar esse while
			
			//ESSE LOOP CONTERÁ:
			//1 UPDATE: Atualizar informações como a posição do (X,Y)
			//2 DRAW: "Desenhar" na tela com as informações atualizadas, ir trocando de sprite e atualizando o x e  y
			
			currentTime = System.nanoTime(); //verifica o tempo atual em nano segundos(mt pequeno, por isso é mais preciso) do sistema, será usando no update e no repaint, para restringir a atualização dos "desenhos"/frames, pois por ser o compuador ele atualiza milhares/milhões de vezes por segundo/minuto, impossibiitando até de ver o "retângulo" se movendo
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) { //quando o delta atinge o intervalo de desenho ele faz o update o repaint e volta o delta ao valor inicial
				update();
				repaint(); //forma de chamar a função/método "paintComponent"
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000) { //quando o timer atingir 1 segundo (1 bilhão de nanosegundos) print o FPS, e reseta o timer e o contador
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
			
		}//while
	
	}
	
	public void update() { 
		
		if(KeyH.upPressed == true) {
			playerY -= playerSpeed; //para a posição ser alterada e causar a impressão que o player tá se movendo
		}
		else if(KeyH.downPressed == true) {
			playerY += playerSpeed;
		}
		else if(KeyH.leftPressed == true) {
			playerX -= playerSpeed;
		}
		
		else if(KeyH.rightPressed == true) {
			playerX += playerSpeed;
		}
	}
	
	public void paintComponent(Graphics g) { //Método padrão para desenhar coisas no JPanel
		
		super.paintComponent(g); //Esse super significa a classe "pai", ou seja o JPanel, sendo o painel de jogo uma subclasse de JPanel
		
		Graphics2D g2 = (Graphics2D)g; //Mudamos o Graphics para o Graphics2D(tem as funções que o outro)
		
		g2.setColor(Color.white); //definindo a cor como branca
		
		g2.fillRect(playerX, playerY, titleSize, titleSize); //criando um retangulo com x = 100, y = 100, largura e tamanho 48x48 
	
		g2.dispose(); //"descarta" o g2 Graphics2D, bom para economizar memória
	}
}
