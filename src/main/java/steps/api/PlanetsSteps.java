package steps.api;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

public class PlanetsSteps {

    private String PLANETS_URL = "http://swapi.co/api/planets";

    private Response response;

    //Search
    @Step
    public void peopleSearchParam() {

        given().param("id", 1)
                .when()
                .get(PLANETS_URL + "/?search=skywalker")
                .then().statusCode(200)
                .body("gender", isEmptyOrNullString())
                .body("birth_year", isEmptyOrNullString())
                .body("eye_color", isEmptyOrNullString())
                .body("name", isEmptyOrNullString());

    }

    @Step
    public void planet1Check() {

        response = given().contentType("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(PLANETS_URL + "/1");
        response.then().statusCode(HttpStatus.SC_OK)
//                .defaultParser(Parser.JSON)
                .body("climate", equalToIgnoringCase("Arid"));
    }

    List<Integer> randInts = new ArrayList<Integer>();


    public List<Integer> getRandInts() {
        if (randInts.isEmpty()) {
            setRandInts(randInts);
        }
        return this.randInts;
    }

    public void setRandInts(List<Integer> randInts) {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            this.randInts.add(rand.nextInt(100000));
        }
        this.randInts = randInts;
    }

//    List<Integer> randInts = new Random().ints(0,10000).boxed().collect(Collectors.toList());


    @Step
    public void FileUpload() throws IOException {
//        String URL = "http://.cluboautomation.test.ostk.com:8080";
        String URL = "https://swapi.co/api";

        boolean productsFile = false;
        File file;
        try {
            file = new File("Products.txt");
            file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getName()));
//            for (int randi : randInts) {
            for (int randi : getRandInts()) {
                writer.write("" + randi);
                writer.newLine();
            }
            writer.close();
            System.out.println(file.getAbsolutePath());

            given().multiPart("file", file, "application/txt")
                    .when()
                    .post(URL + "/early/access/product/feed/file/upload")
                    .then().statusCode(404);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Step
    public void FileUploadUpdate() throws IOException {
        String URL = "https://swapi.co/api";

        boolean productsFile = false;
        File file;
        try {
            file = new File("ProductsUpdate.txt");
            file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getName()));
//            for (int randi : randInts) {
            for (int randi : getRandInts()) {
                writer.write("" + randi + ",I,9/17/2019");
                writer.newLine();
            }
            writer.close();
            System.out.println(file.getAbsolutePath());
            given().multiPart("file", file, "application/txt")
                    .when()
                    .put(URL + "/early/access/product/feed/file/upload/update")
                    .then().statusCode(404);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}