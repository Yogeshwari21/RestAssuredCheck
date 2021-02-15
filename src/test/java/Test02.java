import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class Test02 {

        @Test
        void test_05()
        {
            given()
            .accept(ContentType.JSON)
                    .when()
                    .get("https://jsonplaceholder.typicode.com/comments?postId=81")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .and()
                    .body(matchesJsonSchemaInClasspath("commentsSchema.json"));
        }

    }
