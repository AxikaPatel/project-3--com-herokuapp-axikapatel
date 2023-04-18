package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    String baseURL = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp()
    {
      openBrowser(baseURL);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials()
    {
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
       driver.findElement(By.xpath("//button[@class='radius']")).click();



        String expectedMessage = "Secure Area";

        //Verify the text “Secure Area”
        WebElement actualTextElement = driver.findElement(By.xpath("//i[@class='icon-lock']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("User Login in secure area", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage()
    {
        //Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");

        //Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();

        //Verify the error message "Your username is invaild"
        String expectedMessage ="Your username is invalid!\n" +
                "×";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage()
    {
        //Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        // Enter “SuperSecretPassword” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        String expectedMessage ="Your password is invalid!\n"+
                   "×";

        //Verify the error message
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage,expectedMessage);


    }


    @After
    public void tearDown()
    {
          closeBrowser();
    }

}
