package minesweeper.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import javax.swing.JPanel;
import projet.tp11.minesweeper.model.Position;

public class MineSweeperPanel extends JPanel {
	public MineSweeperPanel() {
		JPanel panel = new JPanel();
		this.addMouseListener(new MineSweeperMouseListener());
	}

	protected void paintComponent(Graphics g) {
		drawCell(g);
	}

	public static Position convert(int h, int w) {
		int nh = (h / 50);
		int nw = (w / 50);
		return new Position(nw, nh);
	}

	private void drawCell(Graphics g) {
		int width = 50;
		int height = 50;
		for (int i = 0; i < MineSweeperGuiGame.game.getNbLines(); i++) {
			for (int j = 0; j < MineSweeperGuiGame.game.getNbColumns(); j++) {
				Color Cellcolor = ((i+j)%2 == 0)?new Color(106,255,82) : new Color(28,212,0);
				Color RevealedCellcolor = ((i+j)%2 == 0)?new Color(255,238,122) : new Color(255,229,55);
				g.setColor(Cellcolor);
				g.fillRect(j * width, i * height, width, height);
				if (MineSweeperGuiGame.game.isFlagged(new Position(i, j))) {
					g.setFont(new Font("", Font.PLAIN, 30));
					g.setColor(Color.gray);
					g.fillRect(j * width + 17, (i * height)+10, 6, 30);
					g.setColor(Color.red);
					g.fillPolygon(new int[] {j * width + 23, j * width + 23, j * width + 37}, new int[] {(i * height)+12, (i * height)+27, (i * height)+19}, 3);

				}
				if (MineSweeperGuiGame.game.isRevealed(new Position(i, j))) {
					g.setColor(RevealedCellcolor);
					g.fillRect(j * width, i * height, width, height);
					if (MineSweeperGuiGame.game.isMine(new Position(i, j))) {
						g.setFont(new Font("", Font.PLAIN, 30));
						g.setColor(Color.black);
						g.fillOval(j * width + 10, (i * height) + 17, 30, 30);
						g.setColor(Color.DARK_GRAY);
						g.fillOval(j * width + 25, (i * height) + 20, 10, 10);
						g.fillOval(j * width + 20, (i * height) + 29, 4, 4);
						g.setColor(Color.LIGHT_GRAY);
						g.drawLine(j * width + 25, (i * height) + 17, j * width + 25, (i * height) + 11);
						g.drawLine(j * width + 26, (i * height) + 17, j * width + 26, (i * height) + 11);
						g.drawLine(j * width + 24, (i * height) + 17, j * width + 24, (i * height) + 11);
						g.setColor(Color.orange);
						g.drawLine(j * width + 27, (i * height) + 11, j * width + 30, (i * height) + 11);
						g.drawLine(j * width + 27, (i * height) + 10, j * width + 30, (i * height) + 10);
						g.drawLine(j * width + 27, (i * height) + 9, j * width + 30, (i * height) + 9);
						g.setColor(Color.red);
						g.drawLine(j * width + 31, (i * height) + 8, j * width + 33, (i * height) + 8);
						g.drawLine(j * width + 31, (i * height) + 7, j * width + 33, (i * height) + 7);
					} else {
					g.setFont(new Font("", Font.PLAIN, 30));
					Color textcolor;
					switch(MineSweeperGuiGame.game.getAdjacentMines(new Position(i, j))) {
					case 0 : 
						textcolor = new Color(0,0,0,0);
						break;
					case 1 :
						textcolor = Color.cyan;
						break;
					case 2:
						textcolor = Color.green;
						break;
					case 3: 
						textcolor = Color.red;
						break;
					case 4:
						textcolor = Color.magenta;
						break;
					default:
						textcolor = Color.orange;
						break;
					}
					g.setColor(textcolor);
					g.drawString(String.valueOf(MineSweeperGuiGame.game.getAdjacentMines(new Position(i, j))),
							j * width + 15, (i * height) + 40);
					}
				}
			}
		}
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, MineSweeperGuiGame.frame.getHeight()-100, MineSweeperGuiGame.frame.getWidth(), MineSweeperGuiGame.frame.getHeight());

	}
}
