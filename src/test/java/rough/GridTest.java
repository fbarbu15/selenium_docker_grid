package rough;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTest {

public WebDriver driver=null;	
	
	@Parameters("browser")
	@Test()
	public void googleTest(String b) throws MalformedURLException, InterruptedException {
		System.out.println("Google " + b);
		DesiredCapabilities cap = null;
		if(b.equals("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
		} else if(b.equals("chrome")) {
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
		}
		
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), cap);
		
		driver.get("https://www.google.ro/");
		driver.findElement(By.name("q")).sendKeys("Hello "+b);
		Thread.sleep(5000);
		
		driver.quit();
		
		
	}
}
