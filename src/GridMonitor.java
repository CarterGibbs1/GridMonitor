/**
 * Implementation of the GridMonitorInterface
 * 
 * @author Carter Gibbs
 *
 */
import java.io.*;
import java.util.*;
public class GridMonitor implements GridMonitorInterface {
	/**
	 * Constants to easily change across the program.
	 */
	private static final int AVERAGE_DIVISIBLE = 4;
	private static final double DELTA_PERCENTAGE = 0.5;
	
	/**
	 * rows and columns field, initialized as integers.
	 */
	private int rows, columns;
	
	/**
	 * 2D arrays for the grids
	 * dangerGrid is boolean, the rest are doubles.
	 */
	private double[][] baseGrid, surroundingSumGrid, surroundingAvgGrid, deltaGrid;
	private boolean[][] dangerGrid;
	
	/**
	 * Constructor method that will read in a file name and analyze the data
	 * that is contained in the file. Also catches a FileNotFoundException here.
	 * @param a String that represents the file name. Typically is a .txt file.
	 */
	public GridMonitor(String filename) {
		try {
			readFile(filename);
			fillInGrids();
		} catch (FileNotFoundException e) {
		}
	}
	
	/**
	 * The method will read in a file using a Scanner. It will assign any data
	 * to a 2D array. It will keep reading in data as long as there is another
	 * token to read.
	 * @param a String that represents the file name. Typically is a .txt file.
	 * @throws FileNotFoundException to the constructor class
	 */
	@SuppressWarnings("resource")
	private void readFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner readingFile = new Scanner(file);
		rows = readingFile.nextInt();
		columns = readingFile.nextInt();
		baseGrid = new double[rows][columns];
		readingFile.nextLine();
		int columnIndex = 0;
		while(readingFile.hasNextLine()) {
			int rowIndex = 0;
			String fileLine = readingFile.nextLine();
			Scanner readingLine = new Scanner(fileLine);
			while(readingLine.hasNext()) {
				baseGrid[columnIndex][rowIndex] = readingLine.nextDouble();
				rowIndex++;
			}
			columnIndex++;
		}
	}
	
	/**
	 * This method will initialize the grid 2D arrays and then use a nested for-loop
	 * to run through all indexes of the array and fill in each individual element.
	 */
	private void fillInGrids() {
		surroundingSumGrid = new double[rows][columns];
		surroundingAvgGrid = new double[rows][columns];
		deltaGrid = new double[rows][columns];
		dangerGrid = new boolean[rows][columns];
		for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
			for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
				calculateSurroundingSums(rowIndex, columnIndex);
				calculateAvg(rowIndex, columnIndex);
				calculateDelta(rowIndex, columnIndex);
				calculateDanger(rowIndex, columnIndex);
				
			}
		}
	}
	
	/**
	 * The method will add up the surrounding cell values of an
	 * individual cell and assign those values to a different array
	 * @param rowIndex represents the row index of the grid
	 * @param columnIndex represents the column index of the grid
	 */
	private void calculateSurroundingSums(int rowIndex, int columnIndex) {
		surroundingSumGrid[rowIndex][columnIndex] = getTop(baseGrid, rowIndex, columnIndex)
													+ getBottom(baseGrid, rowIndex, columnIndex)
													+ getRight(baseGrid, rowIndex, columnIndex)
													+ getLeft(baseGrid, rowIndex, columnIndex);
	}
	
	/**
	 * The method will find the average of the surrounding cell values
	 * by dividing each element in the surroundingSumGrid by 4.
	 * It will then assign the value to a different array
	 * @param rowIndex represents the row index of the grid
	 * @param columnIndex represents the column index of the grid
	 */
	private void calculateAvg(int rowIndex, int columnIndex) {
		surroundingAvgGrid[rowIndex][columnIndex] = surroundingSumGrid[rowIndex][columnIndex]
													/ AVERAGE_DIVISIBLE;
	}
	
	/**
	 * The method will find the delta/range of the individual cells by multiplying
	 * each element of the surroundingAvgGrid by 0.5. It will then assign those values
	 * to a different array.
	 * @param rowIndex represents the row index of the grid
	 * @param columnIndex represents the column index of the grid
	 */
	private void calculateDelta(int rowIndex, int columnIndex) {
		deltaGrid[rowIndex][columnIndex] = surroundingAvgGrid[rowIndex][columnIndex]
										   * DELTA_PERCENTAGE;
	}
	
	/**
	 * This method will determine if the baseGrid values fall in the range of
	 * the surroundingAvgGrid values plus or minus the delta. If it does not
	 * fall in the range, then the cell is in danger and will be assigned as
	 * true at the element's index in a new 2D array.
	 * @param rowIndex represents the row index of the grid
	 * @param columnIndex represents the column index of the grid
	 */
	private void calculateDanger(int rowIndex, int columnIndex) {
		if (Math.abs(baseGrid[rowIndex][columnIndex]) < 
			         Math.abs(surroundingAvgGrid[rowIndex][columnIndex]
					 - deltaGrid[rowIndex][columnIndex])) {
			dangerGrid[rowIndex][columnIndex] = true;
			
		} else if (Math.abs(baseGrid[rowIndex][columnIndex]) > 
				   			Math.abs(surroundingAvgGrid[rowIndex][columnIndex]
						    + deltaGrid[rowIndex][columnIndex])) {
			dangerGrid[rowIndex][columnIndex] = true;
		}
	}
	
	/**
	 * Will find the element above the indexed element. If no above element exists
	 * it will return the indexed element itself
	 * @param grid is a 2D array of data
	 * @param rowIndex represents the row index of the grid
	 * @param columnIndex represents the column index of the grid
	 * @return element above indexed element or element itself
	 */
	private double getTop(double[][] grid, int rowIndex, int columnIndex) {
		if (rowIndex - 1 >= 0) {
			return grid[rowIndex - 1][columnIndex];
		}
		return grid[rowIndex][columnIndex];
	}
	
	/**
	 * Will find the element below the indexed element. If no below element exists
	 * it will return the indexed element itself
	 * @param grid is a 2D array of data
	 * @param rowIndex represents the row index of the grid
	 * @param columnIndex represents the column index of the grid
	 * @return element below indexed element or element itself
	 */
	private double getBottom(double[][] grid, int rowIndex, int columnIndex) {
		if (rowIndex + 1 < rows) {
			return grid[rowIndex + 1][columnIndex];
		}
		return grid[rowIndex][columnIndex];
	}
	
	/**
	 * Will find the element left of the indexed element. If no left element exists
	 * it will return the indexed element itself
	 * @param grid is a 2D array of data
	 * @param rowIndex represents the row index of the grid
	 * @param columnIndex represents the column index of the grid
	 * @return element left of indexed element or element itself
	 */
	private double getLeft(double[][] grid, int rowIndex, int columnIndex) {
		if (columnIndex - 1 >= 0) {
			return grid[rowIndex][columnIndex - 1];
		}
		return grid[rowIndex][columnIndex];
	}
	
	/**
	 * Will find the element right of the indexed element. If no right element exists
	 * it will return the indexed element itself
	 * @param grid is a 2D array of data
	 * @param rowIndex represents the row index of the grid
	 * @param columnIndex represents the column index of the grid
	 * @return element right of indexed element or element itself
	 */
	private double getRight(double[][] grid, int rowIndex, int columnIndex) {
		if (columnIndex + 1 < columns) {
			return grid[rowIndex][columnIndex + 1];
		}
		return grid[rowIndex][columnIndex];
	}
	/**
	 * The method will run through every element of an array
	 * and copy that element into a new reference array
	 * @param grid is a 2D array of data
	 * @return a reference array of doubles
	 */
	private double[][] doubleReferenceArray(double[][] grid) {
		double[][] referenceArray = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				referenceArray[i][j] = grid[i][j];
			}
		}
		return referenceArray;
	}
	
	/**
	 * The method will run through every element of an array
	 * and copy that element into a new reference array
	 * @param grid is a 2D array of data
	 * @return a reference array of booleans
	 */
	private boolean[][] booleanReferenceArray(boolean[][] grid) {
		boolean[][] referenceArray = new boolean[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				referenceArray[i][j] = grid[i][j];
			}
		}
		return referenceArray;
	}

	// The methods below are described in GridMonitorInterface.
	
	@Override
	public double[][] getBaseGrid() {
		return doubleReferenceArray(baseGrid);
	}

	@Override
	public double[][] getSurroundingSumGrid() {
		return doubleReferenceArray(surroundingSumGrid);
	}

	@Override
	public double[][] getSurroundingAvgGrid() {
		return doubleReferenceArray(surroundingAvgGrid);
	}

	@Override
	public double[][] getDeltaGrid() {
		return doubleReferenceArray(deltaGrid);
	}

	@Override
	public boolean[][] getDangerGrid() {
		return booleanReferenceArray(dangerGrid);
	}

}
