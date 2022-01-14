package qa.efremova.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static qa.efremova.tests.TestData.userEmail;

public class RegFormWithTestDataTests {

    String firstName = "Alex",
            lastName = "Ivanov";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest(){
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(".custom-control-label").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $("[aria-label$='July 30th, 2008']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("History").pressEnter();
        $x("//label[text()='Music']").click();
        $("#currentAddress").setValue("Tiraspol");
        File file = $("#uploadPicture").uploadFile(new File("src/test/java/resources/QA.jpg"));
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").click();



        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(text(firstName));
        $(".table-responsive").shouldHave(text(lastName));
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
