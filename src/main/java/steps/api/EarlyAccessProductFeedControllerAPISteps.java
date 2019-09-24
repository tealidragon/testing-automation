package steps.api;

import net.thucydides.core.annotations.Step;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static net.serenitybdd.rest.SerenityRest.given;

public class EarlyAccessProductFeedControllerAPISteps {

//    List<Integer> randInts = new ArrayList<Integer>();
//
//
//    public List<Integer> getRandInts() {
//            setRandInts(randInts);
//        return this.randInts;
//    }
//
//    public void setRandInts(List<Integer> randInts) {
//        Random rand = new Random();
//        if (randInts.isEmpty()) {
//            for (int i = 0; i < 1000; i++) {
//                this.randInts.add(rand.nextInt(100000));
//            }
//        }
//        this.randInts = randInts;
//    }

    List<Integer> randInts = new Random().ints(1000).boxed().collect(Collectors.toList());


    @Step
    public void earlyAccessFileUpload() throws IOException {
        String earlyAccessURL = "http://k8s-master.cluboautomation.test.ostk.com:32005";

        boolean productsFile = false;
        File file;
        try {
            file = new File("EarlyAccessProducts.txt");
            file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getName()));
            for (int randi : randInts) {
//            for (int randi : getRandInts()) {
                writer.write("" + randi);
                writer.newLine();
            }
            writer.close();
            System.out.println(file.getAbsolutePath());

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
        String earlyAccessURL = "http://k8s-master.cluboautomation.test.ostk.com:32005";

        boolean productsFile = false;
        File file;
        try {
            file = new File("EarlyAccessProductsUpdate.txt");
            file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getName()));
            for (int randi : randInts) {
//            for (int randi : getRandInts()) {
                writer.write("" + randi + ",I,9/17/2019");
                writer.newLine();
            }
            writer.close();
            System.out.println(file.getAbsolutePath());
            given().multiPart("file", file, "application/txt")
                    .when()
                    .put(earlyAccessURL + "/early/access/product/feed/file/upload/update")
                    .then().statusCode(200);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}