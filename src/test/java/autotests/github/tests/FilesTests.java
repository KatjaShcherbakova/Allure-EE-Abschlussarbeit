package autotests.github.tests;

import autotests.TestBase;
import autotests.base.steps.GithubWebSteps;
import autotests.shcherbakova.allure.Layer;
import com.codeborne.pdftest.PDF;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static autotests.helpers.Environment.fileUrl;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;

@Layer("web")
@Owner("shcherbakova")
@Feature("Work with files")
@Story("Download a file and check an expected text in it")
@Tags({@Tag("github"), @Tag("file"), @Tag("web") })
public class FilesTests extends TestBase {

    private final GithubWebSteps steps = new GithubWebSteps();
    private final String expectedFileText = "How GitHub secures open source software";

    @Test
    @DisplayName("Positive test: download the PDF file and search for an expected text in it")
    public void filePDFShouldContainExpectedText() throws IOException {
        parameter("EXPECTED TEXT: ",expectedFileText);


        steps.openPage(fileUrl);

        step("Download PDF file and check that the downloaded file contains the expected text", () -> {
            File downloadedFile =  $("[href='/downloads/How-GitHub-secures-open-source-software.pdf']").download();
            PDF downloadedFileText = new PDF(downloadedFile);

            steps.checkPdfFileContansExpectedText(downloadedFileText,expectedFileText);
        });

    }
}
