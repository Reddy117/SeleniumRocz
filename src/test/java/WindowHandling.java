import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.deal4loans.com/car-loans.php");
		//windowHandle1();
		//windowHandle2();
		//driver.close();
		//driver.quit();
		windowHandle2();
		
	}
	
	public static void windowHandle1() {
		String mainWindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//a[contains(text(),'privacy')]")).click();
		Set<String> windows=driver.getWindowHandles();
		
		for(String childWindow:windows) {
			driver.switchTo().window(childWindow);
		}
		driver.findElement(By.xpath("//a[@href='http://www.deal4loans.com']")).click();
		driver.switchTo().window(mainWindow);
		driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div[4]/div/div[2]/div/form/div[3]/div[1]/div[1]/label/input")).click();
	}
	
	public static void windowHandle2() {
		driver.findElement(By.xpath("//a[contains(text(),'privacy')]")).click();
		Set<String> windows=driver.getWindowHandles();
		
		for(String childWindow:windows) {
			driver.switchTo().window(childWindow);
		}
		driver.findElement(By.xpath("/html/body/section/div[2]/div/div/p[28]/a/b")).click();
		windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		
		String mainWindow=it.next();
		String childWindow=it.next();
		String childWindow1=it.next();
		
		driver.switchTo().window(childWindow1);
		driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("/html/body/div[1]/div/nav/div[2]/ul/li[2]/a")).click();
		driver.switchTo().window(mainWindow);
		driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div[4]/div/div[2]/div/form/div[3]/div[1]/div[1]/label/input")).click();
		
		
	}
}
