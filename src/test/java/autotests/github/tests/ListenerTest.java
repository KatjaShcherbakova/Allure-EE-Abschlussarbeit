package autotests.github.tests;

import autotests.TestBase;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static autotests.helpers.Environment.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Feature("Listener")
@Tag("issue")
@Tag ("github")
public class ListenerTest extends TestBase {

    @Test
    @DisplayName("Issue test without steps but with Listener ")
    public void IssueTestWithListener() {
       open(baseUrl);
       $(".header-search-input").click();
       $(".header-search-input").setValue(repository).submit();
       $(By.linkText(repository)).click();
       $("[data-tab-item='issues-tab']").click();
       $(withText("#" + correctIssueNumber)).shouldBe(visible);
   }
}
