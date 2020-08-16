package autotests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static autotests.helpers.DriverHelper.*;
import static autotests.helpers.Environment.isVideoOn;
import static helpers.AttachmentsHelper.*;
import static helpers.AttachmentsHelper.attachVideo;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        configureSelenide();
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void afterEach(){
        String sessionId = getSessionId();
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        WebDriverRunner.closeWebDriver();
        if (isVideoOn) attachVideo(sessionId);
    }



}
