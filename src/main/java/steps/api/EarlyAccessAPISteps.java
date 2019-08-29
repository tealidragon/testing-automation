package steps.api;

import com.overstock.clubo.common.enums.ServiceEnum;
import com.overstock.clubo.common.util.COUtils;
import com.overstock.model.Id;
import com.overstock.model.ids.CustomerId;
import com.overstock.model.ids.ProductId;
import com.sun.tools.javac.code.Attribute;
import net.thucydides.core.annotations.Step;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.given;

public class EarlyAccessAPISteps {

    @Step
    public void earlyAccessStatusAPIcall() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";

        given().param("productId", new Id<ProductId>(9809209))
                .when()
                .get(earlyAccessURL + "/early/access/product/" + new Id<ProductId>(9809209) + "/status")
                .then().statusCode(200);
    }

    @Step
    public void earlyAccessCreateAPIcall() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";
        Random rand = new Random();
        int productId = rand.nextInt(10000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String startDate =
                //"2019-09-28T15:31:15.564Z";
                dateFormat.format(new Date().from(Instant.now().minus(10, ChronoUnit.DAYS)));
        String endDate =
                //"2019-08-27T15:31:15.564Z";
                dateFormat.format(new Date().from(Instant.now().plus(10, ChronoUnit.DAYS)));

        JsonObject productJson = Json.createObjectBuilder()
                .add("endDate", endDate)
                .add("productId", productId)
                .add("startDate", startDate)
                .build();
        JsonArray productJsons = Json.createArrayBuilder().add(productJson).build();
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("earlyAccessProductDtos", productJsons)
                .build();

        System.out.println(jsonObject);

        given().contentType("application/json")
                .body(jsonObject.toString())
                .when()
                .post(earlyAccessURL + "/early/access/product/batch/create")
                .then().statusCode(200);
    }

    @Step
    public void earlyAccessCreateAPIcallNotActiveStatus() {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";

        Random rand = new Random();
        int productId = rand.nextInt(10000);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String startDate =
                //"2019-09-28T15:31:15.564Z";
                dateFormat.format(new Date().from(Instant.now().minus(10, ChronoUnit.DAYS)));
        String endDate =
                //"2019-08-27T15:31:15.564Z";
                dateFormat.format(new Date().from(Instant.now()));

        JsonObject productJson = Json.createObjectBuilder()
                .add("endDate", endDate)
                .add("productId", productId)
                .add("startDate", startDate)
                .build();
        JsonArray productJsons = Json.createArrayBuilder().add(productJson).build();
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("earlyAccessProductDtos", productJsons)
                .build();

        System.out.println(jsonObject);

        given().contentType("application/json")
                .body(jsonObject.toString())
                .when()
                .post(earlyAccessURL + "/early/access/product/batch/create")
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

    @Step
    public void earlyAccessFileUpload() throws IOException {
        String earlyAccessURL = "http://earlyaccess.cluboautomation.test.ostk.com:8080";

        Random rand = new Random();
        int productId = rand.nextInt(10000);

        boolean productsFile = false;
        File file;
        try {
            file = new File("EarlyAccessProducts.txt");
            file.createNewFile();

            given().multiPart("file", file, "application/txt")
                    .when()
                    .post(earlyAccessURL + "/early/access/product/feed/file/upload")
                    .then().statusCode(200);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}