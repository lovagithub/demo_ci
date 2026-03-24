import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    void testGetProducts() {
        given()
                .when()
                .get("https://fakestoreapi.com/products")
                .then()
                .statusCode(200);
    }

    @Test
    void testSingleProduct() {
        given()
                .when()
                .get("https://fakestoreapi.com/products/1")
                .then()
                .statusCode(200)
                .body("title", notNullValue())
                .body("price", notNullValue())
                .body("category", notNullValue());
    }
    @Test
    void testProductFields() {
        given()
                .when()
                .get("https://fakestoreapi.com/products")
                .then()
                .statusCode(200)
                .body("[0].title", notNullValue())
                .body("[0].price", notNullValue())
                .body("[0].category", notNullValue());
    }


}