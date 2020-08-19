package autotests.github.tests;

import autotests.TestBase;
import autotests.base.steps.GithubWebSteps;
import autotests.shcherbakova.allure.Layer;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static autotests.helpers.Environment.*;

@Layer("web")
@Owner("shcherbakova")
@Feature("Authorization")
@Story("Authorization by the WEB")
public class WebAuthTests extends TestBase {
    private final GithubWebSteps steps = new GithubWebSteps();

    @Test
    @DisplayName("Positive test: Already registred user should be able to log in with CORRECT username/password")
    @Tags({@Tag("auth"), @Tag("github"), @Tag("web")})
    public void shouldLoginWithCorrectUsernamePassword() {
        steps.openPage(baseUrl);
        steps.clickSignIn();
        steps.inputUsernamePassword(usernameGithub, passwordGithub);
        steps.userShouldBeSigned(usernameGithub);
    }

    @Test
    @DisplayName("Negative test: User must NOT be able to log in with an INCORRECT password")
    @Tags({@Tag("auth"), @Tag("github"), @Tag("web")})
    public void shouldNotLoginWithIncorrectPassword() {
        steps.openPage(baseUrl);
        steps.clickSignIn();
        steps.inputUsernamePassword(usernameGithub, incorrectPasswordGithub);
        steps.userShouldNotBeSigned();
    }

    @Test
    @DisplayName("Negative test: User must NOT be able to log in with an INCORRECT username")
    @Tags({@Tag("auth"), @Tag("github"), @Tag("web")})
    public void shouldNotLoginWithIncorrectUsername() {
        steps.openPage(baseUrl);
        steps.clickSignIn();
        steps.inputUsernamePassword(incorrectUsernameGithub, passwordGithub);
        steps.userShouldNotBeSigned();
    }

    @Test
    @DisplayName("Negative test: User must NOT be able to log in with EMPTY username/password ")
    @Tags({@Tag("auth"), @Tag("github"), @Tag("web")})
    public void shouldNotLoginWithEmptyUsernamePassword() {
        steps.openPage(baseUrl);
        steps.clickSignIn();
        steps.inputUsernamePassword("","");
        steps.userShouldNotBeSigned();
    }

}
