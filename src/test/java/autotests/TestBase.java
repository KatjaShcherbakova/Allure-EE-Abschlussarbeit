package autotests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
        Configuration.timeout = 10000;
        Configuration.startMaximized =true;
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }



}
