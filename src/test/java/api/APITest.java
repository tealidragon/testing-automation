package api;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.api.BatchControllerAPISteps;
import steps.api.ProductControllerAPISteps;
import steps.api.ProductFeedControllerAPISteps;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class APITest {

    @Steps
    ProductControllerAPISteps ProductControllerAPISteps;

    @Steps
    BatchControllerAPISteps BatchControllerAPISteps;

    @Steps
    ProductFeedControllerAPISteps ProductFeedControllerAPISteps;

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyStatus() {
        ProductControllerAPISteps.StatusAPIcall();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusIsActiveNull() {
        ProductControllerAPISteps.UpdateProductStatusIsActiveNull();
        ProductControllerAPISteps.
                UpdateProductStatusIsActiveNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusStartDateNull() {
        ProductControllerAPISteps.UpdateProductStatusStartDateNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusEndDateNull() {
        ProductControllerAPISteps.UpdateProductStatusEndDateNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusInvalidProducId() {
        ProductControllerAPISteps.UpdateProductStatusInvalidProducId();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusNullProducId() {
        ProductControllerAPISteps.UpdateProductStatusNullProducId();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyStatus2() {
        ProductControllerAPISteps.StatusAPIcall2();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyStatusNull() {
        ProductControllerAPISteps.StatusAPIcallNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyStatusNotInt() {
        ProductControllerAPISteps.StatusAPIcallNotInt();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusOrExpiry() {
        ProductControllerAPISteps.UpdateProductStatusHappy();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyRetrieveBatchStatus() {
        ProductControllerAPISteps.RetrieveStatus();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyProductIdsUploadAPI() throws IOException {
        ProductFeedControllerAPISteps.FileUpload();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyProductIdsUploadUpdateAPI() throws IOException {
        ProductFeedControllerAPISteps.FileUploadUpdate();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyProductIdsbatchStatus() {
        BatchControllerAPISteps.ea_post_product_batch_status();
    }
}
