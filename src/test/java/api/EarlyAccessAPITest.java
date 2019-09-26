package api;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.api.EarlyAccessBatchControllerAPISteps;
import steps.api.EarlyAccessProductControllerAPISteps;
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
    public void verifyEarlyAccessUpdateProductStatusIsActiveNull() {
        earlyAccessProductControllerAPISteps.earlyAccessUpdateProductStatusIsActiveNull();
        earlyAccessProductControllerAPISteps.
                earlyAccessUpdateProductStatusIsActiveNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessUpdateProductStatusStartDateNull() {
        earlyAccessProductControllerAPISteps.earlyAccessUpdateProductStatusStartDateNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessUpdateProductStatusEndDateNull() {
        earlyAccessProductControllerAPISteps.earlyAccessUpdateProductStatusEndDateNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessUpdateProductStatusInvalidProducId() {
        earlyAccessProductControllerAPISteps.earlyAccessUpdateProductStatusInvalidProducId();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessUpdateProductStatusNullProducId() {
        earlyAccessProductControllerAPISteps.earlyAccessUpdateProductStatusNullProducId();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessStatus2() {
        earlyAccessProductControllerAPISteps.earlyAccessStatusAPIcall2();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessStatusNull() {
        earlyAccessProductControllerAPISteps.earlyAccessStatusAPIcallNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessStatusNotInt() {
        earlyAccessProductControllerAPISteps.earlyAccessStatusAPIcallNotInt();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyEarlyAccessUpdateProductStatusOrExpiry() {
        earlyAccessProductControllerAPISteps.earlyAccessUpdateProductStatusHappy();
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
    public void verifyProductIdsbatchStatus() {
        earlyAccessBatchControllerAPISteps.ea_post_product_batch_status();
    }
}
