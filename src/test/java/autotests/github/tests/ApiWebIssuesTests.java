package autotests.github.tests;

import autotests.TestBase;
import autotests.base.steps.GithubApiSteps;
import autotests.base.steps.GithubWebSteps;
import autotests.base.steps.Issue;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static autotests.helpers.Environment.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

@Owner("shcherbakova")
@Feature("Creation issue by API")
@Tag("issue")
@Tag("github")
@Tag ("api")
@Tag("web")
public class ApiWebIssuesTests extends TestBase {
    private final GithubWebSteps webSteps = new GithubWebSteps();
    private final GithubApiSteps apiSteps = new GithubApiSteps();

    @Test
    @DisplayName("Positive test: The issue is created by API, the user must find it by NUMBER by Web")
    public void createIssueByApiAndCheckNumberByWeb() {
        final Issue createdIssue = apiSteps.createIssueWithTitle("test111111111");

        webSteps.openPage(baseUrl);
        webSteps.searchForRepositiry(repository);
        webSteps.clickLinkOfRepository(repository);
        webSteps.openIssuePage();
        webSteps.issueNumberShouldExist(createdIssue.getNumber());
    }

    @Test
    @DisplayName("Positive test: The issue is created by API, the user must find it by NAME by Web")
    public void createIssueByApiAndCheckNameByWeb() {
        final Issue createdIssue = apiSteps.createIssueWithTitle("test2222");

        webSteps.openPage(baseUrl);
        webSteps.searchForRepositiry(repository);
        webSteps.clickLinkOfRepository(repository);
        webSteps.openIssuePage();
        webSteps.issueNameShouldExist(createdIssue.getTitle());
    }
}
