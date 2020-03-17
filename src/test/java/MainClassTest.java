import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClassTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\svail\\IdeaProjects\\TestGroup\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://tyres.buycarparts.co.uk/");
        mainPage = new MainPage(driver);
    }
    @Test
    public void searchTyres(){
        mainPage.closeCookies();
        mainPage.setAllDimension("215","40","17");
        String name = driver.getTitle();

        Assert.assertEquals("215/40 R17 passenger car summer tyres - buy cheap online",name);

    }
    @After
    public void testDown(){
        driver.quit();
    }
}
