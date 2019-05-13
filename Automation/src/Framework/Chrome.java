package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Functions.gFunc;
import Functions.gVars;

public class Chrome
{
	public static void start(String URL)
	{
		
		if (gVars.driver == null)
		{
			gVars.driver = new ChromeDriver();
		}

		gVars.wait = new WebDriverWait(gVars.driver, 30);
		gVars.action = new Actions(gVars.driver);
		gVars.driver.manage().window().maximize();
		//System.out.println("Selenium Webdriver Script in Chrome browser");
		gVars.MainBrowserHandle = gVars.driver.getWindowHandle();
		gVars.driver.get(URL);
	}

	public static void logIn(String state)
	{
		/*
		String curPage = gVars.driver.getCurrentUrl();
		
		System.out.println(curPage);
		if (!curPage.contentEquals("http://newtours.demoaut.com/") || !curPage.contains("/mercurywelcome.php") || !curPage.contains("/index.php") || !curPage.contains("/mercurysignon.php"))
		{*/
			menu("SIGN-ON");
			System.out.println(gVars.driver.getCurrentUrl());
			gVars.webElement = gVars.driver.findElement(By.name("userName"));
			gVars.webElement.clear();
			gVars.webElement.sendKeys(gVars.User);
			gVars.webElement = gVars.driver.findElement(By.name("password"));
			gVars.webElement.clear();
			gVars.webElement.sendKeys(gVars.Pass);
			gVars.webElement = null;
			gVars.driver.findElement(By.name("login")).click();
		/*}
		else
		{
			if (gVars.driver.findElement(By.name("login")).isDisplayed())
			{
				gVars.webElement = gVars.driver.findElement(By.name("userName"));
				gVars.webElement.clear();
				gVars.webElement.sendKeys(gVars.User);
				gVars.webElement = gVars.driver.findElement(By.name("password"));
				gVars.webElement.clear();
				gVars.webElement.sendKeys(gVars.Pass);
				gVars.webElement = null;
				gVars.driver.findElement(By.name("login")).click();
			}
			else
			{
				System.out.println("Cannot login");
			}
		}*/

		gFunc.Sleep(500);
		switch(state)
		{
			case "POS":
			{
				Boolean finalize;
				if (gVars.testRun.contains("03_FlightReservation_A_POS"))
				{
					finalize = false;
				}
				else
				{
					finalize = true;
				}
				try {
					gVars.driver.findElement(By.name("fromPort")).isDisplayed();
				} catch (NoSuchElementException e) {
					gFunc.Report(gVars.testRun, gVars.STEP2, "Failed", finalize);
					return;
				}

				gFunc.Report(gVars.testRun, gVars.STEP2, "Successfull", finalize);
				return;
			}
			case "NEG":
			{
				gFunc.Report(gVars.testRun, gVars.STEP2, "Successfull", true);
				return;
			}
			default:
			{
				return;
			}
		}
	}
	
	public static void menu(String btn)
	{
		try {
			gVars.driver.findElement(By.linkText(btn)).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Button not found");
		}
	}
	
	public static void close()
	{
		if (gVars.driver != null)
		{
			gVars.driver.close();
			gVars.driver = null;
		}
	}
	
