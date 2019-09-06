package steps.api;

import com.overstock.model.Id;
import com.overstock.model.ids.ProductId;
import net.thucydides.core.annotations.Step;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class EarlyAccessProductControllerAPISteps {

    //GET
    @Step
    public void earlyAccessStatusAPIcall() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";

        given().param("productId", new Id<ProductId>(9809209))
                .when()
                .get(earlyAccessURL + "/early/access/product/" + new Id<ProductId>(9809209))
                .then().statusCode(200)
                .body("productId", is(9809209))
                .body("isActive", is(false))
                .body("startDate", isEmptyOrNullString())
                .body("endDate", isEmptyOrNullString());

    }

    //GET
    @Step
    public void earlyAccessStatusAPIcall2() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";

        given().param("productId", new Id<ProductId>(9809209))
                .when()
                .get(earlyAccessURL + "/early/access/product/" + new Id<ProductId>(9809209))
                .then()
                .statusCode(200)
                .body("productId", is(9809209));
    }

    //GET
    @Step
    public void earlyAccessStatusAPIcallNull() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";

        given().when()
                .get(earlyAccessURL + "/early/access/product/")
                .then()
                .statusCode(404);
    }

    //GET
    @Step
    public void earlyAccessStatusAPIcallNotInt() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";

        given().param("productId", "abc123")
                .when()
                .get(earlyAccessURL + "/early/access/product/abc123")
                .then()
                .statusCode(400);
    }

    //PUT (Update)
    @Step
    public void earlyAccessUpdateProductStatusHappy() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";
        int productId = 0;
        JsonObject earlyAccessProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", true)
                .add("productId", productId)
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("earlyAccessProduct", earlyAccessProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .put(earlyAccessURL + "/early/access/product/" + productId)
                .then().statusCode(200);
    }

    //PUT (Update)
    @Step
    public void earlyAccessUpdateProductStatusIsActiveNull() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";
        int productId = 0;
        JsonObject earlyAccessProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", JsonValue.NULL)
                .add("productId", productId)
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("earlyAccessProduct", earlyAccessProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .put(earlyAccessURL + "/early/access/product/" + productId)
                .then().statusCode(200);
    }

    //PUT (Update)
    @Step
    public void earlyAccessUpdateProductStatusStartDateNull() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";
        int productId = 0;
        JsonObject earlyAccessProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", true)
                .add("productId", productId)
                .add("startDate", JsonValue.NULL)
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("earlyAccessProduct", earlyAccessProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .put(earlyAccessURL + "/early/access/product/" + productId)
                .then().statusCode(200);
    }

    //PUT (Update)
    @Step
    public void earlyAccessUpdateProductStatusEndDateNull() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";
        int productId = 0;
        JsonObject earlyAccessProductInfo = Json.createObjectBuilder()
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", true)
                .add("productId", productId)
                .add("endDate", JsonValue.NULL)
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("earlyAccessProduct", earlyAccessProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .put(earlyAccessURL + "/early/access/product/" + productId)
                .then().statusCode(200);
    }

    //PUT (Update)
    @Step
    public void earlyAccessUpdateProductStatusInvalidProducId() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";
        int productId = -0;
        JsonObject earlyAccessProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", false)
                .add("productId", productId)
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("earlyAccessProduct", earlyAccessProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .put(earlyAccessURL + "/early/access/product/" + productId)
                .then().statusCode(200);
    }

    //PUT (Update)
    @Step
    public void earlyAccessUpdateProductStatusNullProducId() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";
        JsonValue productId = JsonValue.NULL;
        JsonObject earlyAccessProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", false)
                .add("productId", productId)
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("earlyAccessProduct", earlyAccessProductInfo)
                .add("productId", productId)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .put(earlyAccessURL + "/early/access/product/" + productId)
                .then().statusCode(400);
    }


    @Step
    public void earlyAccessRetrieveStatus() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";

        Random rand = new Random();
        int productId = rand.nextInt(10000);

        JsonArray productJsons = Json.createArrayBuilder().add(productId).build();
        JsonObject earlyAccessProductStatusBatchRequest = Json.createObjectBuilder()
                .add("productIds", productJsons)
                .build();

        System.out.println(earlyAccessProductStatusBatchRequest);
        given().contentType("application/json")
                .body(earlyAccessProductStatusBatchRequest.toString())
                .when()
                .post(earlyAccessURL + "/early/access/product/batch/status")
                .then().statusCode(200);
    }

}