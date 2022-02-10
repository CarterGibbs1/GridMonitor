/**
 * Tests on "sample4x5.txt" file. 
 * 
 * @author Matt T
*/

public class Test_sample4x5
{
	// File used in tests
	private final String fileName = "sample4x5.txt"; 
	
	// Base grid for given file 
	private static final double[][] baseGrid = { {1, 3, 7, 6, 5},
			  									 {4, 10, 8, 7, 4},
			  									 {5, 5, 7, 8, 7},
			  									 {3, 6, 8, 9, 6} };
	// Surrounding sum grid for given file
	private static final double[][] sumGrid = { {9, 21, 24, 25, 20},
			  									{20, 20, 31, 26, 23},
			  									{17, 28, 29, 30, 25},
			  									{17, 22, 30, 31, 28} };
	// Surrounding average grid for given file 
	private static final double[][] avgGrid = { {2.25, 5.25, 6, 6.25, 5},
			 									{5, 5, 7.75, 6.5, 5.75},
			 									{4.25, 7, 7.25, 7.5, 6.25},
			 									{4.25, 5.5, 7.5, 7.75, 7}};
	// Delta grid for given file
	private static final double[][] deltaGrid = { {1.125, 2.625, 3, 3.125, 2.5},
			   									  {2.5, 2.5, 3.875, 3.25, 2.875},
			   									  {2.125, 3.5, 3.625, 3.75, 3.125},
			   									  {2.125, 2.75, 3.75, 3.875, 3.5} };
	// Danger grid for given file
	private static final boolean[][] dangerGrid = { {true, false, false, false, false},
													{false, true, false, false, false},
													{false, false, false, false, false},
													{false, false, false, false, false} };

	/** 
	 * Run test 
	 */
	public void run()
	{
		// result of running test 
		boolean result; 
		
		try 
		{
			result = GridMonitorTests.getBaseGrid(new GridMonitor(fileName), baseGrid);
			RunGridMonitorTests.printResults("getBaseGrid", result);
			
			result = GridMonitorTests.getSurroundingSumGrid(new GridMonitor(fileName), sumGrid);
			RunGridMonitorTests.printResults("getSurroundingSumGrid", result);
			
			result = GridMonitorTests.getSurroundingAvgGrid(new GridMonitor(fileName), avgGrid);
			RunGridMonitorTests.printResults("getSurroundingAvgGrid", result);
			
			result = GridMonitorTests.getDeltaGrid(new GridMonitor(fileName), deltaGrid);
			RunGridMonitorTests.printResults("getDeltaGrid", result);
			
			result = GridMonitorTests.getDangerGrid(new GridMonitor(fileName), dangerGrid);
			RunGridMonitorTests.printResults("getDangerGrid", result);		

		} 
		catch (Exception e) 
		{
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", fileName);
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns file name
	 * @return fileName - name of file
	 */
	public String getFileName()
	{
		return fileName;
	}

}
