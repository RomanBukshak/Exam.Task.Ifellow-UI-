package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static PageObject.PageElements.AuthorizationPageElem.*;
import static PageObject.PageElements.LoggedPageElem.projectTest;
import static PageObject.PageElements.LoggedPageElem.projectsDropButton;
import static PageObject.PageElements.TestProjectPageElem.imgTest;
public class OpenProjectTestSteps {

    @Step("Авторизоваться в системе {login}:{password}")
    public static void authorization(String login,String password) {
        loginLane.shouldBe(Condition.visible).click();
        loginLane.sendKeys(login);
        passwordLane.click();
        passwordLane.sendKeys(password);
        loginButton.click();
    }

    @Step("Выбрать проект")
    public static void openProjectTest() {
        projectsDropButton.shouldBe(Condition.visible).click();
        projectTest.click();
    }

    @Step("Проверить что выбрался нужный проект")
    public static void checkProjectTest() {
        imgTest.shouldBe(Condition.visible).shouldHave(Condition.attribute("alt", "Test"));
    }

}
