package Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.Writer;
import java.util.List;

/*
 * global variables to use within the realm of this project
*/
public class gVars
{
	public static Writer writer = null;
	public static File reportFile;
	public static Actions action;
	public static String MainBrowserHandle, PopUpHandle, User, Pass, testRun;
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static WebElement webElement = null;
	public static List<WebElement> webElements;

	public static String PRECON = "Precondition", STEP1 = "Step 1", STEP2 = "Step 2", STEP3 = "Step 3";
}
