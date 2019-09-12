package ui;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import steps.ui.UISteps;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("type:UI"),
        @WithTag("pattern:Screenplay")
})
public class EarlyAccessUITest {

    @Managed
    WebDriver driver;

    @Managed
    HomePage homePage;

    @Steps
    UISteps uiSteps;

    @Test
    @WithTag(type = "type", name = "UI")
    public void findSiteWideLightboxOnHomePage() {

        uiSteps.goToHomePage();
    }
}
