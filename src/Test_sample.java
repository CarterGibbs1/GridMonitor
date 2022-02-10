/**
 * Tests on "sample.txt" file. 
 * 
 * @author Matt T
*/
public class Test_sample
{
	// File used in tests
	private final String fileName = "sample.txt"; 
	
	// Base grid for given file 
	private static final double[][] baseGrid = { {2, 10, 7},
												 {4, 5, 8},
												 {5, 6, 9} };
	// Surrounding sum grid for given file
	private static final double[][] sumGrid = { {18, 24, 32},
												{16, 28, 29},
												{20, 25, 32} };
	// Surrounding average grid for given file 
	private static final double[][] avgGrid = { {4.5, 6.0, 8.0},
												{4.0, 7.0, 7.25},
												{5.0, 6.25, 8.0} };
	// Delta grid for given file
	private static final double[][] deltaGrid = { {2.25, 3.0, 4.0},
												  {2.0, 3.5, 3.625},
												  {2.5, 3.125, 4.0} };
	// Danger grid for given file
	private static final boolean[][] dangerGrid = { {true, true, false},
													{false, false, false},
												    {false, false, false} };

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