	public static void bookFlight(String tripType, int passCount, String fromPort, String fromMonth, int fromDay, String toPort, String toMonth, int toDay, String servClass, String airline)
	{
		menu("Flights");
		Select dropdown;
		
		//gVars.webElement = gVars.driver.findElement(By.name("tripType"));
		
		dropdown = new Select(gVars.driver.findElement(By.name("passCount")));
		dropdown.selectByValue(Integer.toString(passCount));

		dropdown = new Select(gVars.driver.findElement(By.name("fromPort")));
		dropdown.selectByValue(fromPort);

		dropdown = new Select(gVars.driver.findElement(By.name("fromMonth")));
		switch(fromMonth)
		{
			case "January":
			{
				dropdown.selectByIndex(0);
				break;
			}
			case "Febuary":
			{
				dropdown.selectByIndex(1);
				break;
			}
			case "March":
			{
				dropdown.selectByIndex(2);
				break;
			}
			case "April":
			{
				dropdown.selectByIndex(3);
				break;
			}
			case "May":
			{
				dropdown.selectByIndex(4);
				break;
			}
			case "June":
			{
				dropdown.selectByIndex(5);
				break;
			}
			case "July":
			{
				dropdown.selectByIndex(6);
				break;
			}
			case "August":
			{
				dropdown.selectByIndex(7);
				break;
			}
			case "September":
			{
				dropdown.selectByIndex(8);
				break;
			}
			case "October":
			{
				dropdown.selectByIndex(9);
				break;
			}
			case "November":
			{
				dropdown.selectByIndex(10);
				break;
			}
			case "December":
			{
				dropdown.selectByIndex(11);
				break;
			}
		}

		dropdown = new Select(gVars.driver.findElement(By.name("fromDay")));
		dropdown.selectByValue(Integer.toString(fromDay));

		dropdown = new Select(gVars.driver.findElement(By.name("toPort")));
		dropdown.selectByValue(toPort);

		dropdown = new Select(gVars.driver.findElement(By.name("toMonth")));
		switch(toMonth)
		{
			case "January":
			{
				dropdown.selectByIndex(0);
				break;
			}
			case "Febuary":
			{
				dropdown.selectByIndex(1);
				break;
			}
			case "March":
			{
				dropdown.selectByIndex(2);
				break;
			}
			case "April":
			{
				dropdown.selectByIndex(3);
				break;
			}
			case "May":
			{
				dropdown.selectByIndex(4);
				break;
			}
			case "June":
			{
				dropdown.selectByIndex(5);
				break;
			}
			case "July":
			{
				dropdown.selectByIndex(6);
				break;
			}
			case "August":
			{
				dropdown.selectByIndex(7);
				break;
			}
			case "September":
			{
				dropdown.selectByIndex(8);
				break;
			}
			case "October":
			{
				dropdown.selectByIndex(9);
				break;
			}
			case "November":
			{
				dropdown.selectByIndex(10);
				break;
			}
			case "December":
			{
				dropdown.selectByIndex(11);
				break;
			}
		}
		
		dropdown = new Select(gVars.driver.findElement(By.name("toDay")));
		dropdown.selectByValue(Integer.toString(toDay));

		dropdown = new Select(gVars.driver.findElement(By.name("airline")));
		switch(airline)
		{
			case "No Preference":
			{
				dropdown.selectByIndex(0);
				break;
			}
			case "Blue Skies Airlines":
			{
				dropdown.selectByIndex(1);
				break;
			}
			case "Unified Airlines":
			{
				dropdown.selectByIndex(2);
				break;
			}
			case "Pangea Airlines":
			{
				dropdown.selectByIndex(3);
				break;
			}
		}
		
		gVars.driver.findElement(By.name("findFlights")).click();
		

		try {
			gVars.driver.findElement(By.name("reserveFlights")).isDisplayed();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Button not found");
			gFunc.Report(gVars.testRun, gVars.STEP3, "Failed", true);
			return;
		}
		
		gFunc.Report(gVars.testRun, gVars.STEP3, "Successfull", false);
		gVars.driver.findElement(By.name("reserveFlights")).click();
		

		try {
			gVars.driver.findElement(By.name("buyFlights")).isDisplayed();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Button not found");
			gFunc.Report(gVars.testRun, gVars.STEP4, "Failed", true);
			return;
		}
		
		gFunc.Report(gVars.testRun, gVars.STEP4, "Successfull", false);
		gVars.driver.findElement(By.name("buyFlights")).click();
		

		try {
			gVars.driver.findElement(By.xpath("//*[text()[contains(.,'itinerary has been booked!')]]")).isDisplayed();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Button not found");
			gFunc.Report(gVars.testRun, gVars.STEP5, "Failed", true);
			return;
		}
		
		gFunc.Report(gVars.testRun, gVars.STEP5, "Successfull", true);
		System.out.println("Booking finished");
	}
	
	public static void SwitchToWindow(String window)
	{
		gVars.driver.switchTo().window(window);
	}
}
