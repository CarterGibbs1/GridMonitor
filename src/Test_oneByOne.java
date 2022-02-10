/**
 * Tests on "oneByOne.txt" file. 
 * 
 * @author Matt T
*/

public class Test_oneByOne
{
	// File used in tests
	private final String fileName = "oneByOne.txt"; 
	
	// Base grid for given file 
	private static final double[][] baseGrid = { {5} };
	
	// Surrounding sum grid for given file
	private static final double[][] sumGrid = { {20} };
	
	// Surrounding average grid for given file 
	private static final double[][] avgGrid = { {5} };
	
	// Delta grid for given file
	private static final double[][] deltaGrid = { {2.5} };
	
	// Danger grid for given file
	private static final boolean[][] dangerGrid = { {false} };
	
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
