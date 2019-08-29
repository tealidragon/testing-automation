package api;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.api.EarlyAccessAPISteps;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class EarlyAccessAPITest {

    @Steps
    EarlyAccessAPISteps earlyAccessAPISteps;

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessStatus() {
        earlyAccessAPISteps.earlyAccessStatusAPIcall();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyCreateEarlyAccess() {
        earlyAccessAPISteps.earlyAccessCreateAPIcall();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyCreateEarlyAccessNotActive() {
        earlyAccessAPISteps.earlyAccessCreateAPIcallNotActiveStatus();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyRetrieveBatchEarlyAccessStatus() {
        earlyAccessAPISteps.earlyAccessRetrieveStatus();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyProductIdsUploadAPI() throws IOException {
        earlyAccessAPISteps.earlyAccessFileUpload();
    }
}
