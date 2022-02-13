package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AutomationPracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));


        $("#firstName").setValue("Mick");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@company.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("89995554411");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(3);
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFile(new File("test.jpg")); //не уверен, что так правильно, добавил jgp в папке, где с проектом и оттуда беру файл
        $("#currentAddress").setValue("some address");
        $("#state").scrollTo().click();
        $("#state").$(byText("Rajasthan")).click();
        $("#city").scrollTo().click();
        $("#city").$(byText("Jaiselmer")).click();
        $("#submit").click();
    }
}