package createQuote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class TC_01_CreateQuote {
	
	static Select dropdown;
	static String ExceptionRecorded;
	static String []ErrorMessage;
	static String FinalErrorMessage;
	static String ErrorMessageType;
	
	public static void main (String[] args) throws InterruptedException
	{
		try {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\SeleniumWebDrivers\\IEDriverServer.exe");

			WebDriver driver = new InternetExplorerDriver();
			driver.navigate().to("https://www.aaalife.com/term-life-insurance-quote-input");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			driver.findElement(By.id("zip")).sendKeys("48335");
			
			dropdown = new Select(driver.findElement(By.id("gender")));
			dropdown.selectByVisibleText("Male");
			
			dropdown= new Select(driver.findElement(By.id("feet")));
			dropdown.selectByVisibleText("5");
			
			dropdown = new Select(driver.findElement(By.id("inches")));
			dropdown.selectByVisibleText("10");
			
			driver.findElement(By.id("weight")).sendKeys("175");
			
			dropdown = new Select(driver.findElement(By.id("month")));
			dropdown.selectByVisibleText("April");
			
			dropdown = new Select(driver.findElement(By.id("day")));
			dropdown.selectByVisibleText("11");
			
			dropdown = new Select(driver.findElement(By.id("year")));
			dropdown.selectByVisibleText("1985");
				
			//driver.findElement(By.xpath(".//*[@id='quoteForm']/div/div[3]/div[1]/div[3]/fieldset/div/label[2]/span")).click();
			driver.findElement(By.xpath("//*[contains(@for, 'nicotineUseYes')]/span")).click();  
			
			//driver.findElement(By.xpath(".//*[@id='quoteForm']/div/div[1]/div[3]/fieldset/div/label[1]/span")).click();
			driver.findElement(By.xpath("//*[contains(@for, 'isMemberYes')]/span")).click();
			
			driver.findElement(By.id("contact_email")).sendKeys("mahenbhasker2006@gmail.com");
			
			dropdown = new Select(driver.findElement(By.id("coverageAmount")));
			dropdown.selectByVisibleText("$550,000");
			
			
			dropdown = new Select(driver.findElement(By.id("termLength")));
			dropdown.selectByVisibleText("10 Years");
		
			dropdown = new Select(driver.findElement(By.xpath("//*[contains(@id, 'rateYourHealth')]")));
			Thread.sleep(2000);		
			dropdown.selectByIndex(1);
		    dropdown.selectByVisibleText("Fair");
		    
		    Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(), 'See Your Quote')]")).click();
			Thread.sleep(10000);
			
			String actualurl = driver.getCurrentUrl();
			String expectedurl= "https://www.aaalife.com/quote-results";
			
			if (expectedurl.equalsIgnoreCase(actualurl))
			   {
			    System.out.println("After Quote URL Verification Is Successful" );
		       }
		    else
		       {
		        System.out.println("After Quote URLVerification Is Unsuccessful" );
		       }
			
			driver.close();
			driver.quit();
			
		} catch (Exception|Error e) {
		    ExceptionRecorded = e.getMessage();	
			ErrorMessageType = e.toString();
			if (ExceptionRecorded.contains("Command"))
			{
			ErrorMessage = ExceptionRecorded.split("Command");
			FinalErrorMessage = ErrorMessage[0];
			}
			else
			{
				FinalErrorMessage = ExceptionRecorded;
			}
			 System.out.println("Following Error Occurred In Test Case :" +FinalErrorMessage);

		}
		
	}
	

} 
	

