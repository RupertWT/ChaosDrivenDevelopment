package com.rupert.learning.ChaosDrivenDevelopmentKata;

public class GameState {

	private String gameBoard = "";
	private String gameResults = "[][]\n[][N]";

	public String playCommands(int gridSize, int rowStartPosition, int columnStartPosition, String startOrientation, String command) {
				
		return gameResults + "\n\n" + doCommand(gridSize, rowStartPosition, columnStartPosition, startOrientation, command);
		
	}
		
	public String doCommand(int gridSize, int rowStartPosition, int columnStartPosition, String startOrientation, String command) {
		
		
		int rowNewPosition = rowStartPosition;
		int columnNewPosition = columnStartPosition;
		
		if (command.equals("DF")) {
			rowNewPosition -= 1;
		} else if (command.equals("DB")) {
			rowNewPosition += 1;
		}

		OrienationConverter converter = new OrienationConverter();
		int degreeOrientation = converter.convertToDegrees(startOrientation);
		
		if (command.equals("TR")) {
			degreeOrientation += 90;
		} else if (command.equals("TL")) {
			if (degreeOrientation == 0) {
				degreeOrientation += 360;
			}
			degreeOrientation -= 90;	
		}
		
		int finalOrientation = degreeOrientation % 360;
		String Orientation = converter.convertToString(finalOrientation);
		
		drawBoard(gridSize, rowNewPosition, columnNewPosition, Orientation);

	    System.out.println("----------\n" + gameBoard);
        return gameBoard;		    
	
	}




	private void drawBoard(int gridSize, int rowPosition, int columnPosition, String Orientation) {

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
