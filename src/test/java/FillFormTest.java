import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class FillFormTest extends TestBase {

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Tom");
        $("#lastName").setValue("Wambsgans");
        $("#userEmail").setValue("TomWambsgans@RoyCo.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1685456485");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("207.png");
        $("#currentAddress").setValue("1654 West Virginia, Charlston, LittleRock Street, 25");
        $("#state").click();
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Delhi").pressEnter();
        $("#submit").pressEnter();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Tom Wambsgans"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("TomWambsgans@RoyCo.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1685456485"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("19 November,1991"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("207.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("1654 West Virginia, Charlston, LittleRock Street, 25"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}
