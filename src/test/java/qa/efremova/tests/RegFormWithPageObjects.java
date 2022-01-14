package qa.efremova.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.efremova.pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegFormWithPageObjects {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillFormTest(){

        registrationPage.openPage();
        registrationPage.typeFirstName("Alex");
        registrationPage.typeLastName("Ivanov");

        $("#userEmail").setValue("Test@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $x("//div[text()='14']").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $x("//label[text()='Music']").click();
        $("#currentAddress").setValue("Tiraspol");
        File file = $("#uploadPicture").uploadFile(new File("src/test/java/resources/QA.jpg"));
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").click();



        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Alex"));
        $(".table-responsive").shouldHave(text("Ivanov"));
        $(".table-responsive").shouldHave(text("Test@mail.ru"));
        $(".table-responsive").shouldHave(text("0123456789"));
        $(".table-responsive").shouldHave(text("14 March,1995"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("Tiraspol"));
        $(".table-responsive").shouldHave(text("QA.jpg"));
        $(".table-responsive").shouldHave(text("NCR Gurgaon"));


    }

    @Test
    void fillFormWithDslTest(){

        registrationPage.openPage()
                        .typeFirstName("Alex").typeFirstName("Ivanov");

        $("#userEmail").setValue("Test@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("0123456789");

        registrationPage.calendarComponent.setDate("30", "July", "2008");

        $("#subjectsInput").setValue("History").pressEnter();
        $x("//label[text()='Music']").click();
        $("#currentAddress").setValue("Tiraspol");
        File file = $("#uploadPicture").uploadFile(new File("src/test/java/resources/QA.jpg"));
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").click();



        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Alex"));
        $(".table-responsive").shouldHave(text("Ivanov"));
        $(".table-responsive").shouldHave(text("Test@mail.ru"));
        $(".table-responsive").shouldHave(text("0123456789"));
        $(".table-responsive").shouldHave(text("14 March,1995"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("Tiraspol"));
        $(".table-responsive").shouldHave(text("QA.jpg"));
        $(".table-responsive").shouldHave(text("NCR Gurgaon"));


    }

}

