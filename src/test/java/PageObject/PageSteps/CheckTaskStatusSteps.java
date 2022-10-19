package PageObject.PageSteps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static PageObject.PageElements.TestProjectPageElem.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
public class CheckTaskStatusSteps {

    @Step("Поиск задачи {taskName}")
    public static void searchTask(String taskName) {
        taskList.shouldBe(visible).click();
        taskSearchInput.sendKeys(taskName);
        testSelenium_bug.shouldBe(visible).click();
    }

    @Step("Проверка статуса задачи")
    public static void checkStatus() {
        testSelenium_bugStatus.shouldBe(visible);
        Allure.addAttachment("Статус задачи: ", testSelenium_bugStatus.getText());
    }

    @Step("Проверка версии проекта")
    public static void checkVersion() {
        getTestSelenium_bugVersion.shouldBe(visible).shouldHave(text("Version 2.0"));
        Allure.addAttachment("Версия проекта: ", getTestSelenium_bugVersion.getText());
    }

}
