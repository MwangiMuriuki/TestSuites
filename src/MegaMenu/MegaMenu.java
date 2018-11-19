package MegaMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MegaMenu {
	
	WebDriver driver = new FirefoxDriver();
    Actions mouseActions = new Actions(driver);

	
	@BeforeClass
	public void init() {
		
		driver.get("https://www.bk.rw");
		
	}
	
	@Test
	public void hoverOnMenu() throws InterruptedException {
		WebElement elementCurrentAccount = driver.findElement(By.xpath("/html/body/section[2]/nav/div/div/div[2]/ul[1]/li[2]/a"));
		Action hoverOnElement = mouseActions.moveToElement(elementCurrentAccount).build();
        hoverOnElement.perform();
        Thread.sleep(3000);
        
	}
	
	@Test
	public void navigateToBanking()  throws InterruptedException{
		
	    WebElement onlineBankingLink = driver.findElement(By.xpath("/html/body/section[2]/nav/div/div/div[2]/ul[1]/li[2]/ul/li[2]/ul/li[2]/a"));
		Action clickElement = mouseActions.moveToElement(onlineBankingLink).click().build();
        clickElement.perform();
        Thread.sleep(3000);
       
        System.out.println(driver.getTitle());
        Thread.sleep(3000);	
	}
	
	@AfterClass
	public void close() {
		
		driver.close();
	}

}
