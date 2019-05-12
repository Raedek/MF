package Framework;

import Functions.gFunc;
import Functions.gVars;
import org.openqa.selenium.By;

public class Main {

	public static void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumWebdrivers/chromedriver.exe");
	}
	
	public static void test1(String URL)
	{
		gVars.User = "Raedek";
		gVars.Pass = "abc1";
		gVars.testRun = "01_SignIn_A_POS";
		gFunc.Report(gVars.testRun, gVars.PRECON, "Successfull", false);
		Chrome.start(URL);
		gFunc.Sleep(1000);
		gFunc.Report(gVars.testRun, gVars.STEP1, "Successfull", false);
		Chrome.logIn("POS");
		gFunc.Sleep(1000);
		Chrome.close();
	}
	
	public static void test2(String URL)
	{
		gVars.testRun = "02_SignIn_A_NEG";
		gVars.User = "nonexistentUser";
		gVars.Pass = "randomPassword";
		gFunc.Report(gVars.testRun, gVars.PRECON, "Successfull", false);
		Chrome.start(URL);
		gFunc.Sleep(1000);
		gFunc.Report(gVars.testRun, gVars.STEP1, "Successfull", false);
		Chrome.logIn("NEG");
		gFunc.Sleep(1000);
		Chrome.close();
	}
	
	public static void test3(String URL)
	{
		gVars.User = "Raedek";
		gVars.Pass = "abc1";
		gVars.testRun = "03_FlightReservation_A_POS";
		gFunc.Report(gVars.testRun, gVars.PRECON, "Successfull", false);
		Chrome.start(URL);
		gFunc.Sleep(1000);
		gFunc.Report(gVars.testRun, gVars.STEP1, "Successfull", false);
		Chrome.logIn("POS");

		gFunc.Sleep(1000);
		Chrome.bookFlight("roundtrip", 2, "New York", "June", 7, "San Francisco", "July", 6, "Economy class", "Blue Skies Airlines");	// airlines: {No Preference | Blue Skies Airlines | Unified Airlines | Pangea Airlines}
		gFunc.Report(gVars.testRun, gVars.STEP3, "Successfull", true);
		gFunc.Sleep(1000);
		
		Chrome.close();
	}
	
	public static void main(String[] args)
	{
		String testPage = "http://newtours.demoaut.com";
		init();
		
		test1(testPage);
		gFunc.Sleep(5000);
		
		test2(testPage);
		gFunc.Sleep(5000);

		test3(testPage);
	}

}
