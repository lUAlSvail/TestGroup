import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
    }
    private By  cookies = By.xpath("//div[@class= \"block-cookies\"]//div[@class=\"block-cookies__close\"]");
    private By searchButtonTyres = By.cssSelector("a#tyres_search");
    private By searchButtonCar = By.xpath("//a[@class=\"submit\"]//span[@class=\"submit__span\"]");
    private By searchButtonKBA = By.xpath("//div[@class=\"mainblock-search__rows\"]//span[text()=\"Suchen\"]");
    private By inputKBA1 = By.cssSelector("input#kba1");
    private By inputKBA2 = By.cssSelector("input#kba2");
    private By carMaker = By.cssSelector("select#form_maker_id");
    private By carModel = By.cssSelector("select#form_model_id");
    private By carMotor = By.cssSelector("select#form_car_id");
    private By noneSeasons = By.xpath("//label[@for=\"none-weather-radio\"]");
    private By winterSeason = By.xpath("//label[@for=\"winter-radio\"]");
    private By summerSeason = By.xpath("//label[@for=\"summer-radio\"]");
    private By allSeasons = By.xpath("//label[@for=\"all-weather-radio\"]");
    private By tyreWidth = By.cssSelector("select#form_Width");
    private By tyreHeight = By.cssSelector("select#form_CrossSections");
    private By tyreDiameter = By.cssSelector("select#form_Size");
    private String tyreValueSize = "//option[@value=\"%s\"]";


    public SizeTyresListing SearchTyreSize(){
        driver.findElement(searchButtonTyres).click();
        return new SizeTyresListing(driver);
    }
    public CarTyresListing SearchCarTryres(){
        driver.findElement(searchButtonCar).click();
        return new CarTyresListing (driver);
    }
    public CarTyresListing SearchKbaTyres(){
        driver.findElement(searchButtonKBA).click();
        return new CarTyresListing(driver);
    }
    public MainPage typeKBA(String KBA){
        driver.findElement(inputKBA1).sendKeys(KBA);
        return this;
    }
    public MainPage setWidth(String value){
        driver.findElement(tyreWidth).click();
        driver.findElement(By.xpath(String.format(tyreValueSize,value))).click();
        return this;
    }
    public MainPage setHeight(String value){
        driver.findElement(tyreHeight).click();
        driver.findElement(By.xpath(String.format(tyreValueSize,value))).click();
        return this;
    }
    public MainPage setDiameter(String value){
        driver.findElement(tyreDiameter).click();
        driver.findElement(By.xpath(String.format(tyreValueSize,value))).click();
        return this;
    }

}

