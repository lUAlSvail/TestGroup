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
    private By searchButtonKBA = By.xpath("//a[@class=\"submit kba_submit\"]//span[text()=\"Search\"]");
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
    private String tyreValueSize = "//select[@id=\"%s\"]//option[@value=\"%s\"]";
    private String carValue = "//option[text()=\"%s\"]";
    private By cookie = By.xpath("//div[@class=\"block-cookies__close\"]");
    private By sizeDisplay = By.xpath("//option[@value=\"205\"][@selected=\"selected\"]");

    public MainPage IsDisplayed(){
        if (driver.findElement(sizeDisplay).isDisplayed()){
            System.out.println("displayed"); }
        else {
            System.out.println("not displayed");}
        return this;
    }
    public MainPage CloseCookies(){
        driver.findElement(cookie).click();
        return this;
    }

    public SizeTyresListing SearchTyreSize(){
        driver.findElement(searchButtonTyres).click();
        return new SizeTyresListing(driver);
    }
    public CarTyresListing SearchCarTyres(String maker, String model, String motor){
        driver.findElement(carMaker).click();
        driver.findElement(By.xpath(String.format(carValue,maker))).click();
        driver.findElement(carModel).click();
        driver.findElement(By.xpath(String.format(carValue,model))).click();
        driver.findElement(carMotor).click();
        driver.findElement(By.xpath(String.format(carValue,motor))).click();
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
        driver.findElement(By.xpath(String.format(tyreValueSize,"form_Width",value))).click();
        return this;
    }
    public MainPage setHeight(String value){
        driver.findElement(tyreHeight).click();
        driver.findElement(By.xpath(String.format(tyreValueSize,"form_CrossSections",value))).click();
        return this;
    }
    public MainPage setDiameter(String value){
        driver.findElement(tyreDiameter).click();
        driver.findElement(By.xpath(String.format(tyreValueSize,"form_Size",value))).click();
        return this;
    }
    public SizeTyresListing setAllDimension (String width,String height,String diameter){
        this.setWidth(width);
        this.setHeight(height);
        this.setDiameter(diameter);
        driver.findElement(searchButtonTyres).click();
        return new SizeTyresListing(driver);
    }

}

