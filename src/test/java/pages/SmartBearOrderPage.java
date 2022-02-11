package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearOrderPage {
    public SmartBearOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement process;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement product;

    @FindBy(xpath = "//input[contains(@type,'text')]")
    public List<WebElement> textBoxes;

    @FindBy(xpath = "//ol[2]//input")
    public List<WebElement> addressInputs;

    @FindBy(xpath = "//ol[3]//input[@type='text']")
    public List<WebElement> paymentInputs;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visa;




}
