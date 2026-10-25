package Principal;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("PokeIF");
		
		PainelDeJogo painelDeJogo = new PainelDeJogo();
		window.add(painelDeJogo);
		
		window.pack(); //compactando o JPanel para que possamos vê-lo
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		painelDeJogo.startGameThread();
	}

}
