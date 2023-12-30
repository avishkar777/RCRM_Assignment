package TestClasses;

import PojoClasses.CreateUserPOJO;
import PojoClasses.UpdateUserPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestTest {
    String URI="https://gorest.co.in/";
    Faker faker=new Faker();
    String id="";
    CreateUserPOJO user;
    UpdateUserPOJO update_user;
    String Token="87a22d583a42d50b049eeb2eba444afa31c8f9bc2ef5e5b60d2e8c4f5e6b24ec";
    @Test(priority = 1)
    public void Test1(){
        RestAssured.baseURI=URI;
        user=new CreateUserPOJO();
        user.setEmail(faker.name().username()+"@gmail.com");
        user.setGender("male");
        user.setName(faker.name().fullName());
        user.setStatus("active");
        ObjectMapper objectMapper=new ObjectMapper();
        String payload= null;
        try {
            payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(payload);
        Response response=given().
                header("Content-type","application/json").
                header("Authorization","Bearer "+Token).
                body(payload).
        when().
                post("public/v2/users").
        then().
                assertThat().statusCode(201).and().contentType(ContentType.JSON).and().body("email",equalTo(user.getEmail())).extract().response();
        JsonPath jsonPath=new JsonPath(response.asString());
        id= jsonPath.getString("id");


        System.out.println(response.asString());
    }

    @Test(priority = 2)
    public void GetDetails(){
        RestAssured.baseURI=URI;
        Response response=given().
                header("Authorization","Bearer "+Token).header("Content-Type","application/json").pathParam("id",id).
        when().
                get("/public/v2/users/{id}").
        then().
                assertThat().statusCode(200).and().extract().response();
        System.out.println(response.asString());

    }

    @Test(priority = 3)
    public void UpdateUser(){
        RestAssured.baseURI=URI;
        update_user=new UpdateUserPOJO();
        update_user.setEmail(faker.name().username()+"@gmail.com");
        update_user.setName(faker.name().fullName());
        update_user.setStatus("active");
        ObjectMapper objectMapper=new ObjectMapper();
        String payload="";
        try {
            payload=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(update_user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Response response=given().
                header("Authorization","Bearer "+Token)
                .header("Content-Type","application/json").pathParam("id",id).body(payload).
        when().
                put("public/v2/users/{id}").
        then().
                assertThat().statusCode(200).and().extract().response();
        System.out.println(response.asString());
    }

    @Test(priority = 4)
    public void TestDelete(){
        RestAssured.baseURI=URI;
        given().
                header("Authorization","Bearer "+Token)
                .pathParam("id",id).
        when().
                delete("public/v2/users/{id}").
        then().
                assertThat().statusCode(204);
    }
}
