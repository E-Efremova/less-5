package qa.efremova.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import qa.efremova.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage(){
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage typeLastName(String value){
       lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage checkResultValue(String key, String value){
        $(".table-responsive").shouldHave(text(key));
        $(".table-responsive").shouldHave(text(value));
        return this;}

}
