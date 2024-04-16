package Com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class Base {
	
	public static WebDriver driver = null;
	public static WebDriver connect()
	
	{
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\project\\src\\test\\java\\Com\\Base.java");
			Properties pro = new Properties();
			pro.load(fis);

			String browser = pro.getProperty("browser");
			String url = pro.getProperty("url");

			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Documents\\selenuim\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equals("ff"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADMIN\\Documents\\selenuim\\geckodriver-v0.34.0-win32\\geckodriver.exe");
				WebDriver driver =new FirefoxDriver();
			}
			else if(browser.equals("edge"))
				
			{   
				System.setProperty("webdrvier.edge.driver","C:\\Users\\ADMIN\\Documents\\selenuim\\msedgedriver.exe");
         		WebDriver driver =new EdgeDriver();
			}

			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;
	}


	public void getScreenShot(String name)
	{
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

