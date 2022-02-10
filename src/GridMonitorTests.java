/**
 * A unit test class for implementations of the GridMonitor interface.
 * 
 * @author Matt T
 */

public class GridMonitorTests
{
	// margin of error two doubles have to be within to be considered the same value 
	private static final double TOLERANCE = Math.pow(10, -14);

	/**
	 * Tests constructor for GridMonitor class. 
	 * 
	 * @param fileName - name of file 
	 * @return test success - true, if passes test
	 */
	@SuppressWarnings("unused")
	public static boolean constructor(String fileName)
	{
		GridMonitor grid = new GridMonitor(fileName);
		return true;
	}

	/**
	 * Tests whether implements GridMonitorInterface
	 * 
	 * @param fileName - name of file 
	 * @return test success - true, if passes test
	 */
	@SuppressWarnings("unused")
	public static boolean implementsInterface(String fileName)
	{
		GridMonitor grid = new GridMonitor(fileName);
		// invalid assignment will prevent the test class from compiling
		GridMonitorInterface gridInterface = grid;
		return true;
	}

	/**
	 * Tests whether implementation catches FileNotFoundException
	 * 
	 * @param fileName - name of file 
	 * @return test success - true, if passes test
	 */
	@SuppressWarnings("unused")
	public static boolean fileNotFoundException(String fileName)
	{
		GridMonitor grid = new GridMonitor(fileName);
		return true;
	}

	/**
	 * Tests getBaseGrid() method on given GridMonitor object. 
	 * 
	 * @param gridMonitor - implementation of the GridMonitor interface
	 * @param expectedResult - double[][] of base grid values
	 * @return test success - whether passes test or not
	 */
	public static boolean getBaseGrid(GridMonitor gridMonitor, double[][] expectedResult)
	{
		double[][] result = gridMonitor.getBaseGrid(); 
		return isEquivalentDoubleArrays(result, expectedResult);
	}
	
	/**
	 * Tests getSurroundingSumGrid() method on given GridMonitor object. 
	 * 
	 * @param gridMonitor - implementation of the GridMonitor interface
	 * @param expectedResult - double[][] of sums of values surrounding each cell
	 * @return test success - whether passes test or not
	 */
	public static boolean getSurroundingSumGrid(GridMonitor gridMonitor, double[][] expectedResult)
	{
		double[][] result = gridMonitor.getSurroundingSumGrid(); 
		return isEquivalentDoubleArrays(result, expectedResult);	
	}
	
	/**
	 * Tests getSurroundingAvgGrid() method on given GridMonitor object. 
	 * 
	 * @param gridMonitor - implementation of the GridMonitor interface
	 * @param expectedResult - double[][] of averages of values surrounding each cell
	 * @return test success - whether passes test or not
	 */
	public static boolean getSurroundingAvgGrid(GridMonitor gridMonitor, double[][] expectedResult)
	{
		double[][] result = gridMonitor.getSurroundingAvgGrid(); 
		return isEquivalentDoubleArrays(result, expectedResult);		
	}
	
	/**
	 * Tests getDeltaGrid() method on given GridMonitor object. 
	 * 
	 * @param gridMonitor - implementation of the GridMonitor interface
	 * @param expectedResult - double[][] of max deltas of values surrounding each cell
	 * @return test success - whether passes test or not
	 */
	public static boolean getDeltaGrid(GridMonitor gridMonitor, double[][] expectedResult)
	{
		double[][] result = gridMonitor.getDeltaGrid(); 
		return isEquivalentDoubleArrays(result, expectedResult);			
	}

	/**
	 * Tests getDangerGrid() method on given GridMonitor object. 
	 * 
	 * @param gridMonitor - implementation of the GridMonitor interface
	 * @param expectedResult - boolean[][] - whether a given cell is in Danger Zone or not
	 * @return test success - whether passes test or not
	 */
	public static boolean getDangerGrid(GridMonitor gridMonitor, boolean[][] expectedResult)
	{
		boolean[][] result = gridMonitor.getDangerGrid(); 
		return isEquivalentBooleanArrays(result, expectedResult);			
	}
	
	/**
	 * Tests encapsulation of base grid for given GridMonitor object. 
	 * 
	 * @param gridMonitor - implementation of the GridMonitor interface
	 * @param expectedResult - double[][] of base grid values
	 * @return test success - whether passes test or not
	 */
	public static boolean baseGridEncapsulation(GridMonitor gridMonitor, double[][] expectedResult)
	{
		double[][] result = gridMonitor.getBaseGrid(); 
		result[0][0] = 0.0;
		return isEquivalentDoubleArrays(result, expectedResult);
	}
	
