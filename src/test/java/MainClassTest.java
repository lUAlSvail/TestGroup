import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainClassTest {
    private WebDriver driver;
    private MainPage mainPage;
    private SizeTyresListing sizeTyresListing;
    private ProductTyrePage productTyrePage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "/home/svail/IdeaProjects/TestGroup/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://tyres.buycarparts.co.uk/");
        mainPage = new MainPage(driver);
        mainPage.CloseCookies();
        mainPage.setAllDimension("215","40","17");
        sizeTyresListing = new SizeTyresListing(driver);
        sizeTyresListing.checkTitle();

    }
    @Test
    public void searchTyres() {


        Assert.assertTrue(sizeTyresListing.checkSelector("215","40","17"));
        Assert.assertTrue(sizeTyresListing.typeDefaultQuantity("Car",4));
        Assert.assertTrue(sizeTyresListing.minimumQuantityToBuy(2));
        sizeTyresListing.findPrice();



    }
    @Test
    public void checkProductPage(){
        sizeTyresListing.openProductTyre();
        productTyrePage = new ProductTyrePage(driver);
        productTyrePage.checkTitle();
        Assert.assertTrue(productTyrePage.typeDefaultQuantity(4));
        Assert.assertTrue(productTyrePage.minimumQuantityToBuy(2));
    }
    @After
    public void exit(){
        driver.quit();
    }


}
