package com.germanBarrera.carina.demo.api;

import com.germanBarrera.utils.api.ServiceAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssurePracticeCourse {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public static String baseUrl = "https://api.trello.com";
    String newBoardLinkID;
    String idToDelete;
//
//    @Test
//    public void getBoardsTestHeader() {
//        RestAssured.baseURI = baseUrl;
//
//        given()
//                .param("key", "66230352ae879578682cf7c7f2cf090a")
//                .param("token", "ATTAfea56e650a3293694d5d8e55991c689732b65d012181c824e19fda5b16d10849E6D52209").log().all().
//                when()
//                .get("/1/boards/se9IH8oC/lists").
//                then()
//                .assertThat().statusCode(200)
//                .and()
//                .contentType(ContentType.JSON)
//                .and()
//                .header("Referrer-Policy", "strict-origin-when-cross-origin");
//    }
//
//    @Test
//    public void getBoardsTestBodyName() {
//        RestAssured.baseURI = baseUrl;
//
//        Response response = given()
//                .param("key", "66230352ae879578682cf7c7f2cf090a")
//                .param("token", "ATTAfea56e650a3293694d5d8e55991c689732b65d012181c824e19fda5b16d10849E6D52209")
//                .when()
//                .get("/1/boards/se9IH8oC").
//                then()
//                .assertThat().statusCode(200).log().all()
//                .and()
//                .contentType(ContentType.JSON)
//                .and()
//                .body("name", equalTo("Trello Agile Sprint Board Template"))
//                .extract().response();
//
//        String jsonResponse = response.asString();
//        JsonPath responseBody = new JsonPath(jsonResponse);
//        LOGGER.info(responseBody.prettyPrint());
//
//    }

    @Test
    public void createBoard() {
        RestAssured.baseURI = baseUrl;
        String board_name = "My Board From API IntelliJ.V4";

        Response response = given()
                .queryParam("key", "66230352ae879578682cf7c7f2cf090a")
                .queryParam("token", "ATTAfea56e650a3293694d5d8e55991c689732b65d012181c824e19fda5b16d10849E6D52209")
                .queryParam("name", board_name)
                .header("Content-Type", "Application/json").log().all()
                .when()
                .post("/1/boards/").
                then()
                .assertThat()
                .statusCode(200).log().all()
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body("name", equalTo(board_name))
                .extract().response();

        String jsonResponse = response.asString();
        JsonPath responseBody = new JsonPath(jsonResponse);
        LOGGER.info(responseBody.prettyPrint());
        newBoardLinkID
                = responseBody.get("shortUrl");
        LOGGER.info("This is the short id from the new board created " + newBoardLinkID
        );
        ServiceAPI serviceAPI = new ServiceAPI();
        idToDelete = serviceAPI.getLastSegment(newBoardLinkID);
        LOGGER.info("thi is the new board Id " + idToDelete);


    }


    @Test
    public void deleteBoard() {
        RestAssured.baseURI = baseUrl;
        given()
                .queryParam("key", "66230352ae879578682cf7c7f2cf090a")
                .queryParam("token", "ATTAfea56e650a3293694d5d8e55991c689732b65d012181c824e19fda5b16d10849E6D52209")
                .header("Content-Type", "Application/json").log().all()
                .when()
                .delete("/1/boards/" + idToDelete)
                .then()
                .assertThat().statusCode(200).log().all();

    }
}
