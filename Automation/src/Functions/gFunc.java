package Functions;


import java.io.*;
import java.nio.charset.StandardCharsets;


/*
 * global functions to use within the realm of this project
*/
public class gFunc {

	public static void Sleep(long sleep)	//Delay function for runtime; param in ms!
	{
		try	{
		    Thread.sleep(sleep);
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
		}
    }
	
	public static void Report(String testName, String testStep, String stepStatus, boolean finalize)
	{
		gVars.reportFile = new File("C:/Projects/RS_test/report_" + testName + ".txt");
		File parent = gVars.reportFile.getParentFile();
		if (!parent.exists() && !parent.mkdirs())
		{
		    throw new IllegalStateException("Couldn't create dir: " + parent);
		}
		
		if (!gVars.reportFile.exists())
		{
			try {
				gVars.reportFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			if (testStep.equals(gVars.PRECON)/* && gVars.reportFile.length() > 0*/)
			writeToFile(gVars.reportFile.getPath(), "", true);
		}

		String filePath = gVars.reportFile.getPath();
		System.out.println(filePath);
		if (finalize == true)
		{
			writeToFile(filePath, testStep + " - " + stepStatus, finalize);
		}
		else
		{
			writeToFile(filePath, testStep + " - " + stepStatus + "\r\n", finalize);
		}
	}
	
	public static String removeWhiteSpaces(String text)
	{
		text = text.replaceAll("\\s", "");
		text = text.replaceAll("\0", "");
		return text;
	}
	
	public static void switchHandle()
	{
		if (!gVars.driver.getWindowHandle().contains(gVars.MainBrowserHandle))
		{
			gVars.driver.switchTo().window(gVars.MainBrowserHandle);
		}
	}
	
	public static void writeToFile(String path, String text, Boolean finalize)
	{
		//Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/!EclipseProjects/output.txt")));
		if (gVars.writer == null)
		{
			try {
				gVars.writer = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				gVars.writer.append(text);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (finalize)
			{
				try {
					gVars.writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				gVars.writer = null;
			}
		}
	}
}
