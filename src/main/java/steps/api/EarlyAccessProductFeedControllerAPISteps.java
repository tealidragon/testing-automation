package steps.api;

import com.overstock.model.Id;
import com.overstock.model.ids.ProductId;
import net.thucydides.core.annotations.Step;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.given;

public class EarlyAccessProductFeedControllerAPISteps {

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

    @Step
    public void earlyAccessFileUploadUpdate() throws IOException {
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
                    .put(earlyAccessURL + "/early/access/product/feed/file/upload/update")
                    .then().statusCode(200);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}