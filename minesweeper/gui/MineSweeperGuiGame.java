package minesweeper.gui;

import projet.tp11.minesweeper.model.MineSweeper;
import javax.swing.JFrame;

public class MineSweeperGuiGame extends JFrame{
	static MineSweeper game = new MineSweeper(15,15);
	public static int line = game.getNbLines();
	public static int column = game.getNbColumns();
	public static JFrame frame = new JFrame("Demineur Deluxe");
	static MineSweeperPanel panel = new MineSweeperPanel();
	
	public MineSweeperGuiGame() {
	frame = new JFrame("Demineur");
	frame.setSize((column*50)+11, (line*50)+100);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setContentPane(panel);
	MineSweeperGuiManager manager = new MineSweeperGuiManager();
	if(game.isGameOver()) {
		frame.setContentPane(panel);
		frame.repaint();
	}
	//scoreboard -> chrono, flags dispo, (score?) et difficulté
	//difficulté -> taille du demineur, 
	//puis menu gamewin etc
	//----------
	// ameliorer ui: couleur, menu, affichage etc
	//menu gameover et gamwin, avec score et timer
	//main menu pour creer une partie
	//custom terrain?
	// multijoueur?
	//son?
	
	}

}
