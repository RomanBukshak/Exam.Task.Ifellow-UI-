package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static PageObject.PageElements.AuthorizationPageElem.*;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationSteps {
    @Step("открыть сайт {Url}")
    public static void openUrl(String Url) {
        open(Url);
    }

    @Step("Ввести логин {login}")
    public static void loginValue(String login) {
        loginLane.shouldBe(Condition.visible).click();
        loginLane.sendKeys(login);
        passwordLane.click();
    }

    @Step("Ввести пароль {password}")
    public static void passwordValue(String password) {
        passwordLane.sendKeys(password);
    }

    @Step("Нажать кнопку")
    public static void clickLoginButton() {
        loginButton.click();
    }

    @Step("Проверить что авторизация прошла успешно")
    public static void checkWelcomeJira() {
        welcomeJira.shouldBe(Condition.visible);
    }

}
