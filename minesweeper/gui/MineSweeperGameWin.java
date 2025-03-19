package projet.tp11.minesweeper.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MineSweeperGameWin extends JPanel{
	MineSweeperGameWin(){
		JPanel panel = new JPanel();
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 200, 200);
		}
	
}
