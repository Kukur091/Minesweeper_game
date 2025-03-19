package projet.tp11.minesweeper.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MineSweeperMouseListener extends MouseAdapter {
	
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			MineSweeperGuiGame.game.revealCell(MineSweeperPanel.convert(e.getX(), e.getY()));
			for(int i=0;i<MineSweeperGuiGame.game.getAdjacentPositions(MineSweeperPanel.convert(e.getX(), e.getY())).size();i++){
				if(!MineSweeperGuiGame.game.isFlagged(MineSweeperGuiGame.game.getAdjacentPositions(MineSweeperPanel.convert(e.getX(), e.getY())).get(i)) && !(MineSweeperGuiGame.game.isMine(MineSweeperGuiGame.game.getAdjacentPositions(MineSweeperPanel.convert(e.getX(), e.getY())).get(i))))
				MineSweeperGuiGame.game.revealCell(MineSweeperGuiGame.game.getAdjacentPositions(MineSweeperPanel.convert(e.getX(), e.getY())).get(i));			
			}
		
		MineSweeperGuiGame.game.revealCell(MineSweeperPanel.convert(e.getX(), e.getY()));
		}
		
		if(e.getButton() == MouseEvent.BUTTON3) 
			MineSweeperGuiGame.game.toggleFlag(MineSweeperPanel.convert(e.getX(), e.getY()));
		
	}
}
