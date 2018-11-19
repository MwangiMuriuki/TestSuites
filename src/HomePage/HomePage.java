package HomePage;

import java.util.List;

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

public class HomePage {
	
	WebDriver driver = new FirefoxDriver();
	WebElement openAccount;
    WebElement getLoan;
    WebElement getMortgage;
    WebElement cardCenter;
    WebElement openAccountList;
    WebElement buyRate;
    WebElement sellRate;
	
	@BeforeClass
	public void init() {
		
		driver.get("https://www.bk.rw");
		
	}
	
	@Test
	public void hover() throws InterruptedException{
		
		 openAccount = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/h3"));
	     getLoan = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/h3"));
	     getMortgage = driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/div/h3"));
	     cardCenter = driver.findElement(By.xpath("/html/body/div[5]/div/div[4]/div/h3"));
		
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,480)", openAccount);
		 
		    Actions mouseActions = new Actions(driver);

	        Action mouseHoverOpenAccount = mouseActions.moveToElement(openAccount).build();
	        mouseHoverOpenAccount.perform();
	        Thread.sleep(3000);
	        
	        Action mouseHoverGetLoan = mouseActions.moveToElement(getLoan).build();
	        mouseHoverGetLoan.perform();     
	        Thread.sleep(3000);   
	        
	        Action mouseHoverGetMortgage = mouseActions.moveToElement(getMortgage).build();
	        mouseHoverGetMortgage.perform();
	        Thread.sleep(3000);
	        
	        Action mouseHoverCardCenter = mouseActions.moveToElement(cardCenter).build();
	        mouseHoverCardCenter.perform();
	        Thread.sleep(3000);
		
	}
	
	@Test
	public void listLinks() throws InterruptedException {
		
        openAccountList = driver.findElement(By.cssSelector("body > div.container.personal-home-shtcuts > div > div:nth-child(1) > div > ul"));
        List<WebElement> links = openAccountList.findElements(By.tagName("li"));
        System.out.println("The links under the Open Account section are:");
		System.out.println(" ");
        for (int i = 0; i < links.size(); i++)
            {
            
        		System.out.println("* " + links.get(i).getText());
        		
            }
        
        Thread.sleep(3000);

	}
	
	@Test
	public void exchangeRate() {
		
		 	buyRate = driver.findElement(By.xpath("/html/body/footer/div[1]/div[4]/div/table/tbody/tr[2]/td[2]"));
		 	sellRate = driver.findElement(By.xpath("/html/body/footer/div[1]/div[4]/div/table/tbody/tr[2]/td[3]"));
		
	     	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sellRate);
	     
	     	String s = sellRate.getText();
	      	String b = buyRate.getText();
	           
	        double sell = Double.parseDouble(s);
	        double buy = Double.parseDouble(b);
	        
	        int SR, BR;
	        
	         SR = (int) sell;
	         BR = (int) buy;
	         
	         if(SR!=0 && SR>BR && SR>800){
	             int diff = SR - BR;
	             int diff2 = SR - 800;
	        
	         System.out.println(" ");
	         System.out.println("The selling price is greater than the buying price by " + diff);
	 		 System.out.println(" ");	
	         System.out.println("The selling price is greater than 800 by " + diff2);
	         
	         }else{
	             
	         System.out.println("The selling price is less than the buying price and is less than 800");
	    
	         }

	}
	
	@AfterClass
	public void close() {
		
		driver.close();
	}
	

}
