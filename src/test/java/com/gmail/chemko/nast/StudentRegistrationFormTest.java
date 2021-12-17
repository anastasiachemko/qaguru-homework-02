package com.gmail.chemko.nast;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");

        $("firstName").setValue("Anastasia");
        $("#lastName").setValue("Chemko");
        $("#userEmail").setValue("nast.chemko@gmail.com");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("1117508498");
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#currentAddress").setValue("Minsk");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#firstName").shouldHave(text("Anastasia"));
        $("#lastName").shouldHave(text("Chemko"));
        $("#userEmail").shouldHave(text("nast.chemko@gmail.com"));
        $("#gender").shouldHave(text("Female"));
        $("#userNumber").shouldHave(text("1117508498"));
        $("#subjects").shouldHave(text("English"));
        $("#hobbies").shouldHave(text("Sports"));
        $("#currentAddress").shouldHave(text("Minsk"));
    }
}