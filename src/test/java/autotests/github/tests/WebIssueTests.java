package autotests.github.tests;

import autotests.TestBase;
import autotests.base.steps.GithubWebSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static autotests.helpers.Environment.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.*;

@Owner("shcherbakova")
@Feature("Work with issues by WEB")
@Tag("github")
@Tag("issue")
@Tag("web")
public class WebIssueTests extends TestBase {
    private final GithubWebSteps steps = new GithubWebSteps();


    @Test
    @DisplayName("Positive test, user should be able to find issue by a specific number")
    public void shouldFindIssueByNumber() {

        parameter("REPOSITIRY: ", repository);
        parameter("ISSUE: ", correctIssueNumber);
        link("Github",String.format("%s/%s",baseUrl,repository));

        step("Open base page", () -> {
            open(baseUrl);
        });
        step("Search for a repository:" + repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(repository).submit();
        });
        step("Click on link of repository", () -> {
            $(By.linkText(repository)).click();
        });
        step("Open page with issues", () -> {
            $("[data-tab-item='issues-tab']").click();

        });
        step("Check that an issue with a specific number exists", () -> {
            $(withText("#" + correctIssueNumber)).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Negative test, user should not be able to find issue by uncorrect number")
    public void shouldNotFindIssueByNumber() {

        steps.openPage(baseUrl);
        steps.searchForRepositiry(repository);
        steps.clickLinkOfRepository(repository);
        steps.openIssuePage();
        steps.issueNumberShouldNotExist(incorrectIssueNumber);
    }

    @Test
    @DisplayName("Positive test: Creat a issue by WEB")
    public void creatIssuebyWeb() {
        String issue_title = "Test issue";

        steps.openPage(baseUrl);
        steps.clickSignIn();
        steps.inputUsernamePassword(usernameGithub, passwordGithub);
        steps.clickLinkOfRepository(repository);
        steps.openIssuePage();
        steps.createIssue(issue_title);
        steps.openIssuePage();
        steps.issueNameShouldExist(issue_title);
    }

}
