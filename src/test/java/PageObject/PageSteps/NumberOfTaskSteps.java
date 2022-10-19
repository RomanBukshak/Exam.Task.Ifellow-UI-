package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static PageObject.PageElements.TestProjectPageElem.*;
public class NumberOfTaskSteps {

    @Step ("Проверить общее количество задач")
    public static void numberOfTask() {
        taskList.shouldBe(Condition.visible).click();
        String str = numberOfTaskList.getText();
        String[] subStr;
        String delimiter = " ";
        subStr = str.split(delimiter);
        Allure.addAttachment("Общее количество задач: ", subStr[0]);
    }

}
