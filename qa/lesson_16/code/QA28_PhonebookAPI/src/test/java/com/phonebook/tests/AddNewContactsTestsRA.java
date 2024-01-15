package com.phonebook.tests;

import com.phonebook.dto.ContactDto;
import com.phonebook.dto.ErrorDto;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddNewContactTestsRA extends TestBase {

    ContactDto dto = ContactDto.builder()
            .name("Oliver")
            .lastName("Kan")
            .email("kan@gm.com")
            .phone("1234567890")
            .address("Berlin")
            .description("goalkeeper")
            .build();

    @Test
    public void addNewContactPositiveTest() {
        String message = given()
                .header("Authorization", TOKEN)
                .body(dto)
                .contentType(ContentType.JSON)
                .post("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().path("message");

        System.out.println(message);
        //Contact was added! ID: 9d5bf975-776c-4561-9505-247799356d81
    }

    @Test
    public void addNewContactNegativeTestWithoutName() {
        ContactDto dto1 = ContactDto.builder()
                .lastName("Kan")
                .email("kan@gm.com")
                .phone("1234567890")
                .address("Berlin")
                .description("goalkeeper")
                .build();

        ErrorDto errorDto = given()
                .header("Authorization", TOKEN)
                .body(dto1)
                .contentType(ContentType.JSON)
                .post("contacts")
                .then()
                .assertThat().statusCode(400)
                .extract().response().as(ErrorDto.class);
        //  System.out.println(errorDto.getMessage());
        Assert.assertTrue(errorDto.getMessage().toString().contains("name=must not be blank"));
    }
}
