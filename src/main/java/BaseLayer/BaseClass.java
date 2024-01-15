package BaseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass()
	{
		File f= new File(System.getProperty("user.dir")+"\\src\\main\\java\\ConfigLayer\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			
			 prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public static void initialization()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("URL"));
	}
	
	
	
	
	
}
