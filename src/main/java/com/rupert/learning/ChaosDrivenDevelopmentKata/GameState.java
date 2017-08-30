package com.rupert.learning.ChaosDrivenDevelopmentKata;

public class GameState {

	private String gameBoard;
	private String gameResults;
	private int globalGridSize;
	private int activeRow;
	private int activeColumn;
	private String activeOrientation;

	
	
	
	public String playCommands(int startRow, int startColumn, String startOrientation, String[] startCommands, int gridSize) {
		
		activeRow = startRow;
		activeColumn = startColumn;
		activeOrientation = startOrientation;
		
		drawStartingBoard(gridSize);
		
		for (int i = 0; i < startCommands.length; i++) {
			
			String command = startCommands[i].toString();
			
			gameBoard = doCommand(activeRow, activeColumn, activeOrientation, command, gridSize);
			gameResults += "\n\n" + gameBoard;
			
		}
		
		return gameResults;
	}




	private void drawStartingBoard(int gridSize) {
		gameResults = doCommand(activeRow, activeColumn, activeOrientation, "", gridSize);
	}

	
		
		
	public String doCommand(int row, int column, String orientation, String command, int gridSize) {
		
		setBoardSize(gridSize);
		moveVertically(row, orientation, command);
		moveHorizontally(column, orientation, command);
		reorientate(orientation, command);
		drawBoard(activeRow, activeColumn, activeOrientation);

        return gameBoard;		    
	
	}




	private void setBoardSize(int gridSize) {
		globalGridSize = gridSize;
	}


	

	private void moveVertically(int row, String orientation, String command) {
		
		int moveDistance = 1;
		
		if (command.length() > 2) {
			moveDistance = Character.getNumericValue(command.charAt(3));
			command = command.substring(0,2);
		} 
		
		int newRow = row;
		
		if (orientation.equals("N")) {			
			if (command.equals("DF")) {
				newRow -= moveDistance;
			} 
			if (command.equals("DB")) {
				newRow += moveDistance;
			}
		}
		
		if (orientation.equals("S")) {			
			if (command.equals("DF")) {
				newRow += moveDistance;
			} 
			if (command.equals("DB")) {
				newRow -= moveDistance;
			}
		}
		
		checkForOffMapExceptions(newRow);
		
		activeRow = newRow;
	}

	
	
	
	private void moveHorizontally(int column, String orientation, String command) {
		
		int moveDistance = 1;
		
		if (command.length() > 2) {
			moveDistance = Character.getNumericValue(command.charAt(3));
			command = command.substring(0,2);
		} 
		
		int newColumn = column;
		
		if (orientation.equals("W")) {
			if (command.equals("DF")) {
				newColumn -= moveDistance;
			} 
			if (command.equals("DB")) {
				newColumn += moveDistance;
			}
		}
		
		if (orientation.equals("E")) {
			if (command.equals("DF")) {
				newColumn += moveDistance;
			} 
			if (command.equals("DB")) {
				newColumn -= moveDistance;
			}
		}
		
		checkForOffMapExceptions(newColumn);
		
		activeColumn = newColumn;
	}

	
	

	private void checkForOffMapExceptions(int columnOrRow) {
		if (columnOrRow >= globalGridSize || columnOrRow < 0) {
			throw new IllegalArgumentException("The avatar has fallen off the map!");
		}
	}

	
	
	
	private void reorientate(String orientation, String command) {
		
		OrientationConverter converter = new OrientationConverter();
		int degreeOrientation = converter.convertToDegrees(orientation);
		
		if (command.equals("TR")) {
			degreeOrientation += 90;
		} 
		
		if (command.equals("TL")) {
			degreeOrientation += 270;	
		}
		
		if (command.equals("UT")) {
			degreeOrientation += 180;
		}
		
		int finalDegreeOrientation = degreeOrientation % 360;
		String finalStringOrientation = converter.convertToString(finalDegreeOrientation);
		
		activeOrientation = finalStringOrientation;
		
	}

	
	

	private void drawBoard(int row, int column, String orientation) {

		clearGameBoard();
	
		int rows = globalGridSize;
	    int columns = globalGridSize;
	    String startBox = "[";		    
	    String endBox = "]";
		String box;

		for (int rowPosition = 0; rowPosition < rows; rowPosition++) {

			for (int columnPosition = 0; columnPosition < columns; columnPosition++) {

				if (rowPosition == row && columnPosition == column) {
					box = startBox + orientation + endBox;
				} else {
					box = startBox + endBox;
				}
				
				if (columnPosition == 0 && rowPosition != 0) {
					gameBoard += "\n" + box;
				} else {
					gameBoard += box;
				}

		    }
		}
	}
	
	
	
	
	
	

	private void clearGameBoard() {
		gameBoard = "";
	}
}

