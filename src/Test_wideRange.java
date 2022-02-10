/**
 * Tests on "wideRange.txt" file. 
 * 
 * @author Matt T
*/

public class Test_wideRange
{
	// File used in tests
	private final String fileName = "wideRange.txt"; 
	
	// Base grid for given file 
	private static final double[][] baseGrid = { {1, 1, 1},
			 									 {-2000, 10, 2000},
			 									 {1, 1, 1} };
	
	// Surrounding sum grid for given file
	private static final double[][] sumGrid = { {-1997, 13, 2003},
			 									{-1988, 2, 2012},
			 									{-1997, 13, 2003} };
	
	// Surrounding average grid for given file 
	private static final double[][] avgGrid = {	 {-499.25, 3.25, 500.75},
			 									 {-497, 0.5, 503},
			 									 {-499.25, 3.25, 500.75} };
	
	// Delta grid for given file
	private static final double[][] deltaGrid = { {-249.625, 1.625, 250.375},
			 									  {-248.5, 0.25, 251.5},
			 									  {-249.625, 1.625, 250.375} };
	
	// Danger grid for given file
	private static final boolean[][] dangerGrid = { {true, true, true},
													{true, true, true},
													{true, true, true} };

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
