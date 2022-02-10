/**
 * Tests on "negatives.txt" file. 
 * 
 * @author Matt T
*/

public class Test_negatives
{
	// File used in tests
	private final String fileName = "negatives.txt"; 
	
	// Base grid for given file 
	private static final double[][] baseGrid = { {-5, -4, -5},
												 {-2, -1, -2},
												 {-1, -3, -1} }; 
	// Surrounding sum grid for given file
	private static final double[][] sumGrid = { {-16, -15, -16},
												{-9, -11, -9},
												{-7, -6, -7} }; 	
	// Surrounding average grid for given file 
	private static final double[][] avgGrid = { {-4, -3.75, -4},
												{-2.25, -2.75, -2.25},
												{-1.75, -1.5, -1.75} }; 	
	// Delta grid for given file
	private static final double[][] deltaGrid = { {-2, -1.875, -2},
												  {-1.125, -1.375, -1.125},
												  {-0.875, -0.75, -0.875} }; 
	// Danger grid for given file
	private static final boolean[][] dangerGrid = { {false, false, false},
													{false, true, false},
													{false, true, false} };	

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
