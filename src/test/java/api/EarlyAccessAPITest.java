package api;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.api.EarlyAccessProductControllerAPISteps;
import steps.api.EarlyAccessBatchControllerAPISteps;
import steps.api.EarlyAccessProductFeedControllerAPISteps;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class EarlyAccessAPITest {

    @Steps
    EarlyAccessProductControllerAPISteps earlyAccessProductControllerAPISteps;

    @Steps
    EarlyAccessBatchControllerAPISteps earlyAccessBatchControllerAPISteps;

    @Steps
    EarlyAccessProductFeedControllerAPISteps earlyAccessProductFeedControllerAPISteps;

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessStatus() {
        earlyAccessProductControllerAPISteps.earlyAccessStatusAPIcall();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessUpdateProductStatusOrExpiry() {
        earlyAccessProductControllerAPISteps.earlyAccessUpdateProductStatusOrExpiry();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyRetrieveBatchEarlyAccessStatus() {
        earlyAccessProductControllerAPISteps.earlyAccessRetrieveStatus();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyProductIdsUploadAPI() throws IOException {
        earlyAccessProductFeedControllerAPISteps.earlyAccessFileUpload();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyProductIdsUploadUpdateAPI() throws IOException {
        earlyAccessProductFeedControllerAPISteps.earlyAccessFileUploadUpdate();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyProductIdsbatchStatus() throws IOException {
        earlyAccessBatchControllerAPISteps.ea_post_product_batch_status();
    }
}
