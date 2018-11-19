package OnlineBanking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OnlineBanking {
	
	WebDriver driver = new FirefoxDriver();
	Actions mouseActions = new Actions(driver);

	@BeforeClass
	public void init() throws InterruptedException {
		
		driver.get("https://www.bk.rw/ways-of-banking/online-banking");
		Thread.sleep(3000);
	}
	
	@Test
	public void accordions() throws InterruptedException {
		
		 
	    WebElement accordionRegister = driver.findElement(By.xpath("//*[@id=\"bs-collapse\"]/div[1]/div[1]/h4/a"));
		WebElement accordionBenefits = driver.findElement(By.xpath("//*[@id=\"bs-collapse\"]/div[2]/div[1]/h4/a"));
	    WebElement accordionServices = driver.findElement(By.xpath("//*[@id=\"bs-collapse\"]/div[3]/div[1]/h4/a"));
		
	    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)", accordionRegister);
	    Thread.sleep(2000);
	    
	  //Open and close <How to Register>
	    Action openAccordionRegister = mouseActions.moveToElement(accordionRegister).click().build();
	    openAccordionRegister.perform();
	    Thread.sleep(3000);
	    
	    Action closeAccordionRegister = mouseActions.moveToElement(accordionRegister).click().build();
	    closeAccordionRegister.perform();
	    Thread.sleep(3000);
	    
	    //Open and close <Benefits>
	    Action openAccordionBenefits = mouseActions.moveToElement(accordionBenefits).click().build();
	    openAccordionBenefits.perform();
	    Thread.sleep(3000);
	    
	    Action closeAccordionBenefits = mouseActions.moveToElement(accordionBenefits).click().build();
	    closeAccordionBenefits.perform();
	    Thread.sleep(2000);
	    
	    //Open and Close <Services Available>
	    Action openAccordionServices = mouseActions.moveToElement(accordionServices).click().build();
	    openAccordionServices.perform();
	    Thread.sleep(3000);
	    
	    Action closeAccordionServices = mouseActions.moveToElement(accordionServices).click().build();
	    closeAccordionServices.perform();
	    Thread.sleep(3000);
		
	}
	
	@Test
	public void apply() {
		WebElement applySection = driver.findElement(By.xpath("/html/body/div[6]"));
	    WebElement applyButton = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/div/p[2]"));

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", applySection);

	    Action clickApplyButton = mouseActions.moveToElement(applyButton).click().build();
	    clickApplyButton.perform();
    
	    System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void close() {
		
		driver.close();
	}

}
