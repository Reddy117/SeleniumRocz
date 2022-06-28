import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		//alert1();
		alert2();
	}
	
	public static void alert1() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
		Alert a=driver.switchTo().alert();
		Thread.sleep(3000);
		a.accept();
	}
	
	public static void alert2() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		Alert a=driver.switchTo().alert();
		a.dismiss();
	}
}