	/**
	 * Tests encapsulation of surrounding sum grid for given GridMonitor object. 
	 * 
	 * @param gridMonitor - implementation of the GridMonitor interface
	 * @param expectedResult - double[][] of sums of values surrounding each cell
	 * @return test success - whether passes test or not
	 */
	public static boolean surroundingSumGridEncapsulation(GridMonitor gridMonitor, double[][] expectedResult)
	{
		double[][] result = gridMonitor.getSurroundingSumGrid();
		result[0][0] = 0.0;
		return isEquivalentDoubleArrays(result, expectedResult);	
	}
	
	/**
	 * Tests encapsulation of surrounding average grid for given GridMonitor object. 
	 * 
	 * @param gridMonitor - implementation of the GridMonitor interface
	 * @param expectedResult - double[][] of averages of values surrounding each cell
	 * @return test success - whether passes test or not
	 */
	public static boolean surroundingAvgGridEncapsulation(GridMonitor gridMonitor, double[][] expectedResult)
	{
		double[][] result = gridMonitor.getSurroundingAvgGrid(); 
		result[0][0] = 0.0;
		return isEquivalentDoubleArrays(result, expectedResult);		
	}
	
	/**
	 * Tests encapsulation of delta grid for given GridMonitor object. 
	 * 
	 * @param gridMonitor - implementation of the GridMonitor interface
	 * @param expectedResult - double[][] of max deltas of values surrounding each cell
	 * @return test success - whether passes test or not
	 */
	public static boolean deltaGridEncapsulation(GridMonitor gridMonitor, double[][] expectedResult)
	{
		double[][] result = gridMonitor.getDeltaGrid(); 
		result[0][0] = 0.0;
		return isEquivalentDoubleArrays(result, expectedResult);			
	}

	/**
	 * Tests encapsulation of danger grid for given GridMonitor object. 
	 * 
	 * @param gridMonitor - implementation of the GridMonitor interface
	 * @param expectedResult - boolean[][] - whether a given cell is in Danger Zone or not
	 * @param oppositeValue - boolean - value opposite expected boolean at expectedResult[0][0]
	 * @return test success - whether passes test or not
	 */
	public static boolean dangerGridEncapsulation(GridMonitor gridMonitor, boolean[][] expectedResult, boolean oppositeValue)
	{
		boolean[][] result = gridMonitor.getDangerGrid(); 
		result[0][0] = oppositeValue;
		return isEquivalentBooleanArrays(result, expectedResult);			
	}

	
	/******************** Utility Functions *****************************/
	
	/** Compare two doubles and return true if they are within TOLERANCE, else false
	 * @param v1 - first value to compare
	 * @param v2 - second value to compare
	 * @return boolean - whether values are within TOLERANCE
	 */
	private static boolean isClose(double v1, double v2) 
	{
		return (Math.abs(v1 - v2) < TOLERANCE);
	}

	/** Compare two two-dimensional double arrays for equivalence.
	 * @param a1 - double[][]
	 * @param a2 - double[][]
	 * @return boolean - true if all values are within the given tolerance; false otherwise
	 */
	private static boolean isEquivalentDoubleArrays(double[][] a1, double[][] a2) 
	{
		// return true, unless set otherwise
		boolean equivalent = true;
		
		// not true if number of rows don't match 
		if (a1.length != a2.length || (a1.length > 1 && a1[0].length != a2[0].length)) 
		{
			equivalent = false;
		} 
		else 
		{
			// loop through comparing each cell 
			for (int row = 0; row < a1.length; row++) 
			{
				for (int col = 0; col < a1[0].length; col++) 
				{
					// not true is number of columns don't match 
					if (row >= a2.length || a1[row].length != a2[row].length) 
					{
						equivalent = false;
					} 
					else 
					{
						// not true if values not within level of tolerance 
						if (!isClose(a1[row][col], a2[row][col])) 
						{
							equivalent = false;
						}
					}
				}
			}
		}
		return equivalent;
	}
	
	/** Compare two two-dimensional boolean arrays for equivalence.
	 * @param a1 first - boolean[][]
	 * @param a2 second - boolean[][]
	 * @return boolean - true if all values are identical; false otherwise
	 */
	private static boolean isEquivalentBooleanArrays(boolean[][] a1, boolean[][] a2) 
	{
		// assume true, unless set otherwise
		boolean equivalent = true;
		
		// not true if number of rows not the same 
		if (a1.length != a2.length || (a1.length > 1 && a1[0].length != a2[0].length)) 
		{
			equivalent = false;
		} 
		else 
		{
			// loop through comparing cells 
			for (int row = 0; row < a1.length; row++) 
			{
				for (int col = 0; col < a1[0].length; col++) 
				{
					// not true, if number of columns not same 
					if (row >= a2.length || a1[row].length != a2[row].length) 
					{
						equivalent = false;
					} 
					else 
					{
						// not true is values not the same
						if (a1[row][col] != a2[row][col]) 
						{
							equivalent = false;
						}
					}
				}
			}
		}
		return equivalent;
	}

}
