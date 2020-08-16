package autotests.github.tests;

import autotests.TestBase;
import autotests.base.steps.GithubWebSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static autotests.helpers.Environment.*;

@Owner("shcherbakova")
@Feature("Authorization by UI")
@Tag("auth")
@Tag("github")
@Tag("web")
public class WebAuthTests extends TestBase {

    private final GithubWebSteps steps = new GithubWebSteps();

    @Test
    @DisplayName("Positive test: Already registred user should be able to login with CORRECT username/password")
    public void shouldLoginWithCorrectUsernamePassword() {
        steps.openPage(baseUrl);
        steps.clickSignIn();
        steps.inputUsernamePassword(usernameGithub, passwordGithub);
        steps.userShouldBeSigned(usernameGithub);
    }

    @Test
    @DisplayName("Negative test: User must NOT be able to login with an INCORRECT password")
    public void shouldNotLoginWithIncorrectPassword() {
        steps.openPage(baseUrl);
        steps.clickSignIn();
        steps.inputUsernamePassword(usernameGithub, incorrectPasswordGithub);
        steps.userShouldNotBeSigned();
    }

    @Test
    @DisplayName("Negative test: User must NOT be able to login with an INCORRECT username")
    public void shouldNotLoginWithIncorrectUsername() {
        steps.openPage(baseUrl);
        steps.clickSignIn();
        steps.inputUsernamePassword(incorrectUsernameGithub, passwordGithub);
        steps.userShouldNotBeSigned();
    }

    @Test
    @DisplayName("Negative test: User must NOT be able to log in with EMPTY username/password ")
    public void shouldNotLoginWithEmptyUsernamePassword() {
        steps.openPage(baseUrl);
        steps.clickSignIn();
        steps.inputUsernamePassword("","");
        steps.userShouldNotBeSigned();
    }

}
