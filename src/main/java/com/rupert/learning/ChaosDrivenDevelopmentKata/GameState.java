package com.rupert.learning.ChaosDrivenDevelopmentKata;

public class GameState {

	private String gameBoard = "";
	private String gameResults = "[][]\n[][N]";
	private int gridSize = 2;

	
	public String playCommands(int startRow, int startColumn, String startOrientation, String command) {
				
		return gameResults + "\n\n" + doCommand(startRow, startColumn, startOrientation, command);
		
	}
		
	
	public String doCommand(int startRow, int startColumn, String startOrientation, String command) {
		
						
		int newRow = startRow;
		if (command.equals("DF")) {
			newRow -= 1;
		} else if (command.equals("DB")) {
			newRow += 1;
		}

		int newColumn = startColumn;
		
		String finalStringOrientation = reorientate(startOrientation, command);
		
		drawBoard(newRow, newColumn, finalStringOrientation);

	    System.out.println("----------\n" + gameBoard);
        return gameBoard;		    
	
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

