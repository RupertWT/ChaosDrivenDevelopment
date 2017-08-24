package com.rupert.learning.ChaosDrivenDevelopmentKata;

public class GameState {

	private String gameBoard = "";
	private String gameResults = "[][]\n[][N]";
	private int gridSize = 2;

	
	public String playCommands(int startRow, int startColumn, String startOrientation, String[] commands) {
		
		String command = "";
		for (int i = 0; i < commands.length; i++) {
			
			command = commands[i].toString();
			
			//doCommand uses startRow & startColumn need to adjust if it's been used once			
			gameBoard = doCommand(startRow, startColumn, startOrientation, command);
			
			gameResults += "\n\n";
			gameResults += gameBoard;
			
		}
			
		return gameResults;
		
	}
		
	
	public String doCommand(int startRow, int startColumn, String startOrientation, String command) {
		
		int newRow = verticalMove(startRow, startOrientation, command);
		int newColumn = horizontalMove(startColumn, startOrientation, command);
		String finalStringOrientation = reorientate(startOrientation, command);
		
		drawBoard(newRow, newColumn, finalStringOrientation);

	    System.out.println("----------\n" + gameBoard);
        return gameBoard;		    
	
	}


	

	private int verticalMove(int startRow, String startOrientation, String command) {
		
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
		
		System.out.println(newRow);
		return newRow;
	}

	private int horizontalMove(int startColumn, String startOrientation, String command) {
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
		
		return newColumn;
	}


	private void checkForOffMapExceptions(int columnOrRow) {
		if (columnOrRow >= gridSize || columnOrRow < 0) {
			throw new IllegalArgumentException("The avatar has fallen off the map!");
		}
	}

	private String reorientate(String startOrientation, String command) {
		
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
		
		return finalStringOrientation;
		
	}


	private void drawBoard(int rowPosition, int columnPosition, String Orientation) {

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

