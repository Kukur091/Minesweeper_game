package projet.tp11.minesweeper.model;

public class Cell {
	private boolean isMine;
	private int adjacentMines;
	private boolean isRevealed;
	private boolean isFlagged;
	
	public Cell() {
		isMine = false;
		adjacentMines = 0;
		isRevealed = false;
		isFlagged = false;
	}
	
	public String toString() { //à simplifier
		if(!isRevealed) {
			if(isFlagged) 
				return "F";
			return "_";
		} else {
			if(isMine) {
				return "*";
			}else if(adjacentMines > 0) {
				return String.valueOf(adjacentMines);
			} else {
				return " ";
			}
		}
	}
	
	public String toStringDebug() {
		if(isMine)
			return String.valueOf(adjacentMines) + "*";
		return String.valueOf(adjacentMines) + "_";
	}
	
	public void reveal() {
		isRevealed = !isRevealed;
	}
	
	public void toggleFlag() {
		isFlagged = !isFlagged;
	}
	
	public void setMine() {
		isMine = true;
	}
	
	public void incrementAdjacentMines() {
		adjacentMines++;
	}
	
	public boolean isMine() {
		return isMine;
	}
	
	public int getAdjacentMines() {
		return adjacentMines;
	}
	
	public boolean isRevealed(){
		return isRevealed;
	}
	
	public boolean isFlagged() {
		return isFlagged;
	}
	
}
