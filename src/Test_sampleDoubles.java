/**
 * Tests on "sampleDoubles.txt" file. 
 * 
 * @author Matt T
*/

public class Test_sampleDoubles
{
	// File used in tests
	private final String fileName = "sampleDoubles.txt"; 
	
	// Base grid for given file 
	private static final double[][] baseGrid = { {2.5, 10.5, 7.5},
		    									 {4.5, 5.5, 8.5},
		    									 {5.5, 6.5, 9.5} };

	// Surrounding sum grid for given file
	private static final double[][] sumGrid = { {20, 26, 34},
		    									{18, 30, 31},
		    									{22, 27, 34} };

	// Surrounding average grid for given file 
	private static final double[][] avgGrid = { {5, 6.5, 8.5},
		    									{4.5, 7.5, 7.75},
		    									{5.5, 6.75, 8.5} };
	
	// Delta grid for given file
	private static final double[][] deltaGrid = { {2.5, 3.25, 4.25},
		    									  {2.25, 3.75, 3.875},
		    									  {2.75, 3.375, 4.25} };
	
	// Danger grid for given file
	private static final boolean[][] dangerGrid = { {false, true, false},
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
