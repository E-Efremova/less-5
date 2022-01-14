package qa.efremova.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CalendarComponent {
    public void setDate(String day, String moth, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(moth);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(year);

        String dayLocator = format("[arial-label$= %s %sth, %s]", moth, day, year);
        $(dayLocator).click();

    }

}
