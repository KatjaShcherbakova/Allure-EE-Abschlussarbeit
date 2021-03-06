package autotests.github.tests;

import autotests.TestBase;
import autotests.shcherbakova.allure.Layer;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static autotests.helpers.Environment.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Layer("web")
@Owner("shcherbakova")
@Feature("ISSUE")
@Story("Displaying test steps in the report using the listener")
@Tags({@Tag("issue"), @Tag ("github"), @Tag("web")})
public class ListenerTest extends TestBase {

    @Test
    @DisplayName("Simple issue test with the listener ")
    public void IssueTestWithListener() {
       open(baseUrl);
       $(".header-search-input").click();
       $(".header-search-input").setValue(repository).submit();
       $(By.linkText(repository)).click();
       $("[data-tab-item='issues-tab']").click();
       $(withText("#" + correctIssueNumber)).shouldBe(visible);
   }
}
