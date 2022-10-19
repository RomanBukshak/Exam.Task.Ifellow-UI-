package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static PageObject.PageElements.CreatNewTaskElem.*;

public class CreatNewTaskSteps {

    @Step("Создать новую задачу")
    public static void creatNewTask() {
        issuesIcon.shouldBe(Condition.visible).click();
        creatNewTask.click();
        openInDialogBox.click();
    }

    @Step("Добавить описание задачи")
    public static void addTaskParameters() {
        typeTaskDropMenu.click();
        typeTaskError.sendKeys("Ошибка");
        creatThema.sendKeys("Test Task");
        textButton.click();
        textAreaDescription.sendKeys("Описание тестовой задачи");
        fixInVersionV2.click();
        priorityField.click();
        priorityField.sendKeys("High");
        textAreaEnvironment.sendKeys("Google Chrome v. 105.0.5195.127");
        appointMeButton.click();
        creatButton.click();
    }

    @Step("Проверить статус задачи")
    public static void checkStatusTask(){
        statusTask.shouldHave(Condition.text("Сделать"));
        Allure.addAttachment("Статус созданной задачи: ", statusTask.getText());
    }

    @Step("Перевести задачу в статус Готово")
    public static void statusTaskDone() {
        inWorkButton.click();
        statusTask.shouldHave(Condition.text("В работе"));
        Allure.addAttachment("Создана задача: ", idTask.getText());
        businessProcessButton.click();
        doneButton.click();
        statusTask.shouldHave(Condition.text("Готово"));
        Allure.addAttachment("Статус закрытой задачи: ", statusTask.getText());
    }

}
