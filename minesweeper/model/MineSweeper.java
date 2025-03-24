package minesweeper.model;

import java.util.ArrayList;
import java.util.List;


public class MineSweeper {
	private int nbLines;
	private int nbColumns;
	private List<List<Cell>> grid;

	public MineSweeper(int nbLines, int nbColumns) {
		this.nbLines = nbLines;
		this.nbColumns = nbColumns;
		this.grid = new ArrayList<List<Cell>>();
		placeMines();
	}
	
	public int getNbLines() {
		return nbLines;
	}
	
	public int getNbColumns() {
		return nbColumns;
	}
	
	public boolean isMine(Position pos) {
		if(grid.get(pos.getLine()).get(pos.getColumn()).isMine()) 
			return true;
		return false;
		
	}
	
	public boolean isRevealed(Position pos) {
		if(grid.get(pos.getLine()).get(pos.getColumn()).isRevealed()) 
			return true;
		return false;
		
	}
	
	public boolean isFlagged(Position pos) {
		if(grid.get(pos.getLine()).get(pos.getColumn()).isFlagged()) 
			return true;
		return false;
	}
	
	public int getAdjacentMines(Position pos) {
		int count = 0;
		for(int i=0;i<getAdjacentPositions(pos).size();i++) {
			if(isMine(getAdjacentPositions(pos).get(i)))
				count++;
		}
		return count;
	}
	
	
	public String toString() {
		String str = "";
		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.get(i).size(); j++) {
				str += grid.get(i).get(j).toString() + " ";
			}
			str += "\n";
		}
		return str;
	}

	public String toStringDebug() {
		String str = "";
		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < nbColumns; j++) {
				str += grid.get(i).get(j).toStringDebug() + " ";
			}
			str += "\n";
		}
		return str;
	}

	public int countTotalCells() {
		return nbLines * nbColumns;
	}

	private Cell getCell(Position pos) {
		return grid.get(pos.getLine()).get(pos.getColumn());
	}

	public boolean isValidPositions(Position pos) {
		if (pos.getLine() >= nbLines || pos.getLine() < 0 || pos.getColumn() >= nbColumns || pos.getColumn() < 0)
			return false;
		return true;
	}

	public List<Position> getAdjacentPositions(Position pos) {
		List<Position> adjpositions = new ArrayList<Position>();
		if (isValidPositions(new Position(pos.getLine() + 1, pos.getColumn())))
			adjpositions.add(new Position(pos.getLine() + 1, pos.getColumn()));
		if (isValidPositions(new Position(pos.getLine() - 1, pos.getColumn())))
			adjpositions.add(new Position(pos.getLine() - 1, pos.getColumn()));
		if (isValidPositions(new Position(pos.getLine(), pos.getColumn() + 1)))
			adjpositions.add(new Position(pos.getLine(), pos.getColumn() + 1));
		if (isValidPositions(new Position(pos.getLine(), pos.getColumn() - 1)))
			adjpositions.add(new Position(pos.getLine(), pos.getColumn() - 1));
		if (isValidPositions(new Position(pos.getLine() + 1, pos.getColumn() + 1)))
			adjpositions.add(new Position(pos.getLine() + 1, pos.getColumn() + 1));
		if (isValidPositions(new Position(pos.getLine() + 1, pos.getColumn() - 1)))
			adjpositions.add(new Position(pos.getLine() + 1, pos.getColumn() - 1));
		if (isValidPositions(new Position(pos.getLine() - 1, pos.getColumn() + 1)))
			adjpositions.add(new Position(pos.getLine() - 1, pos.getColumn() + 1));
		if (isValidPositions(new Position(pos.getLine() - 1, pos.getColumn() - 1)))
			adjpositions.add(new Position(pos.getLine() - 1, pos.getColumn() - 1));
		return adjpositions;
	}

	private void placeMines() {
		for (int j = 0; j < nbLines; j++) { //à voir, resolution du bug pas opti, je rajoute une ligne inutile :/
			ArrayList<Cell> gridline = new ArrayList<Cell>();
			for (int i = 1; i <= nbColumns; i++) {
				Cell cell = new Cell();
				if ((int) (Math.random() * 100) < 15)
					cell.setMine();
				gridline.add(cell);
			}
			grid.add(gridline);
		}
		for (int p = 0; p < grid.size(); p++) {
			for (int m = 0; m < grid.get(p).size(); m++) {
				Position pos = new Position(p, m);
				for (int h = 0; h < getAdjacentPositions(pos).size(); h++) {
					if (grid.get(getAdjacentPositions(pos).get(h).getLine()).get(getAdjacentPositions(pos).get(h).getColumn()).isMine())
						grid.get(p).get(m).incrementAdjacentMines();
				}
			}
		}
	}

	public void revealCell(Position pos) {
		if((!(isGameOver()) && !(isGameWon())) && !isFlagged(pos)) {
			if(!isRevealed(pos))
			getCell(pos).reveal();
		}
	}

	public void toggleFlag(Position pos) {
		if(!isRevealed(pos) &&  !(isGameWon()) && (!(isGameOver())))
				getCell(pos).toggleFlag();
	}

	public int countRevealedCell() {
		int count = 0;
		for (int j = 0; j < nbLines; j++) {
			for (int i = 0; i < nbColumns; i++) {
				if (grid.get(j).get(i).isRevealed())
					count++;
			}
		}
		return count;
	}

	public int countUnRevealedCell() {
		return countTotalCells() - countRevealedCell();
	}

	public int countMines() {
		int count = 0;
		for (int j = 0; j < nbLines; j++) {
			for (int i = 0; i < nbColumns; i++) {
				if (grid.get(j).get(i).isMine())
					count++;
			}
		}
		return count;
	}

	public boolean isGameWon() {
		if (countUnRevealedCell() == countMines()) {
			return true;
		}
		return false;
	}

	public boolean isGameOver() {
		for (int j = 0; j < nbLines; j++) {
			for (int i = 0; i < nbColumns; i++) {
				if (grid.get(j).get(i).isRevealed() && grid.get(j).get(i).isMine()) {
					return true;
				}
			}
		}
		return false;
	}

}
