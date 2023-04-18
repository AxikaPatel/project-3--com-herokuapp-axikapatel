package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest
{
    public static WebDriver driver;

    public void openBrowser(String baseURL)
    {
        driver = new ChromeDriver();

        //launch URL
        driver.get(baseURL);

        //maximize window
        driver.manage().window().maximize();

        //implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser()
    {
        driver.quit();
    }
}
