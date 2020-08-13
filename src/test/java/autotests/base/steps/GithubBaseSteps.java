package autotests.base.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static autotests.helpers.Environment.baseUrl;
import static io.qameta.allure.Allure.link;
import static io.qameta.allure.Allure.parameter;

public class GithubBaseSteps {

    @Step("Open main page")
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Search for a repository")
    public void searchForRepositiry(String repository_name) {
        parameter("REPOSITORY: ", repository_name);

        $(".header-search-input").click();
        $(".header-search-input").setValue(repository_name).submit();
    }

    @Step("Click on link of repository")
    public void clickLinkOfRepository(String repository_name) {
        link("Github",String.format("%s/%s", baseUrl, repository_name));
        parameter("REPOSITORY: ", repository_name);

        $(By.linkText(repository_name)).click();
    }

    @Step("Open page with issues")
    public void openIssuePage() {

        $("[data-tab-item='issues-tab']").click();
    }

    @Step("Check for a issue with a specific number exists")
    public void checkExistenceOfIssue (int issue) {
        parameter("ISSUE: ", issue);

        $(withText("#" + issue)).shouldNotBe(visible);
    }

    @Step("Check for a issue with a specific number does not exists")
    public void checkUnexistenceOfIssue (int issue) {
        parameter("ISSUE: ", issue);

        $(withText("#" + issue)).shouldNotBe(visible);
    }
}
