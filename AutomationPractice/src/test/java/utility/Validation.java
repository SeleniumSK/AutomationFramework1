package utility;

import org.testng.Assert;

public class Validation {
	
	public static void validate(String actual, String expected)
	{
		
		Assert.assertEquals(actual, expected);
	}
	public static void validate(int actual, int expected)
	{
		
		Assert.assertEquals(actual, expected);
	}
	public static void validate(double actual, double expected)
	{
		
		Assert.assertEquals(actual, expected);
	}
	public static void validate(char actual, char expected)
	{
		
		Assert.assertEquals(actual, expected);
	}
	public static void validateContent(String actual, String partialTextTobeMatched)
	{
		boolean status = actual.contains(partialTextTobeMatched);
		Assert.assertEquals(status, "Content Verification Failed");
	}
	

}
