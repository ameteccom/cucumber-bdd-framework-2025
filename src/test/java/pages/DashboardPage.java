package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    // Constructor for the page
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    // *************** Elements ***************
    @FindBy(xpath = "//a[@href='/admin/items']")
    public WebElement itemsTab;

}
