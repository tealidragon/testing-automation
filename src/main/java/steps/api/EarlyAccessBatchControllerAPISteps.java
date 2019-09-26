package steps.api;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.given;

public class EarlyAccessBatchControllerAPISteps {
    //NEW

    private Response response;


    @Step
    public void ea_post_product_batch_status() {

        String earlyAccessURL = "http://k8s-master.cluboautomation.test.ostk.com:32005";

        Random rand = new Random();
        int productId = rand.nextInt(10000);

        int[] productIds = {rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000),
                rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000),
                rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000),
                rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000),
                rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000),
                rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000), rand.nextInt(10000)};

        JsonArrayBuilder productJsonBuilder = Json.createArrayBuilder();
        for (int productIdInArray : productIds) {
            productJsonBuilder.add(productIdInArray).build();
        }
        JsonObject earlyAccessProductStatusBatchRequest = Json.createObjectBuilder()
                .add("productIds", productJsonBuilder.build())
                .build();

        System.out.println(earlyAccessProductStatusBatchRequest);
//        given().contentType("application/json")
//                .body(earlyAccessProductStatusBatchRequest.toString())
//                .when()
//                .post(earlyAccessURL + "/early/access/product/batch/status")
//                .then().statusCode(200);

        response = SerenityRest.when()
                .post(earlyAccessURL + "/early/access/product/batch/status");
        response.then().statusCode(200);
    }

}
