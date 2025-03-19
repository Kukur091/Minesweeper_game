package projet.tp11.minesweeper.model;

public class TestCell {
	public static void main(String[] args) {
		Cell cell = new Cell();
		System.out.println(cell.getAdjacentMines());
		System.out.println(cell.isFlagged());
		System.out.println(cell.isMine());
		System.out.println(cell.isRevealed());
		System.out.println(cell.toStringDebug());
		System.out.println(cell.toString());
		cell.incrementAdjacentMines();
		cell.incrementAdjacentMines();
		cell.toggleFlag();
		cell.setMine();
		System.out.println(cell.getAdjacentMines());
		System.out.println(cell.isFlagged());
		System.out.println(cell.toStringDebug());
		System.out.println(cell.toString());
	}
}
