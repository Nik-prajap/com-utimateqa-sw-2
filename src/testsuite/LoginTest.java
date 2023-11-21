package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowserForSetUp(baseUrl);
    }

    @Test
    public void userShouldNavigateTOLoginPageSuccessfully() throws InterruptedException {

        driver.findElement(By.partialLinkText("Sign ")).click();
        Thread.sleep(2000);

        // Verify the Text 'Welcome Back!'
        String expectedText = "Welcome Back!";
        WebElement actualText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome')]"));
        String actualTest = actualText.getText();
        Assert.assertEquals(expectedText,actualTest);


    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {

        driver.findElement(By.partialLinkText("Sign ")).click();
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("user[password]")).sendKeys("11Prime22");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify the error message 'Invalid email or password.'
        String expectedText = "Invalid email or password.";
        WebElement actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualTest = actualText.getText();
        Assert.assertEquals(expectedText,actualTest);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
