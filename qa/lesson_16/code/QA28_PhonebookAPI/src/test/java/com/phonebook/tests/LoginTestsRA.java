package com.phonebook.tests;

import com.phonebook.dto.AuthRequestDto;
import com.phonebook.dto.AuthResponseDto;
import com.phonebook.dto.ErrorDto;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginTestsRA extends TestBase{

    AuthRequestDto auth = AuthRequestDto.builder()
            .username("leno@gmail.com")
            .password("Bernd1234$")
            .build();

    @Test
    public void loginPositiveTest() {
        AuthResponseDto dto = given()
                .contentType("application/json")
                .body(auth)
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);
        System.out.println(dto.getToken());
    }

    @Test
    public void loginSuccessTest() {
        String responseToken = given()
                .contentType("application/json")
                .body(auth)
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                .body(containsString("token"))
                .extract().path("token");
        System.out.println(responseToken);
    }

    @Test
    public void loginNegativeWithWrongEmailTest() {
        ErrorDto errorDto = given()
                .body(AuthRequestDto.builder()
                        .username("leno1@gmail.com")
                        .password("Bernd1234$")
                        .build())
                .contentType(ContentType.JSON)
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);

        Assert.assertEquals(errorDto.getError(),"Unauthorized");
        Assert.assertEquals(errorDto.getMessage(),"Login or Password incorrect");
    }

    @Test
    public void loginNegativeWithWrongEmailTest2() {
        given()
                .body(AuthRequestDto.builder()
                        .username("leno1@gmail.com")
                        .password("Bernd1234$")
                        .build())
                .contentType(ContentType.JSON)
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401)
                .assertThat().body("error",equalTo("Unauthorized"))
                .assertThat().body("message",containsString("incorrect"));
    }

}
