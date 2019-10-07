package steps.api;

import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

/**
 * A People resource is an individual person or character within the Star Wars universe.
 */
//@DefaultUrl("http://swapi.co/api/people/")
public class PeopleSteps {

    private String BASE_URL = "http://swapi.co/api/people";

    private Response response;
    //Search
    @Step
    public void peopleSearchParam() {

        given().param("id", 1)
                .when()
                .get(BASE_URL + "/?search=skywalker")
                .then().statusCode(200)
                .body("gender", isEmptyOrNullString())
                .body("birth_year", isEmptyOrNullString())
                .body("eye_color", isEmptyOrNullString())
                .body("name", isEmptyOrNullString());

    }

    //GET
    @Step
    public void peapleCheckPeople1() {

        response = given().contentType("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(BASE_URL + "/1");
        response.then().statusCode(HttpStatus.SC_OK)
                .defaultParser(Parser.JSON)
                .body(contains("Skywalker"));
    }

    //GET
    @Step
    public void StatusAPIcallNull() {

        given().when()
                .get(BASE_URL + "1")
                .then()
                .statusCode(404);
    }

    //GET
    @Step
    public void StatusAPIcallNotInt() {

        given().param("productId", "abc123")
                .when()
                .get(BASE_URL + "1")
                .then()
                .statusCode(404);
    }

    //PUT (Update)
    @Step
    public void UpdateProductStatusHappy() {
        int productId = 0;
        JsonObject ProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", true)
                .add("productId", productId)
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("Product", ProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .get(BASE_URL + "1")
                .then().statusCode(404);
    }

    //PUT (Update)
    @Step
    public void UpdateProductStatusIsActiveNull() {
        int productId = 0;
        JsonObject ProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", JsonValue.NULL)
                .add("productId", productId)
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("Product", ProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .get(BASE_URL + "1")
                .then().statusCode(404);
    }

    //PUT (Update)
    @Step
    public void UpdateProductStatusStartDateNull() {
        int productId = 0;
        JsonObject ProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", true)
                .add("productId", productId)
                .add("startDate", JsonValue.NULL)
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("Product", ProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .get(BASE_URL + "1")
                .then().statusCode(404);
    }

    //PUT (Update)
    @Step
    public void UpdateProductStatusEndDateNull() {
        int productId = 0;
        JsonObject ProductInfo = Json.createObjectBuilder()
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", true)
                .add("productId", productId)
                .add("endDate", JsonValue.NULL)
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("Product", ProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .get(BASE_URL + "1")
                .then().statusCode(404);
    }

    //PUT (Update)
    @Step
    public void UpdateProductStatusInvalidProducId() {
        int productId = -0;
        JsonObject ProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", false)
                .add("productId", productId)
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("Product", ProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .get(BASE_URL + "1")
                .then().statusCode(404);
    }

    //PUT (Update)
    @Step
    public void UpdateProductStatusNullProducId() {
        JsonValue productId = JsonValue.NULL;
        JsonObject ProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", false)
                .add("productId", productId)
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("Product", ProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .get(BASE_URL + "1")
                .then().statusCode(404);
    }

    @Step
    public void RetrieveStatus() {

        Random rand = new Random();
        int productId = rand.nextInt(10000);

        JsonArray productJsons = Json.createArrayBuilder().add(productId).build();
        JsonObject ProductStatusBatchRequest = Json.createObjectBuilder()
                .add("productIds", productJsons)
                .build();

        System.out.println(ProductStatusBatchRequest);
        given().contentType("application/json")
                .body(ProductStatusBatchRequest.toString())
                .when()
                .get(BASE_URL + "1")
                .then().statusCode(404);
    }

}