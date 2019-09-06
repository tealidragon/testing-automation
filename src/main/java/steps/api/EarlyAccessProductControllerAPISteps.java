package steps.api;

import com.overstock.model.Id;
import com.overstock.model.ids.ProductId;
import net.thucydides.core.annotations.Step;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
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
    public void earlyAccessUpdateProductStatusOrExpiry() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";

        Random rand = new Random();
        int[] productIds = {9017170,
                9085987,
                9086032,
                9121578,
                9130935,
                9136162,
                9172876,
                9179161,
                9401127,
                9407955,
                9412897,
                9421853};

        JsonArrayBuilder productJsonBuilder = Json.createArrayBuilder();
        for (int productIdInArray : productIds) {
            productJsonBuilder.add(productIdInArray).build();
        }
        JsonObject earlyAccessProductInfo = Json.createObjectBuilder()
                .add("endDate", "2019-09-06T16:59:25.306Z")
                .add("isActive", true)
                .add("productId", 0)
                .add("startDate", "2019-09-06T16:59:25.306Z")
                .build();
        JsonObject productUpdateRequest = Json.createObjectBuilder()
                .add("earlyAccessProduct", earlyAccessProductInfo)
                .add("productId", 0)
                .build();


        System.out.println(productUpdateRequest);
        given().contentType("application/json")
                .body(productUpdateRequest.toString())
                .when()
                .put(earlyAccessURL + "/early/access/product/" + 0)
                .then().statusCode(200);
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