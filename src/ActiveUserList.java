import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiveUserList {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse Workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://admin.puthipul.com/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		// Before Check Dashbord LogIn To System
		// Add username
		WebElement email_field = driver.findElement(By.name("email"));
		email_field.sendKeys("admin");

		// Add Password
		WebElement password_field = driver.findElement(By.name("password"));
		password_field.sendKeys("Admin123");
		Thread.sleep(1000);

		// Clicking on the login button to login to the application
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/form/div[3]/button/span[1]")).click();
		Thread.sleep(20000);
		
		// Click UserManagement
		driver.findElement(By.xpath("//span[contains(text(),'User Management')]")).click();
		Thread.sleep(5000);

		// if press List active user
		driver.findElement(By.xpath("//span[contains(text(),'List Active Users')]")).click();
		Thread.sleep(15000);

		// Active UserScreen
		// get title in Active Users screen
		String titleActiveU = driver.getTitle();
		Thread.sleep(5000);
		if (titleActiveU.equals("Customer List")) {
			System.out.println("You Are In Correct Page");
		} else {
			System.out.println("You Are In InCorrect Page");
		}
		Thread.sleep(20000);

		// Confirm Phone verify is true
		WebElement baseTable = driver.findElement(By.tagName("table"));

		// To find third row of table and its 4th Column
		WebElement tableRow3 = baseTable.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[3]"));
		Thread.sleep(5000);
		WebElement cellIneed3 = tableRow3.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[3]/td[4]"));
		String valueIneed3 = cellIneed3.getText();
		
		// To find third row of table and its 4th Column
		WebElement tableRow6 = baseTable.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[6]"));
		Thread.sleep(5000);
		WebElement cellIneed6 = tableRow6.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[6]/td[4]"));
		String valueIneed6 = cellIneed6.getText();
	
		
		//Confirm User in COrrect Page     .size();
		if(valueIneed3.equals("Yes") && valueIneed6.equals("Yes")) {
			System.out.println("You are In Active User Page");
		}else if(valueIneed3.equals("No") && valueIneed3.equals("No")) {
			System.out.println("You are In Inactive User Page");
		} else {
			System.out.println("You are in Wrong Page");
		}
		
		//Press Edit button and go to the Edit user Page
		driver.findElement(By.xpath("//tr[1]//td[6]//button[1]//span[1]//*[local-name()='svg']")).click();
		Thread.sleep(15000);
		
		WebElement edit_page = driver.findElement(By.xpath("//h3[text()='Edit Customer']"));
		String textEditPage = edit_page.getText();
		
		if(textEditPage.equals("Edit Customer")) {
			System.out.println("User In Edit Customer Page");
		}else {
			System.out.println("User In Not in Edit Customer Page");
		}
		Thread.sleep(5000);

		// Close Driver
		Thread.sleep(10000);
		// Close the Browser
		driver.close();
	}

}
