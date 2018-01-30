package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Login_page {
	static WebDriver driver=null;
	
	 @Test (priority=0,enabled=true)
	 public static void lunch_browser() {
		try {
		System.setProperty("webdriver.chrome.driver","E://Shiv Automation Script//browser_driver//chrome//chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.navigate().to("http://webdev.etelmar.net/IDEV_SurveyTimeH01/Login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Test (priority=1,enabled=true)
	public static void login() {
		try {
		driver.findElement(By.xpath(".//*[@id='login_Div']/form/input[1]")).clear();
		driver.findElement(By.xpath(".//*[@id='login_Div']/form/input[1]")).sendKeys("60_07389");
		driver.findElement(By.xpath(".//*[@id='login_Div']/form/input[2]")).clear();
		driver.findElement(By.xpath(".//*[@id='login_Div']/form/input[2]")).sendKeys("OWE6HOLE");
		driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
		}catch(Exception ex) {
		System.out.println(ex.getMessage());
		}
	}
	
	@Test (priority=2,enabled=true)
	public static void select_new_survey() {
		try {
		Thread.sleep(30000);
		driver.findElement(By.id("rdbNewSurvey")).click();
		driver.findElement(By.xpath(".//*[@id='divStartupWindow']/div/div[2]/input")).click();
		}catch(Exception ex) {
		 System.out.println(ex.getMessage());
		}
	}
		
	
	@Test (priority=3,enabled=true)
	public static void select_survey() {
		try {
		driver.findElement(By.xpath(".//*[@id='surveySelection_Div']/div[1]/div[6]/button")).click();
       driver.findElement(By.xpath(".//*[@id='surveySelection_Div']/div[1]/div[4]/span[2]/span/span[1]")).click();
       try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       driver.findElement(By.xpath("//li[text()='MRI']")).click();
       Actions act=new Actions(driver);
       act.doubleClick(driver.findElement(By.xpath(".//*[@id='surveyGrid']/div[2]/div[1]/table/tbody/tr[7]/td[3]"))).build().perform();
       driver.findElement(By.xpath(".//*[@id='surveySelection_Div']/div[3]/div[2]/input[1]")).click();
		}catch(Exception ex) {
			 System.out.println(ex.getMessage());
		}
	}
	@Test(priority=4)
	public void goToCoding_grid(){
		try{
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='ccgLeftMenu']/div")).click();
			Thread.sleep(3000);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			}
	}
	
	@Test (priority=5,enabled=true)
	public static void expand_tree_structure_select_any_node_from_code_book() throws InterruptedException {
		try {
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[text()='Demographics']/preceding-sibling::span")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[text()='Summary List']/preceding-sibling::span")).click();
		Thread.sleep(20000);
		WebElement ele1=driver.findElement(By.xpath("//span[text()='Gender']"));
		ele1.click();
		//driver.findElement(By.id("btnRowAdd")).click();
		WebElement mainGrid=driver.findElement(By.id("grid1"));
		Actions act=new Actions(driver);
		act.clickAndHold(ele1);
		act.moveToElement(mainGrid).build().perform();
		Thread.sleep(3000);
		WebElement operatorpopup=driver.findElement(By.xpath(".//*[@id='tblCrtNewRow']/table/tbody/tr[1]/td"));
		Thread.sleep(3000);
		act.dragAndDrop(ele1, operatorpopup).build().perform();
		
/*		WebElement ele2=driver.findElement(By.xpath("//*[@id='btnAddNewRow']"));
		WebElement ele3=driver.findElement(By.xpath("//*[@id='div_row_and']"));
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		act.clickAndHold(ele1);
		Thread.sleep(10000);
		//act.dragAndDrop(ele1, ele2).build().perform();
		act.moveToElement(ele2).build().perform();
		Thread.sleep(10000);
		act.dragAndDrop(ele1, ele3).build().perform();
		Thread.sleep(10000);
		//WebElement element=driver.findElement(By.xpath("//div[@id='grid']/div[2]"));
		Thread.sleep(5000);
	//	Actions action = new Actions(driver).contextClick(element);
		Thread.sleep(5000);
		//action.build().perform();*/
		}catch(Exception ex) {
			 System.out.println(ex.getMessage());
		}
	}
	//@Test (priority=5,enabled=true)
	public static void several_delete() throws InterruptedException {
		WebElement element=driver.findElement(By.xpath("//div[@id='grid']/div/div/table/thead/tr[2]/th[4]"));
		//th[4] is dynamic need to change as per requirement
		Actions action = new Actions(driver).contextClick(element);
		Thread.sleep(5000);
		action.build().perform();
		System.out.println("righ click perfrom");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='xTabColumnContextMenu']/li[6]/span")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath(".//*[@id='DeleteSeveralWindow']/table/tbody/tr[1]/td/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	}
}
