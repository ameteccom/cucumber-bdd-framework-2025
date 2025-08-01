package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemsPage {

    // Constructor for the page
    public ItemsPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    // *************** Elements ***************
    @FindBy(xpath = "//button[text()=' Add Item']")
    public WebElement addItemButton;

    @FindBy(xpath = "//div[@class='relative rounded-md shadow-sm font-base']/input")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@id='0']")
    public WebElement priceInput;

    @FindBy(xpath = "//div[@tabindex='-1']/input")
    public WebElement unitSelect;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement discriptionInput;

    @FindBy(xpath = "//button[text()=' Save Item']")
    public WebElement saveItemButton;

    @FindBy(xpath = "//a[contains(@href,'/admin/items/')]")
    public List<WebElement> itemList;


}
