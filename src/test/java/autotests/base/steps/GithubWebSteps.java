package autotests.base.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static autotests.helpers.Environment.baseUrl;
import static io.qameta.allure.Allure.link;
import static io.qameta.allure.Allure.parameter;

public class GithubWebSteps {

    @Step("Open main page")
    public void openPage(String url) {
        link("Github",url);

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
        link("Github/repositiry",String.format("%s/%s", baseUrl, repository_name));
        parameter("REPOSITORY: ", repository_name);

        $(By.linkText(repository_name)).click();
    }

    @Step("Open page with issues")
    public void openIssuePage() {

        $("[data-tab-item='issues-tab']").click();
    }

    @Step("Check for a issue with a specific NUMBER does NOT exists")
    public void issueNumberShouldNotExist(int issue_number) {
        parameter("ISSUE: ", issue_number);

        $(withText("#" + issue_number)).shouldNotBe(visible);
    }

    @Step("Check for a issue with a specific NUMBER exists")
    public void issueNumberShouldExist(int issue_number) {
        parameter("ISSUE: ", issue_number);

        $(withText("#" + issue_number)).shouldBe(visible);
    }

    @Step("Check for a issue with a specific NAME exists")
    public void issueNameShouldExist(String issue_name) {
        parameter("NAME OF ISSUE: ", issue_name);

        $(withText(issue_name)).shouldBe(visible);
    }

    @Step("Check for a issue with a specific NAME does NOT exist")
    public void issueNameShouldNotExist(String issue_name) {
        parameter("NAME OF ISSUE: ", issue_name);

        $(withText(issue_name)).shouldNotBe(visible);
    }
//todo
//    @Step("Check for a issue with a specific parameters exists")
//    public void issueWithParametersShouldExist(String issue_name, String issue_assign, String issue_label) {

    @Step("Click in the upper right corner on <Sign in>")
    public void clickSignIn() {
        $(byText("Sign in")).click();
    }

    @Step("Fill the login form")
    public void inputUsernamePassword(String username, String password) {
        parameter("USERNAME: ", username);
        parameter("PASSWORD: ", password);

        $(byName("login")).setValue(username);
        $(byName("password")).setValue(password).pressEnter();
    }

     @Step("Check that user is signed in")
     public void userShouldBeSigned(String username) {
        parameter("USERNAME: ", username);

        $(by("title","KatjaTest")).shouldBe(visible);
    }

    @Step("Check that user ISN`T signed in")
    public void userShouldNotBeSigned() {
        $(byText("Incorrect username or password.")).shouldBe(visible);

    }

    @Step("Creation an issue with a title")
    public void createIssue(String issue_name) {
        $("a.btn-primary",1).click();
        $("input[name='issue[title]']").setValue(issue_name);
        $("#new_issue").submit();
    }

}