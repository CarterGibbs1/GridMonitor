/**
 * Tests whether GridMonitor constructor works, implements interface,
 * and doesn't throw a FileNotFoundException.  
 * 
 * @author Matt T
*/

public class Test_basics
{
	// File used in tests
	private final String fileName = "sample.txt"; 
	// Name of file that doesn't exist
	private final String noSuchFile = "noSuchFile.txt"; 
	
	/** 
	 * Run test 
	 */
	public void run()
	{
		// result of running test 
		boolean result; 
		
		try 
		{
			result = GridMonitorTests.constructor(fileName);
			RunGridMonitorTests.printResults("Constructor works", result);
			
			result = GridMonitorTests.implementsInterface(fileName);
			RunGridMonitorTests.printResults("Implements GridMonitor Interface", result);
			
			result = GridMonitorTests.fileNotFoundException(noSuchFile);
			RunGridMonitorTests.printResults("Doesn't throw FileNotFoundException", result);
			
		} 
		catch (Exception e) 
		{
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", "basic tests");
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns file name
	 * @return fileName - name of file
	 */
	public String getFileName()
	{
		return "Basic Tests";
	}


}
