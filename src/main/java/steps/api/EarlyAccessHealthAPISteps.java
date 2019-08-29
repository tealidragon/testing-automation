package steps.api;

import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.given;

public class EarlyAccessHealthAPISteps {
    @Step
    public void verifyThatAppIsRunning() {
        given()
                .get("http://earlyaccess.cluboautomation.test.ostk.com:8080/health").then().statusCode(200);
    }
}