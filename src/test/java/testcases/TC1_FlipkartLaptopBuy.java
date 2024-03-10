package testcases;

import org.testng.annotations.Test;

import generics.BaseTest;
import pages.FlipkartHomePage;

public class TC1_FlipkartLaptopBuy extends BaseTest
{
	@Test
	public void laptpbuying() throws Exception
	{
		FlipkartHomePage homepage = new FlipkartHomePage(driver);
		homepage.SearchLaptopmethod();
		homepage.Cartmethod();
	}
}