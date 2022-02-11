package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearWebOrdersPage {
    public SmartBearWebOrdersPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#ctl00_menu>li")
    public List<WebElement> menu;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAll;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAll;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkBox;

    @FindBy(xpath = "//table[@class='SampleTable']//tr[2]/td")
    public List<WebElement> userInfo;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement delete;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement message;






}
