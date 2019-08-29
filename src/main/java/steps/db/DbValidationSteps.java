package steps.db;

import clubo.PostgresDb;
import net.thucydides.core.annotations.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static net.serenitybdd.rest.SerenityRest.given;

public class DbValidationSteps {

    @Step
    public void verifyThatDbIsRunning() throws SQLException {

        Connection postgresConnection = PostgresDb.getConnection();
        Statement statement = postgresConnection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"public\".early_access_product;");

        given()
                .get("http://blazedemo.com").then().statusCode(200);
    }

}
