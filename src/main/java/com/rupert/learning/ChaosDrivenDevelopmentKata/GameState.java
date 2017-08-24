package com.rupert.learning.ChaosDrivenDevelopmentKata;

public class GameState {

	private String gameBoard = "";
	private String gameResults = "[][]\n[][N]";
	private int gridSize = 2;
	private int activeRow = 0;
	private int activeColumn = 0;
	private String activeOrientation = "";

	
	
	
	public String playCommands(int startRow, int startColumn, String startOrientation, String[] commands) {
		
		activeRow = startRow;
		activeColumn = startColumn;
		activeOrientation = startOrientation;
		
		for (int i = 0; i < commands.length; i++) {
			
			String command = commands[i].toString();
			
			gameBoard = doCommand(activeRow, activeColumn, activeOrientation, command);
			gameResults += "\n\n";
			gameResults += gameBoard;
			
		}
			
		return gameResults;
	}

	
	

	private void clearGameBoard() {
		gameBoard = "";
	}
		
	
	
	
	public String doCommand(int startRow, int startColumn, String startOrientation, String command) {
		
		moveVertically(startRow, startOrientation, command);
		moveHorizontally(startColumn, startOrientation, command);
		reorientate(startOrientation, command);
		drawBoard(activeRow, activeColumn, activeOrientation);

        return gameBoard;		    
	
	}


	

	private void moveVertically(int startRow, String startOrientation, String command) {
		
		int newRow = startRow;
		if (startOrientation.equals("N")) {			
			if (command.equals("DF")) {
				newRow -= 1;
			} 
			if (command.equals("DB")) {
				newRow += 1;
			}
		}
		
		if (startOrientation.equals("S")) {			
			if (command.equals("DF")) {
				newRow += 1;
			} 
			if (command.equals("DB")) {
				newRow -= 1;
			}
		}
		
		checkForOffMapExceptions(newRow);
		
		activeRow = newRow;
	}

	
	
	
	private void moveHorizontally(int startColumn, String startOrientation, String command) {
		int newColumn = startColumn;
		if (startOrientation.equals("W")) {
			if (command.equals("DF")) {
				newColumn -= 1;
			} 
			if (command.equals("DB")) {
				newColumn += 1;
			}
		}
		
		if (startOrientation.equals("E")) {
			if (command.equals("DF")) {
				newColumn += 1;
			} 
			if (command.equals("DB")) {
				newColumn -= 1;
			}
		}
		
		checkForOffMapExceptions(newColumn);
		
		activeColumn = newColumn;
	}

	
	

	private void checkForOffMapExceptions(int columnOrRow) {
		if (columnOrRow >= gridSize || columnOrRow < 0) {
			throw new IllegalArgumentException("The avatar has fallen off the map!");
		}
	}

	
	
	
	private void reorientate(String startOrientation, String command) {
		
		OrientationConverter converter = new OrientationConverter();
		int degreeOrientation = converter.convertToDegrees(startOrientation);
		
		if (command.equals("TR")) {
			degreeOrientation += 90;
		} else if (command.equals("TL")) {
			if (degreeOrientation == 0) {
				degreeOrientation += 360;
			}
			degreeOrientation -= 90;	
		}
		
		int finalDegreeOrientation = degreeOrientation % 360;
		String finalStringOrientation = converter.convertToString(finalDegreeOrientation);
		
		activeOrientation = finalStringOrientation;
		
	}

	
	

	private void drawBoard(int rowPosition, int columnPosition, String Orientation) {

		clearGameBoard();
		
		int rows = gridSize;
	    int columns = gridSize;
	    String startBox = "[";		    
	    String endBox = "]";
		String box = "";

		for (int row = 0; row < rows; row++) {

			for (int col = 0; col < columns; col++) {

				if (row == rowPosition && col == columnPosition) {
					box = startBox + Orientation + endBox;
				} else {
					box = startBox + endBox;
				}

				if (row == 0) {
					gameBoard += box;
				} else if (col == 0) {
					gameBoard += "\n" + box;
				} else {
					gameBoard += box;
				}

		    }
		}
	}		
}

