package util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Driverconnection {
	
	public static WebDriver connet(String url)
	{

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Documents\\selenuim\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver =new ChromeDriver();
    driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//Thread.sleep(2000);
	return driver;
	
	}
//	public static void getScreenShot(WebDriver driver,String name)
//	{
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source =  ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File("C:\\Users\\ADMIN\\Desktop\\123\\"+name+".png");
//		try {
//			Files.copy(source, dest);
//			System.out.println("Screenshot taken");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	public static void getScreenShot(WebDriver driver, String name) {
		// TODO Auto-generated method stub
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ADMIN\\Desktop\\123\\"+name+".png");
		try {
			Files.copy(source, dest);
			System.out.println("Screenshot taken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


