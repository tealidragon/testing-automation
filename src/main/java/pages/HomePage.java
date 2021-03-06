package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(id = "overview")
    WebElement overview;

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    public void findOverview() {
        overview.isDisplayed();
    }
}
