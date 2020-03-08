import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.ScatteringByteChannel;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main (String[] args){
        System.setProperty("webdriver.gecko.driver", "/home/svail/IdeaProjects/TestGroup/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(900, 800));
//        driver.get("https://ru.wikipedia.org/wiki/Selenium");
//        WebElement link = driver.findElement(By.linkText("Войти"));
//        WebElement link2 = driver.findElement(By.partialLinkText("Ссылки"));
//        WebElement search = driver.findElement(By.name("search"));
//        WebElement searchButton = driver.findElement(By.className("searchButton"));
//        driver.navigate().to("https://www.selenium.dev");
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(link);
        driver.get("https://www.autodoc.de/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = (new WebDriverWait(driver , 30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"popup-after-order__close\"]")));
        WebElement close = driver.findElement(By.xpath("//span[@class=\"popup-after-order__close\"]"));
        close.click();
        WebElement login = driver.findElement(By.xpath("//a[@class=\"js-show-login-popup header-i header-i--user\"]"));
        login.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id=\"login_top_email\"]")).sendKeys("befreebeawesome@gmail.com");
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("test1234");
        driver.findElement(By.xpath("//a[@class=\"enter submit\"]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"search\"]")));
        driver.findElement(By.xpath("//input[@id=\"search\"]")).sendKeys("РОМА ПОШЛИ КУШАТЬ!!! УЖЕ ЧАС!!!");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("Suchen")).click();






    }
}
