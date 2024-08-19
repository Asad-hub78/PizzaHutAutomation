package stepDefs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
public static WebDriver driver;
@Before
public void openBrowser() {
	driver = new ChromeDriver();
}
@After
public void closeBrowser() {
	driver.close();
}
public void windowMax() {
	driver.manage().window().maximize();
}
public void waitTime(int wait) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}

}
