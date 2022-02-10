/**
 * Runs a set of black box tests that
 * should work for any implementation of GridMonitor interface.
 * 
 * @author Matt T, mvail
 */
public class RunGridMonitorTests
{
	// total test count
	private static int TOTAL_TESTS = 33;

	// instance variables for tracking test results
	private static int passes = 0;
	private static int failures = 0;
	private static int total = 0;

	/** 
	 * Run tests
	 * @param args - not used in this test suite
	 */
	public static void main(String[] args)
	{
		runTests();
		
		// report final verdict
		printFinalSummary();
	}
	
	/** 
	 * Run tests to confirm required functionality of constructors and methods 
	*/
	private static void runTests()
	{
		// test basic functionality
		Test_basics test_basics = new Test_basics(); 
		printFileName(test_basics.getFileName());
		test_basics.run(); 
		printLine(); 	
		
		// test "sample.txt"
		Test_sample test_sample = new Test_sample(); 
		printFileName(test_sample.getFileName());
		test_sample.run(); 
		printLine(); 	
		
		// test "sample4x5.txt"
		Test_sample4x5 test_sample4x5 = new Test_sample4x5(); 
		printFileName(test_sample4x5.getFileName());
		test_sample4x5.run(); 
		printLine(); 	
				
		// test "negatives.txt"
		Test_negatives test_negatives = new Test_negatives(); 
		printFileName(test_negatives.getFileName());
		test_negatives.run(); 
		printLine(); 	
				
		// test "oneByOne.txt"
		Test_oneByOne test_oneByOne = new Test_oneByOne(); 
		printFileName(test_oneByOne.getFileName());
		test_oneByOne.run(); 
		printLine(); 	
				
		// test "sampleDoubles.txt"
		Test_sampleDoubles test_sampleDoubles = new Test_sampleDoubles(); 
		printFileName(test_sampleDoubles.getFileName());
		test_sampleDoubles.run(); 
		printLine(); 	
				
		// test "wideRange.txt"
		Test_wideRange test_wideRange = new Test_wideRange(); 
		printFileName(test_wideRange.getFileName());
		test_wideRange.run(); 
		printLine(); 				

	}
	
	/**
	 * Print test results in a consistent format
	 * 
	 * @param testDesc - description of the test
	 * @param result - indicates whether the test passed or failed
	 */	
	public static void printResults(String testDesc, boolean result)
	{
		total++;
		if (result) 
		{
			passes++;
		} 
		else 
		{
			failures++;
		}
		System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
	}

	/** 
	 * Print a final summary 
	 */
	private static void printFinalSummary()
	{
		System.out.printf("\nTotal Tests Run: %d of %d,  Passed: %d,  "
				           + "Failed: %d\n", total, TOTAL_TESTS, passes, failures);
	}
	
	/**
	 * Prints name of file tests run on
	 * @param fileName - name of file 
	 */
	private static void printFileName(String fileName)
	{
		System.out.println(fileName);		
	}

	/** 
	 * Prints line between sets of tests
	 */
	private static void printLine()
	{
		System.out.println("=======================================================");
		
	}

}
