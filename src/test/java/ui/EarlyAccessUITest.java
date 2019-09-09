package ui;

import com.overstock.arch.automation.WebDriverProvider;
import com.overstock.clubo.common.TestBase;
import com.overstock.clubo.common.util.COUtils;
import com.overstock.framework.Bordello;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.ui.UISteps;

public class EarlyAccessUITest extends TestBase {
    static {
        COUtils.init(true);
    }

    @Managed
    WebDriver driver;

    @Steps
    UISteps uiSteps;

    @Test
    @WithTag(type = "type", name = "UI")
    public void findFlights() {
        driver = Bordello.get(WebDriverProvider.class).driver();
        uiSteps.goToHomePage();
    }
}
