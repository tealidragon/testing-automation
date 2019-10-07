package steps.db;

import DB.PostgresDb;
import net.thucydides.core.annotations.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;

public class DbValidationSteps {

    @Step
    public void verifyThatDbIsRunning() throws SQLException {

        Connection postgresConnection = PostgresDb.getConnection();
        Statement statement = postgresConnection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"public\".early_access_product;");

        assertEquals(ResultSet.class, resultSet);
    }

}
