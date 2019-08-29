package db;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.db.DbValidationSteps;

import java.io.IOException;
import java.sql.SQLException;

@RunWith(SerenityRunner.class)
public class EarlyAccessDbTest {

    @Steps
    DbValidationSteps dbValidationSteps;

    @Test
    @WithTag(type = "type", name = "DB")
    public void verifyEarlyAccessDB() throws IOException, SQLException {
        dbValidationSteps.verifyThatDbIsRunning();
    }
}
