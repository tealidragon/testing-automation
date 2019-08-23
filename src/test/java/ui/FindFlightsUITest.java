package ui;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import steps.ui.FindFlightsUISteps;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SerenityRunner.class)
public class FindFlightsUITest {
    ChromeOptions chromeOptions = new ChromeOptions();

    @Managed
    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);

    @Steps
    FindFlightsUISteps findFlightsUISteps;

    public FindFlightsUITest() throws MalformedURLException {
    }

    @Test
    @WithTag(type="type", name="UI")
    public void  findFlights() {
        findFlightsUISteps.findFlights();
    }
}