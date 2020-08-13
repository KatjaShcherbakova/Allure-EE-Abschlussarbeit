package autotests.github.tests;

import autotests.TestBase;
import autotests.base.steps.GithubBaseSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static autotests.helpers.Environment.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;

@Owner("shcherbakova")
@Feature("ISSUE")
@Tag("issue")
public class IssueTests extends TestBase {

    private final GithubBaseSteps steps = new GithubBaseSteps();
    private static final int issueNumber = 1;

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

        steps.openMainPage(baseUrl);
        steps.searchForRepositiry(repository);
        steps.clickLinkOfRepository(repository);
        steps.openIssuePage();
        steps.checkExistenceOfIssue(incorrecIssueNumber);
    }
}
