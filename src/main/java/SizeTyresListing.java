import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SizeTyresListing {
    private WebDriver driver;
    public SizeTyresListing(WebDriver driver) {this.driver = driver; }
    private String selectedWidth = "//select[@name=\"Width\"]/option[@value=\"%s\"][@selected=\"selected\"]";
    private String selectedHeight= "//select[@name=\"CrossSections\"]//option[@value=\"%s\"][@selected=\"selected\"]";
    private String selectedDiameter = "//select[@name=\"Size\"]//option[@value=\"%s\"][@selected=\"selected\"]";
    private String typeQuantity = "//div[@class=\"item tyre_item\"]//span[contains(text(),\"%s\")]/" +
            "ancestor::div[@class=\"description\"]/following-sibling::div//input[@value=\"%S\"]";
    private String minimumQuantity = "//div[@class=\"input_wrapper number qty\"]/a[@data-min-qty=\"2\"]";
    private String addToBasket = "//div[@class=\"item tyre_item\"]//a[@data-attr-page-type=\"listing\"]";
    private String itemsInBasket = "//div[@class=\"cart-items-block \"]//span[contains(text(),\"YOUR BASKET - %s items\")]";
    private By tyrePrice = By.xpath("//div[@class=\"right_side add_cart\"]//div[@class=\"price\"]/span");
    private By oneTyre = By.xpath("//a[@class=\"prod_link\"][contains(text(),\"Trazano SA37 Sport\")]");


    public SizeTyresListing checkTitle()
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//title[contains(text(),\"215/40 R17 passenger car summer tyres - buy cheap online\")]")));


        if (driver.getTitle().equals("215/40 R17 passenger car summer tyres - buy cheap online"))
        {
            System.out.println("Page after clicking search button is correct");
        }
        else
        {
            System.out.println("Incorrect page appears");
        }
        return this;
    }
    public boolean checkSelector(String Width, String Height, String Diameter){
        if (driver.findElement(By.xpath(String.format(selectedWidth, Width))).isDisplayed()&&
            driver.findElement(By.xpath(String.format(selectedHeight, Height))).isDisplayed()&&
            driver.findElement(By.xpath(String.format(selectedDiameter, Diameter))).isDisplayed()){
            return true;
        }
        else{return false;}


    }
    public boolean typeDefaultQuantity(String Type, int quantity){
        String qty = String.valueOf(quantity);
        if(driver.findElement(By.xpath(String.format(typeQuantity, Type,qty))).isDisplayed()){
            return true;}
        else{return  false;}
    }


    public boolean minimumQuantityToBuy(int minimumItemQuantityOrder){
        String qty = String.valueOf(minimumItemQuantityOrder);
        for (int i = 0; i < 4; i++){
            driver.findElement(By.xpath(String.format(minimumQuantity,qty))).click();}
            driver.findElement(By.xpath(addToBasket)).click();
        if(driver.findElement(By.xpath(String.format(itemsInBasket,qty))).isDisplayed()){
            return true;}
        else{return false;}}

    public SizeTyresListing findPrice() {

        List<WebElement> pricesWebElements = driver.findElements(tyrePrice);
        List<Double> pricesFromSite = new ArrayList<>();
        for (WebElement element : pricesWebElements) {
            Double price = Double.parseDouble(
                    element.getText().replaceAll("£ ", "").replaceAll(",","."));
            pricesFromSite.add(price);}
        
            System.out.println(pricesFromSite);
            return this;
        }
    public ProductTyrePage openProductTyre(){
        driver.findElement(oneTyre).click();
        return new ProductTyrePage(driver);
    }


}
