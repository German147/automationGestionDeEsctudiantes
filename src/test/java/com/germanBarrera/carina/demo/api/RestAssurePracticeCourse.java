package com.germanBarrera.carina.demo.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssurePracticeCourse {

    public static String baseUrl = "https://api.trello.com";

    @Test
    public void getBoardsTestHeader() {
        RestAssured.baseURI = baseUrl;

        given()
                .param("key", "66230352ae879578682cf7c7f2cf090a")
                .param("token", "ATTAfea56e650a3293694d5d8e55991c689732b65d012181c824e19fda5b16d10849E6D52209").
                when()
                .get("/1/boards/se9IH8oC/lists").
                then()
                .assertThat().statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("Referrer-Policy", "strict-origin-when-cross-origin");
    }

    @Test
    public void getBoardsTestBody() {
        RestAssured.baseURI = baseUrl;

        given()
                .param("key", "66230352ae879578682cf7c7f2cf090a")
                .param("token", "ATTAfea56e650a3293694d5d8e55991c689732b65d012181c824e19fda5b16d10849E6D52209").
                when()
                .get("/1/boards/66344e514ac6c60633096dbc").
                then()
                .assertThat().statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body("name", equalTo("Trello Agile Sprint Board Template V.4"));
    }

    @Test
    public void createBoard() {
        String board_name = "MyIntelliJBoard" ;

        given()
                .param("key", "66230352ae879578682cf7c7f2cf090a")
                .param("token", "ATTAfea56e650a3293694d5d8e55991c689732b65d012181c824e19fda5b16d10849E6D52209")
                .param("name",board_name)
                .header("Content-Type","application/json").
        when()
                .post("/1/boards/").
        then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body("name",equalTo(board_name));
    }
}
