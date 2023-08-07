package Testing;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Goodreads {


	public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.goodreads.com");
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        WebElement signInLink1 = driver.findElement(By.linkText("Sign in with email"));
        signInLink1.click();
        String Email = "jagades2000@gmail.com";
        String password = "asd123";
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(Email);
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        String bookTitle = "The Richest Man in Babylon";


         driver.findElement(By.xpath("//input[@type='text']")).sendKeys(bookTitle);
         driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

 
        WebElement wantToReadButton = wait
                        .until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[contains(@class,'wtrToRead')]")));
        wantToReadButton.click();
        WebElement myBooksLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Books")));
        myBooksLink.click();
        driver.findElement(By.xpath("//*[starts-with(@id,'review_')]//a[contains(@class, 'deleteLink')]")).click();
        Thread.sleep(3000);
        
        Alert confirmationDialog = wait.until(ExpectedConditions.alertIsPresent());
        String dialogText = confirmationDialog.getText();
        System.out.println(dialogText);
        confirmationDialog.accept();
            
        driver.findElement(By.xpath("//a[contains(@href, 'jagdeesh')]")).click();

        driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();

        driver.quit();

}

}
