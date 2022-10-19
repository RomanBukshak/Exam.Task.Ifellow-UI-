import Hooks.WebHooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static PageObject.PageSteps.AuthorizationSteps.*;
import static PageObject.PageSteps.CheckTaskStatusSteps.*;
import static PageObject.PageSteps.CreatNewTaskSteps.*;
import static PageObject.PageSteps.NumberOfTaskSteps.numberOfTask;
import static PageObject.PageSteps.OpenProjectTestSteps.*;
import static utils.Configuration.getConfigurationValue;


public class JiraTest extends WebHooks {

    @Test
    @Tag("TK_01")
    @DisplayName("Проверка авторизации на сайте")
    public void Test_1() {
        openUrl(getConfigurationValue("jiraUrl"));
        loginValue(getConfigurationValue("login"));
        passwordValue(getConfigurationValue("password"));
        clickLoginButton();
        checkWelcomeJira();
    }

    @Test
    @Tag("TK_02")
    @DisplayName("Проверка открытия проекта")
    public void Test_2() {
        openUrl(getConfigurationValue("jiraUrl"));
        authorization(getConfigurationValue("login"), getConfigurationValue("password"));
        openProjectTest();
        checkProjectTest();
    }

    @Test
    @Tag("TK_03")
    @DisplayName("Проверка общего количества задач")
    public void Test_3(){
        openUrl(getConfigurationValue("jiraUrl"));
        authorization(getConfigurationValue("login"), getConfigurationValue("password"));
        openProjectTest();
        numberOfTask();
    }

    @Test
    @Tag("TK_04")
    @DisplayName("Проверка статуса и версии задачи")
    public void Test_4(){
        openUrl(getConfigurationValue("jiraUrl"));
        authorization(getConfigurationValue("login"), getConfigurationValue("password"));
        openProjectTest();
        searchTask(getConfigurationValue("taskName"));
        checkStatus();
        checkVersion();
    }

    @Test
    @Tag("TK_05")
    @DisplayName("Проверка создания и закрытия задачи")
    public void Test_5() {
        openUrl(getConfigurationValue("jiraUrl"));
        authorization(getConfigurationValue("login"), getConfigurationValue("password"));
        openProjectTest();
        creatNewTask();
        addTaskParameters();
        checkStatusTask();
        statusTaskDone();
    }

}
