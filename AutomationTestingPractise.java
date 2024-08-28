package Practise;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class AutomationTestingPractise {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.id("name")).sendKeys("Madhav Jain");
		driver.findElement(By.id("email")).sendKeys("test@yopmail.com");
		driver.findElement(By.id("phone")).sendKeys("987446652");

		driver.findElement(By.id("textarea")).sendKeys("#25, CHD");

		driver.findElement(By.xpath("//input[@id='male']")).click();

		List<WebElement> days = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for (int i = 1; i < 6; i++) {
			days.get(i).click();
		}
		// // for (WebElement i:checkbox ) { // For selecting all days
		// // i.click();
		// // }

		WebElement country = driver.findElement(By.id("country"));
		country.click();
		Select select_country = new Select(country);
		select_country.selectByVisibleText("India");

		WebElement colors = driver.findElement(By.id("colors"));
		Select color = new Select(colors);
		color.selectByVisibleText("Blue");

		driver.findElement(By.id("datepicker")).sendKeys("25/07/2001");

		driver.findElement(By.partialLinkText("open")).click();
		Thread.sleep(3000);
		driver.navigate().back();

		driver.findElement(By.partialLinkText("HRM")).click();
		Thread.sleep(3000);
		driver.navigate().back();

		driver.findElement(By.partialLinkText("Ho")).click();

		driver.findElement(By.partialLinkText("Atom")).click();
		Set<String> ids = driver.getWindowHandles();
		List<String> windowIDs = new ArrayList(ids);
		String parentID = windowIDs.get(0);
		String childID = windowIDs.get(1);
		driver.switchTo().window(childID);
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parentID);

		WebElement table = driver.findElement(By.className("widget-content"));
		System.out.println(table);

		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Virat Kohli");
		driver.findElement(By.className("wikipedia-search-button")).click();
		driver.findElement(By.linkText("Virat Kohli")).click();
		Thread.sleep(3000);
		Set<String> ids2 = driver.getWindowHandles();
		List<String> windowIDs2 = new ArrayList(ids2);
		String parentID2 = windowIDs2.get(0);
		String childID2 = windowIDs2.get(1);
		driver.switchTo().window(childID2);
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parentID2);
		Thread.sleep(3000);

		WebElement NewBrowserButton = driver.findElement(By.xpath("//button[normalize-space()='New Browser Window']"));
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].click();", NewBrowserButton);
		Set<String> ids3 = driver.getWindowHandles();
		List<String> windowIDs3 = new ArrayList(ids3);
		String parentID3 = windowIDs3.get(0);
		String childID3 = windowIDs3.get(1);
		driver.switchTo().window(childID3);
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parentID3);
		Thread.sleep(3000);
		
		WebElement AlertButton = driver.findElement(By.xpath("//button[normalize-space()='Alert']"));
		js.executeScript("arguments[0].click();", AlertButton);
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);

		WebElement ConfirmButton = driver.findElement(By.xpath("//div[@class='widget-content']/button[2]"));
		js.executeScript("arguments[0].click();", ConfirmButton);
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);

		WebElement PromptButton = driver.findElement(By.xpath("//div[@class='widget-content']/button[3]"));
		js.executeScript("arguments[0].click();", PromptButton);
		Thread.sleep(3000);
		alert.sendKeys("Madhav");
		alert.accept();
		Thread.sleep(3000);

		WebElement field1 = driver.findElement(By.id("field1"));
		field1.clear();
		field1.sendKeys("Hello Selenium!");
		Actions act = new Actions(driver);
		WebElement CopyButton = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		act.doubleClick(CopyButton).perform();
		WebElement field2 = driver.findElement(By.id("field2"));
		System.out.println(field2.getAttribute("value"));
		Thread.sleep(3000);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		act.dragAndDrop(source, destination).build().perform();
		Thread.sleep(3000);

		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		System.out.println("Location of element before slider: " + slider.getLocation());
		act.dragAndDropBy(slider, 100, 0).perform();
		System.out.println("Location of element after slider: " + slider.getLocation());
		Thread.sleep(3000);

		driver.switchTo().frame(0);
		driver.findElement(By.name("RESULT_TextField-0")).sendKeys("Madhav Jain");
		driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-1_0']")).click();
		driver.findElement(By.className("icon_calendar")).click();
		WebElement yr = driver.findElement(By.className("ui-datepicker-year"));
		yr.click();
		Select select_yr = new Select(yr);
		select_yr.selectByVisibleText("2001");
		driver.findElement(By.linkText("Prev")).click();
		driver.findElement(By.linkText("25")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Report abuse']")).click();

		Thread.sleep(3000);

		//a[@rel = 'nofollow'] 
		Set<String> ids4 = driver.getWindowHandles();
		Thread.sleep(5000);
		List<String> windowIDs4 = new ArrayList<>(ids4); 
		String parentID4 = windowIDs4.get(0);
		String chilID4 = windowIDs4.get(1);
		String title=driver.switchTo().window(chilID4).getTitle();
		System.out.println("The title of report abuse is: " + title);
		driver.close();
		driver.switchTo().window(parentID4);
		
		driver.switchTo().frame(0);
		driver.findElement(By.partialLinkText("by")).click();
		Thread.sleep(3000);
		driver.navigate().back();

		driver.switchTo().frame(0);
		WebElement job = driver.findElement(By.className("drop_down"));
		job.click();
		Select select_job = new Select(job);
		select_job.selectByVisibleText("QA Engineer");

		driver.findElement(By.xpath("//input[@id='FSsubmit']")).click();
	}

}