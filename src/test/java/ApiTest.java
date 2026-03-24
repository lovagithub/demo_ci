import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

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
}
