package retryLogic.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import retryLogic.Analyzer.RetryAnalyzer;

public class MyTest {
	@Test
	public void test1() {
		Assert.assertEquals(false, true);
	}
	@Test
	public void test2() {
		Assert.assertEquals(false, true);
	}
}
