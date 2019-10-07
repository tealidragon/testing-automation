package api;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.api.FilmsSteps;
import steps.api.PeopleSteps;
import steps.api.PlanetsSteps;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class APITest {

    @Steps
    PeopleSteps peopleSteps;

    @Steps
    FilmsSteps filmsSteps;

    @Steps
    PlanetsSteps planetsSteps;

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyPeopleSearch() {
        peopleSteps.peopleSearchParam();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusIsActiveNull() {
        peopleSteps.UpdateProductStatusIsActiveNull();
        peopleSteps.
                UpdateProductStatusIsActiveNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusStartDateNull() {
        peopleSteps.UpdateProductStatusStartDateNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusEndDateNull() {
        peopleSteps.UpdateProductStatusEndDateNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusInvalidProducId() {
        peopleSteps.UpdateProductStatusInvalidProducId();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusNullProducId() {
        peopleSteps.UpdateProductStatusNullProducId();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyStatus2() {
        peopleSteps.peapleCheckPeople1();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyPlanet1() {
        planetsSteps.planet1Check();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyStatusNull() {
        peopleSteps.StatusAPIcallNull();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyStatusNotInt() {
        peopleSteps.StatusAPIcallNotInt();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyUpdateProductStatusOrExpiry() {
        peopleSteps.UpdateProductStatusHappy();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyRetrieveBatchStatus() {
        peopleSteps.RetrieveStatus();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyProductIdsUploadAPI() throws IOException {
        planetsSteps.FileUpload();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyProductIdsUploadUpdateAPI() throws IOException {
        planetsSteps.FileUploadUpdate();
    }

    @Test
    @WithTag(type = "type", name = "API")
    public void verifyProductIdsbatchStatus() {
        filmsSteps.ea_post_product_batch_status();
    }
}
