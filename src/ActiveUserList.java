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
		if (titleActiveU.equals("Customer List")) {
			System.out.println("You Are In Correct Page");
		} else {
			System.out.println("You Are In InCorrect Page");
		}
		Thread.sleep(10000);

		// Confirm Phone verify is true
		WebElement baseTable = driver.findElement(By.tagName("table"));

		// To find third row of table and its 4th Column
		WebElement tableRow3 = baseTable.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[3]"));
		Thread.sleep(5000);
		WebElement cellIneed3 = tableRow3.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[3]/td[4]"));
		String valueIneed3 = cellIneed3.getText();
		
		// To find 6th row of table and its 4th Column
		WebElement tableRow6 = baseTable.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[6]"));
		Thread.sleep(5000);
		WebElement cellIneed6 = tableRow6.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[6]/td[4]"));
		String valueIneed6 = cellIneed6.getText();
		
		// To find 1st row of table and its 1st Column for get the phone number
		WebElement tableRow1 = baseTable.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]"));
		Thread.sleep(5000);
		WebElement cellIneed1 = tableRow1.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[1]"));
		String valueIneed1 = cellIneed1.getText();
		
		//Confirm User in COrrect Page     .size();
		if(valueIneed3.equals("Yes") && valueIneed6.equals("Yes")) {
			System.out.println("You are In Active User Page");
		}else if(valueIneed3.equals("No") && valueIneed3.equals("No")) {
			System.out.println("You are In Inactive User Page");
		} else {
			System.out.println("You are in Wrong Page");
		}
		Thread.sleep(5000);
		//Press Edit button and go to the Edit user Page
		driver.findElement(By.xpath("//tr[1]//td[6]//button[1]//span[1]//*[local-name()='svg']")).click();
		Thread.sleep(15000);
		
		//Validate User in Correct Edit Page
		WebElement edit_page = driver.findElement(By.xpath("//h3[text()='Edit Customer']"));
		String textEditPage = edit_page.getText();
		if(textEditPage.equals("Edit Customer")) {
			System.out.println("User In Edit Customer Page");
		}else {
			System.out.println("User In Not in Edit Customer Page");
		}
		Thread.sleep(10000);

		//----------------------------------------------
		//Get Input field Value
		WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/input"));
		String textInsideInputBox = inputBox.getAttribute("value");
		System.out.println(textInsideInputBox);
		Thread.sleep(10000);

		//Phone Number Field not empty and equal to first one
		if(!textInsideInputBox.equals("")) {
			if(textInsideInputBox.equals(valueIneed1)) {
				System.out.println("You are In Correct Edit Page");
			}else {
				System.out.println("You are In Incorrect Edit Page");
			}
		}else {
			System.out.println("Somting Wrong");
		}
		Thread.sleep(5000);
		
		//Set Values For Text Fields
		
		
//		
//		
//		WebElement email = driver.findElement(By.xpath("//input[@type='text'][@name='email']"));
//		driver.findElement(By.xpath("//input[@type='text'][@name='email']")).clear();
//		Thread.sleep(1000);
//		email.sendKeys("abc@gmail.com");
//		
//		WebElement fname = driver.findElement(By.xpath("//input[@type='text'][@name='firstName']"));
//		driver.findElement(By.xpath("//input[@type='text'][@name='firstName']")).clear();
//		Thread.sleep(1000);
//		fname.sendKeys("Sumudu");
//		
//		WebElement lname = driver.findElement(By.xpath("//input[@type='text'][@name='lastName']"));
//		driver.findElement(By.xpath("//input[@type='text'][@name='lastName']")).clear();
//		Thread.sleep(1000);
//		lname.sendKeys("Sadaruwan");
//		
		//Click Update Button
		driver.findElement(By.xpath("//span[text()='Update Customer']")).click();
		Thread.sleep(15000);
//		
//		//Check Is it Updated
//		WebElement tableRowEdit2 = baseTable.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]"));
//		Thread.sleep(5000);
//		WebElement cellIneedEdit2 = tableRowEdit2.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[2]"));
//		String valueIneedEdit2 = cellIneedEdit2.getText();
//		
//		if(valueIneedEdit2.equals("Sumudu Sadaruwan")) {
//			System.out.println("Update Successfull");
//		}else {
//			System.out.println("Update Unsuccessfull");
//		}
		
		//Delete Row 1   
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[6]/button[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		
		//After Delete Row 1
		WebElement tableRowD1 = baseTable.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]"));
		Thread.sleep(5000);
		WebElement cellIneedD1 = tableRowD1.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[1]"));
		String valueIneedD1 = cellIneedD1.getText();
		Thread.sleep(15000);
		//Compare Before and After Values
		if(!valueIneed1.equals(valueIneedD1)) {
			System.out.println("Delete Successfull");
		}else {
			System.out.println("Delete Unsuccessfull");
		}
		
		
		
		// Close Driver
		Thread.sleep(10000);
		// Close the Browser  
		driver.close();
	}

}
