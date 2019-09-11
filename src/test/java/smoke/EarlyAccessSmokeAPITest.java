package smoke;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.api.EarlyAccessHealthAPISteps;

@RunWith(SerenityRunner.class)
public class EarlyAccessSmokeAPITest {
    @Steps
    EarlyAccessHealthAPISteps earlyAccessHealthAPISteps;

    @Test
    @WithTag(type = "type", name = "Smoke")
    public void verifyEarlyAccessHealthWithAPI() {
        earlyAccessHealthAPISteps.verifyThatAppIsRunning();
    }
}
