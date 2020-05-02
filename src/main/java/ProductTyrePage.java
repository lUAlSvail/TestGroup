import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductTyrePage {
    WebDriver driver;
    public ProductTyrePage(WebDriver driver) {
        this.driver = driver;
    }
    private String tyreQuantity = "//input[@class=\"pkw-product__input\"][@value=\"%s\"]";
    private String minimumQuantity = "//form[@class=\"pkw-product__control\"]//button[@data-min-qty=\"%s\"]";
    private String addToBasket = "//button[@class=\"pkw-product__buy-btn basket_btn tires \"]";
    private String itemsInBasket = "//div[@class=\"cart-items-block \"]//span[contains(text(),\"YOUR BASKET - %s items\")]";
    private By closePopUp = By.xpath("//span[@class=\"popup-related__close\"]");
    public ProductTyrePage checkTitle()
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//title[contains(text(),\"Trazano SA37 Sport 215/40 ZR17 87 W passenger car Summer tyres R-395374 (6927116148690)\")]")));


        if (driver.getTitle().equals("Trazano SA37 Sport 215/40 ZR17 87 W passenger car Summer tyres R-395374 (6927116148690)"))
        {
            System.out.println("Page after clicking search button is correct");
        }
        else
        {
            System.out.println("Incorrect page appears");
        }
        return this;
    }
    public boolean typeDefaultQuantity( int quantity){
        String qty = String.valueOf(quantity);
        if(driver.findElement(By.xpath(String.format(tyreQuantity, qty))).isDisplayed()){
            return true;}
        else{return  false;}
    }


    public boolean minimumQuantityToBuy(int minimumItemQuantityOrder){
        String qty = String.valueOf(minimumItemQuantityOrder);
        for (int i = 0; i < 4; i++){
            driver.findElement(By.xpath(String.format(minimumQuantity,qty))).click();}
        driver.findElement(By.xpath(addToBasket)).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(closePopUp));
        driver.findElement(closePopUp).click();

        if(driver.findElement(By.xpath(String.format(itemsInBasket,qty))).isDisplayed()){
            return true;}
        else{return false;}}
}
