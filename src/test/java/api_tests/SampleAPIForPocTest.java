package api_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SampleAPIForPocTest {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testGetPet() {
        given()
                .when()
                .get("/pet/{petId}", 1)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", equalTo("doggie"))
                .body("status", equalTo("available"));
    }

    @Test
    public void testAddPet() {
        String requestBody = "{ \"id\": 10, \"name\": \"myPet\", \"status\": \"available\" }";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(10))
                .body("name", equalTo("myPet"))
                .body("status", equalTo("available"));
    }
}