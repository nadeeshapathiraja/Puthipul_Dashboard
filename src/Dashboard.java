import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nadeesha\\Downloads\\Software\\Sel\\chromedriver_win32\\chromedriver.exe");
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
		Thread.sleep(5000);

		// Clicking on the login button to login to the application
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/form/div[3]/button/span[1]"))
				.click();

//		// give for time out because I can't expect current time
//		WebDriverWait wait = new WebDriverWait(driver, 1000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='MuiTypography-root MuiTypography-caption']")));
		Thread.sleep(20000);

		// Confirm You are in correct Dashboard
		WebElement ConfirmDashboard = driver.findElement(By.xpath("//a[text()='Puthipul Admin']"));
		String ConfirmUser = ConfirmDashboard.getText();
		if (ConfirmUser.equals("Puthipul Admin")) {
			System.out.println("You Are In Correct Dashboard");
		} else {
			System.out.println("You Are In InCorrect Dashboard");
		}

//		// Click Bell icon
//		driver.findElement(By.xpath("//button[2]//span[1]//*[local-name()='svg']")).click();
//		Thread.sleep(15000);	
//		//Confirm Open Notification Panel
//		Boolean ConfirmNotifictionPenal = driver.findElement(By.xpath("//h5[text()='Notifications']	")).isDisplayed();	
//		System.out.println(ConfirmNotifictionPenal);
//		String NotificationPenal = ConfirmNotifictionPenal.getText();
//		if (ConfirmUser.equals("Notifications")) {
//			System.out.println("You Are Click Bell Icon");
//		} else {
//			System.out.println("You Are not Click Bell Icon");
//		}

//		//Click Search Icon
//		driver.findElement(By.xpath("//body/div[@id='root']/div[@class='jss27']/header[@class='MuiPaper-root MuiAppBar-root MuiAppBar-positionFixed MuiAppBar-colorPrimary jss31 mui-fixed MuiPaper-elevation4']/div[@class='MuiToolbar-root MuiToolbar-regular jss32 MuiToolbar-gutters']/button[1]")).click();
//		Thread.sleep(5000);

		// Click UserManagement
		driver.findElement(By.xpath("//span[contains(text(),'User Management')]")).click();
		Thread.sleep(5000);
		// if press List active user
		driver.findElement(By.xpath("//span[contains(text(),'List Active Users')]")).click();
		Thread.sleep(15000);
				
//Active UserScreen
		// get title in Active Users screen
		String titleActiveU = driver.getTitle();
		Thread.sleep(5000);
		if (titleActiveU.equals("Customer List")) {
			System.out.println("You Are In Active UserScreen");
		} else {
			System.out.println("You Are not In Active UserScreen");
		}
		Thread.sleep(15000);

	
		// Close Driver
		Thread.sleep(10000);
		// Close the Browser
		driver.close();

	}

}
