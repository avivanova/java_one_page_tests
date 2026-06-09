import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {
    @Test
    void successfulAutorizationTest() {
        open("https://qa-guru.github.io/one-page-form/login.html");
        $("#login-input").val("user1");
        $("#password-input").val("password1");
        $("#submit-button").click();
        $("#welcome-message").shouldHave(text("Welcome, user1!"));
        $("#logout-button").click();
    }

    @Test
    void successfulAutorizationByEnterTest() {
        open("https://qa-guru.github.io/one-page-form/login.html");
        $("#login-input").val("user1");
        $("#password-input").val("password1").pressEnter();
        $("#welcome-message").shouldHave(text("Welcome, user1!"));
        $("#logout-button").click();
    }

    @Test
    void wrongPasswordAutorizationTest() {
        open("https://qa-guru.github.io/one-page-form/login.html");
        $("#login-input").val("user1");
        $("#password-input").val("password");
        $("#submit-button").click();
        $("#error-message").shouldHave(text("Wrong login or password"));
    }

    @Test
    void emptyLoginAutorizationTest() {
        open("https://qa-guru.github.io/one-page-form/login.html");
        $("#password-input").val("password");
        $("#submit-button").click();
        $("#error-message").shouldHave(text("Login is required (minimum 3 characters)"));
    }

    @Test
    void emptyPasswordAutorizationTest() {
        open("https://qa-guru.github.io/one-page-form/login.html");
        $("#login-input").val("user1");
        $("#submit-button").click();
        $("#error-message").shouldHave(text("Password is required (minimum 6 characters)"));
    }

    @Test
    void emptyAutorizationTest() {
        open("https://qa-guru.github.io/one-page-form/login.html");
        $("#submit-button").click();
        $("#error-message").shouldHave(text("Login and password are required (minimum 3 and 6 characters)"));
    }

    @Test
    void shortLoginAutorizationTest() {
        open("https://qa-guru.github.io/one-page-form/login.html");
        $("#login-input").val("us");
        $("#password-input").val("password1");
        $("#submit-button").click();
        $("#error-message").shouldHave(text("Login must be at least 3 characters"));
    }

    @Test
    void shortPasswordAutorizationTest() {
        open("https://qa-guru.github.io/one-page-form/login.html");
        $("#login-input").val("user1");
        $("#password-input").val("pass");
        $("#submit-button").click();
        $("#error-message").shouldHave(text("Password must be at least 6 characters"));
    }
}
