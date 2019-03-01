package model;

public class MagicSquare {
	private int sideSize;
	private char startPosition;
	private char direction;
	private int[][] square;
	
	public static final char TOP = 't';
	public static final char BOT = 'b';
	public static final char LEFT = 'l';
	public static final char RIGHT = 'r';
	public static final char NORTHWEST = '1';
	public static final char NORTHEAST = '2';
	public static final char SOUTHWEST = '3';
	public static final char SOUTHEAST = '4';
	
	public int[][] getSquare(){
		return square;
	}
	public MagicSquare(int sideSize, char startPosition, char direction) {
		this.sideSize=sideSize;
		this.startPosition=startPosition;
		this.direction=direction;
		square = new int[sideSize][sideSize];
		setPredeterminedValues(sideSize/2+1);
	}
	public void setPredeterminedValues(int middle) {
		int a = 0;
		int b = 0;
		switch (startPosition) {
		case TOP:
			a = 0;
			b = middle;
			break;
		case BOT:
			a = sideSize-1;
			b = middle;
			break;
		case LEFT:
			a = middle;
			b = 0;
			break;
		case RIGHT:
			a = middle;
			b = sideSize-1;
			break;
		}
		int c = 0;
		int d = 0;
		switch (direction) {
		case NORTHWEST:
			c = -1;
			d = 1;
			break;
		case NORTHEAST:
			c = -1;
			d = -1;
			break;
		case SOUTHWEST:
			c = 1;
			d = 1;
			break;
		case SOUTHEAST:
			c = 1;
			d = -1;
			break;
		}
		completeSquare(middle, a, b, c, d);
	}
	public boolean nextBoxIsFull(int a, int b) {
		boolean msg=false;
			if(square[a][b] != 0) {
				msg = true;
			}
		return msg;
	}
	public void completeSquare(int middle, int row, int column, int dInRows, int dInColumns) {
		square[row][column]=1;
		for(int i=1; i<(sideSize*sideSize); i++) {
			int nextRow = row+dInRows;
			int nextColumn = column+dInColumns;
			if(nextRow < 0) {
				nextRow = sideSize-1;
			}else if(nextRow > sideSize-1) {
				nextRow = 0;
			}
			if(nextColumn < 0) {
				nextColumn = sideSize-1;
			}else if(nextColumn > sideSize-1) {
				nextColumn = 0;
			}
			if(nextBoxIsFull(nextRow, nextColumn)) {
					switch (startPosition) {
					case TOP:
						nextRow -= 1;
						break;
					case BOT:
						nextRow += 1;
						break;
					case LEFT:
						nextColumn += 1;
						break;
					case RIGHT:
						nextColumn -= 1;
						break;
					}
					if(nextRow < 0) {
						nextRow = sideSize-1;
					}else if(nextRow > sideSize-1) {
						nextRow = 0;
					}
					if(nextColumn < 0) {
						nextColumn = sideSize-1;
					}else if(nextColumn > sideSize-1) {
						nextColumn = 0;
					}
			}else {
				row = nextRow;
				column = nextColumn;
				square[row][column]=i;
			}
		}
	}
}
