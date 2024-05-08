package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {
    
    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testLoginSuccess() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavish Computers\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();        
        System.out.println("Driver info: " + driver);
        
        // Full path where login.html is located.
        // You can click on html file and copy the path shown in your browser.
        driver.navigate().to("file:\\E:\\Deakin\\SIT707\\8.1P-resources\\pages\\login.html");
        sleep(5);
        
        // Find username element
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("ameet");
        
        // Find password element
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("ameet_pass");
        
        // Find date of birth element
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("12-23-1997");
        
        // Find Submit button and click it
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        
        sleep(5);
        
        // On successful login, the title of the page changes to 'success', otherwise, 'fail'.
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        
        Assert.assertEquals(title, "success");
        
        driver.close();
    }
    
    @Test
    public void testLoginFailureInvalidUsername() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavish Computers\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();        
        System.out.println("Driver info: " + driver);
        
        // Full path where login.html is located.
        // You can click on html file and copy the path shown in your browser.
        driver.navigate().to("file:\\E:\\Deakin\\SIT707\\8.1P-resources\\pages\\login.html");
        sleep(5);
        
        // Find username element
        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("invalid_user");
        
        // Find password element
        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("ameet_pass");
        
        // Find date of birth element
        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("12-23-1997");
        
        // Find Submit button and click it
        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        
        sleep(5);
        
        // On successful login, the title of the page changes to 'success', otherwise, 'fail'.
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        
        Assert.assertNotEquals(title, "success");
        
        driver.close();
    }
    
    @Test
    public void testLoginFailureEmptyFields() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavish Computers\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();        
        System.out.println("Driver info: " + driver);
        
        // Full path where login.html is located.
        // You can click on html file and copy the path shown in your browser.
        driver.navigate().to("file:\\E:\\Deakin\\SIT707\\8.1P-resources\\pages\\login.html");
        sleep(5);
        
        // Find Submit button and click it without entering any fields
        WebElement ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();
        
        sleep(5);
        
        // On successful login, the title of the page changes to 'success', otherwise, 'fail'.
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        
        Assert.assertNotEquals(title, "success");
        
        driver.close();
    }
}
