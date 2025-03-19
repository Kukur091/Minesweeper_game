package projet.tp11.minesweeper.model;

import java.util.Scanner;

public class MinesweeperConsoleGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MineSweeper game = new MineSweeper(3, 3);
		do {
			System.out.println(game.toStringDebug());
			System.out.println(game.toString());
			System.out.println("Choisissez une action : ");
			System.out.println("1 - Révéler une cellule (ligne colonne)");
			System.out.println("2 - Poser/retirer un drapeau (ligne colonne)");
			System.out.print("Votre choix : ");
			int choix = scanner.nextInt();
			if (choix != 1 && choix != 2) {
				System.out.println("Choix invalide, réessayez.");
				continue;
			}
			System.out.print("Entrez la ligne : ");
			int line = scanner.nextInt();
			System.out.print("Entrez la colonne : ");
			int column = scanner.nextInt();
			Position pos = new Position(line, column);
			if (!game.isValidPositions(pos)) {
				System.out.println("Position invalide, réessayez.");
				continue;
			}
			if (choix == 1)
				game.revealCell(pos);
			else
				game.toggleFlag(pos);
		} while (!game.isGameOver() && !game.isGameWon());
		if (game.isGameOver())
			System.out.println("BOOM ! Vous avez perdu !");
		else
			System.out.println("Félicitations, vous avez gagné !");
		System.out.println("Fin de la partie.");
		scanner.close();
	}
}