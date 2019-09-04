package steps.ui;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

public class UISteps {
    public HomePage homePage;

    @Step
    public void goToHomePage() {homePage.findFlights();}
}
