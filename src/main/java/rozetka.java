import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class rozetka {
    public static void main (String[] args) {
        System.setProperty("webdriver.gecko.driver", "/home/svail/IdeaProjects/TestGroup/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
        WebElement tv = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']//a[text()='Смартфоны, ТВ и электроника']"));
        tv.click();



    }
}
