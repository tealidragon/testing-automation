package api;

import com.beust.jcommander.internal.Lists;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.api.FilmsSteps;
import steps.api.PeopleSteps;
import steps.api.PlanetsSteps;

import java.io.IOException;
import java.util.List;

@RunWith(SerenityRunner.class)
public class PeopleAPITest {

    @Steps
    PeopleSteps peopleSteps;

    private List<Integer> peopleIds = Lists.newArrayList();

    @Before
    public void setPeopleIds(){
        //People 1
        peopleIds.add(1);
    }

    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyPeopleSearch() {
        peopleSteps.peopleSearchParam("skywalker");
    }

    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyUpdateProductStatusIsActiveNull() {
        peopleSteps.UpdateProductStatusIsActiveNull();
        peopleSteps.
                UpdateProductStatusIsActiveNull();
    }

    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyUpdateProductStatusStartDateNull() {
        peopleSteps.UpdateProductStatusStartDateNull();
    }

    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyUpdateProductStatusEndDateNull() {
        peopleSteps.UpdateProductStatusEndDateNull();
    }

    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyUpdateProductStatusInvalidProducId() {
        peopleSteps.UpdateProductStatusInvalidProducId();
    }

    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyUpdateProductStatusNullProducId() {
        peopleSteps.UpdateProductStatusNullProducId();
    }

    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyStatus2() {
        peopleSteps.peapleCheckPeople1();
    }


    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyStatusNull() {
        peopleSteps.StatusAPIcallNull();
    }

    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyStatusNotInt() {
        peopleSteps.StatusAPIcallNotInt();
    }

    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyUpdateProductStatusOrExpiry() {
        peopleSteps.UpdateProductStatusHappy();
    }

    @Test
    @WithTag(type = "type", name = "PeopleAPI" )
    public void verifyRetrieveBatchStatus() {
        peopleSteps.RetrieveStatus();
    }

}
