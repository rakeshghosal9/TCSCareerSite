package tcscareersite;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JobSearch {
	
	WebDriver driver;
	Actions act;
	Set<String> allWindow;
	
	@BeforeTest
  public void openJobSearchSite() {
		
		System.out.println("Setting up Chrome Driver");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rakes\\git\\TCSCareerSite\\chromedriver.exe");
		driver = new ChromeDriver();
		act = new Actions(driver);
		driver.get("https://careers.tcs.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
	
	@Test(priority=1)
	public void selectIndiaFromTheDropdown()
	{
		System.out.println("Selecting dropdown as India");
		driver.findElement(By.xpath(".//*[@class='truncate ng-binding']")).click();
		driver.findElement(By.xpath(".//*[@id='img1']")).click();
		driver.findElement(By.xpath(".//*[@id='AS_tabContent']/div[2]/div[4]/a/span")).click();
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='tileStripHtml0']"))).build().perform();
		driver.findElement(By.xpath(".//*[@id='tileStripHtml0']/div/button")).click();
		
	}
	
	@Test(priority=2)
	public void careerPortalLoginSwitch()
	{
		System.out.println("Inside Career Portal Login Switch");
		allWindow = driver.getWindowHandles();
		System.out.println("Total Size="+allWindow.size());
		Iterator <String> it = allWindow.iterator();
		
			String mainWindow = it.next();
			String popUpWindow = it.next();
			System.out.println("Main Window = "+mainWindow);
			System.out.println("Pop Up Window = "+popUpWindow);
			driver.switchTo().window(popUpWindow);
	}
	
	@Test(priority=3)
	public void careerPortalLogin()
	{
		driver.findElement(By.name("form2:txtUserName")).sendKeys("rakeshghosal.nsec@gmail.com");
		driver.findElement(By.name("form2:txtPassword")).sendKeys("R@kesh2016");
		driver.findElement(By.id("form2:_idJsp37")).click();
	}
	}
	

