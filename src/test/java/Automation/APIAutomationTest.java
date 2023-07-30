package Automation;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class APIAutomationTest {
    String baseURI = "https://reqres.in";
    @Test
    public void getUserTest() {
        Response response = given().contentType(ContentType.JSON).baseUri(baseURI).when().get("/api/users/2");
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test
    public void postUserTest() {
        Response response = given().contentType(ContentType.JSON).baseUri(baseURI).body("{\r\n"
                + "    \"name\": \"Suraj\",\r\n"
                + "    \"job\": \"QA\"\r\n"
                + "}").when().post("/api/users");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 201);
    }
    @Test
    public void putUserTest() {
        Response response = given().contentType(ContentType.JSON).baseUri(baseURI).body("{\r\n"
                + "    \"name\": \"Suraj\",\r\n"
                + "    \"job\": \"VV Residental\"\r\n"
                + "}").when().put("/api/users/2");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200);
        JsonPath js = new JsonPath(response.asString());
        System.out.println(js.get("name").toString());
    }
    @Test
    public void deletUserTest() {
        Response response = given().contentType(ContentType.JSON).baseUri(baseURI).when().delete("/api/users/2");
        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 204);
    }
}
