package autotests.github.tests;

import autotests.TestBase;
import autotests.base.steps.GithubApiSteps;
import autotests.base.steps.GithubWebSteps;
import autotests.base.steps.Issue;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static autotests.helpers.Environment.*;

@Feature("Creation by API")
@Tag("issue")
public class ApiAndWeb extends TestBase {

    private final GithubWebSteps webSteps = new GithubWebSteps();

    private final GithubApiSteps apiSteps = new GithubApiSteps();

    @Test
    @DisplayName("The issue is created by API, user must find it by number via Web")
    public void createIssueByApiAndCheckNumber() {

       final Issue createdIssue = apiSteps.createIssue("Hallo_2");

        webSteps.openMainPage(baseUrl);
        webSteps.searchForRepositiry(repository);
        webSteps.clickLinkOfRepository(repository);
        webSteps.openIssuePage();
        webSteps.checkExistenceOfIssueNumber(createdIssue.getNumber());
    }

    @Test
    @DisplayName("The issue is created by API, user must find it by name via Web")
    public void createIssueByApiAndCheckName() {

        final Issue createdIssue = apiSteps.createIssue("Hallo_2");

        webSteps.openMainPage(baseUrl);
        webSteps.searchForRepositiry(repository);
        webSteps.clickLinkOfRepository(repository);
        webSteps.openIssuePage();
        webSteps.checkExistenceOfIssueName(createdIssue.getTitle());
    }

}
