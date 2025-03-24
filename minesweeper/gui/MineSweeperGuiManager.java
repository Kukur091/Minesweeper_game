package minesweeper.gui;

import java.util.Timer;
import java.util.TimerTask;

public class MineSweeperGuiManager {
	MineSweeperGuiManager() {
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				MineSweeperGuiGame.panel.repaint();
				if (MineSweeperGuiGame.game.isGameWon()) {
					MineSweeperGuiGame.frame.setContentPane(new MineSweeperGameWin());
					MineSweeperGuiGame.frame.repaint();
				}
			}
		}, 1000, 400);
	}

}
