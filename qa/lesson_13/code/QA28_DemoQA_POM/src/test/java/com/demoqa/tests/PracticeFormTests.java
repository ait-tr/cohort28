package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIframes();
    }

    @Test
    public void registerNewStudentTest() {
        new PracticeFormPage(driver).enterPersonalData("Jack","Sparrow",
                        "jak@gm.com","1234567890")
                .selectGender("Male")
                .enterDate("16 Aug 1987")
                .selectSubjects(new String[]{"Maths","English","Chemistry"})
                .selectHobbies(new String[]{"Sports","Music"})
                .uploadFile("C:/Tools/1.jpg")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();
    }

    @Test
    public void registerNewStudentWithChooseDateTest() {
        new PracticeFormPage(driver).enterPersonalData("Jack","Sparrow",
                        "jak@gm.com","1234567890")
                .selectGender("Male")
                .chooseDate("August", "1987","16")
                .selectSubjects(new String[]{"Maths","English","Chemistry"})
                .selectHobbies(new String[]{"Sports","Music"})
                .uploadFile("C:/Tools/1.jpg")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();
    }
}
