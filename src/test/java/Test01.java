
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;
import java.lang.*;
import org.json.JSONArray;

public class Test01 {
    @Test
    void test_01() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
        int statusCode = response.getStatusCode();
        response.getBody();
        System.out.println(response.getBody().asString());
        System.out.println(response.asString());
        System.out.println( response.getStatusCode());
        Assert.assertEquals(statusCode,200);
    }
    @Test
    void test_02()
    {
        given().get("https://jsonplaceholder.typicode.com/users").then().statusCode(200);
    }

    @Test
    void test_03()
    {
        given()
                .get("https://jsonplaceholder.typicode.com/users")
        .then()
                .body("id[8]",equalTo(9));
    }
   @Test
    void test_04()
    {
        Response res = given()
                .accept(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/users?username=Delphine").then().statusCode(200);
        System.out.println("" +res.body().asString());
    }

    @Test
    void test_05()
    {
        given()
                .accept(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/users/9/posts")
                .then()
                .body("username", equalToIgnoringCase("Delphine"));

    }

    @Test
   public void test_06()
    {
    List<Integer> idOfAllposts =
            given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("https://jsonplaceholder.typicode.com/users/9/posts")
                    .then()
                    .extract()
                    .response()
                    .path("id");

    System.out.println(idOfAllposts.toString());
    System.out.println(idOfAllposts.size());
    }

    @Test
    public void test_07()
    {
        List<Integer> idOfAllposts =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .get("https://jsonplaceholder.typicode.com/users/9/posts")
                        .then()
                        .extract()
                        .response()
                        .path("id");

        System.out.println(idOfAllposts.toString());
        System.out.println(idOfAllposts.size());
    }

}