package smoke;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.api.HealthAPISteps;

@RunWith(SerenityRunner.class)
public class SmokeAPITest {
    @Steps
    HealthAPISteps HealthAPISteps;

    @Test
    @WithTag(type = "type", name = "Smoke")
    public void verifyHealthWithAPI() {
        HealthAPISteps.verifyThatAppIsRunning();
    }
}
