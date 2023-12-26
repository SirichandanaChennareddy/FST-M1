package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity1 {

    // Set base URL
    final static String baseURI = "https://petstore.swagger.io/v2/pet";

    @Test(priority=1)
    public void POSTPetRequest() {
        // Create JSON request
        String reqBody = "{"
                + "\"id\": 77232,"
                + "\"name\": \"Riley\","
                + " \"status\": \"alive\""
                + "}";

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody) // Add request body
                        .when().post(baseURI); // Send POST request

        // Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
        System.out.println("POST Request with param Pet id:77232 name: Riley and status: alive is successfully sent");
        System.out.println(response.body().asPrettyString());
        System.out.println(response.statusLine());
    }

    @Test(priority=2)
    public void GETPetInfoRequest() {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77232") // Set path parameter
                        .get(baseURI + "/{petId}"); // Send GET request

        // Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
        System.out.println("GET Request for Pet id:77232 is successfully sent");
        System.out.println(response.body().asPrettyString());
        System.out.println(response.statusLine());
    }

    @Test(priority=3)
    public void DELETEPetRequest() {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77232") // Set path parameter
                        .delete(baseURI + "/{petId}"); // Send DELETE request

        // Assertion Validation
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("77232"));
        System.out.println("DELETE Request for Pet id:77232 is successfully sent");
        System.out.println(response.body().asPrettyString());
        System.out.println(response.statusLine());
    }
}
