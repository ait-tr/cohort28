package com.phonebook.tests;

import com.phonebook.dto.AllContactDto;
import com.phonebook.dto.ContactDto;
import com.phonebook.dto.ErrorDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetAllContactsTestRA extends TestBase{

    @Test
    public void getAllContactsPositiveTest() {
        AllContactDto allContactDto = given()
                .header("Authorization", TOKEN)
                .get("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllContactDto.class);

        for (ContactDto contact: allContactDto.getContacts()) {
            System.out.println(contact.getId() + "***" + contact.getName());
            System.out.println("========================================");
        }
    }

    @Test
    public void getAllContactNegativeTest() {
        given()
                .header("Authorization", "h9384oj")
                .when()
                .get("contacts")
                .then()
                .assertThat().statusCode(401)
                .assertThat().body("error",equalTo("Unauthorized"));
//        System.out.println(errorDto.getError());
//        System.out.println(errorDto.getMessage());
    }
}
