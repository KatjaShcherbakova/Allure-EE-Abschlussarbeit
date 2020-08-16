package autotests.github.tests;

import autotests.TestBase;
import autotests.base.steps.GithubWebSteps;
import com.codeborne.pdftest.PDF;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static autotests.helpers.Environment.fileUrl;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;

@Owner("shcherbakova")
@Feature("Work with files")
@Tag("github")
@Tag("file")
@Tag("web")
public class FilesTests extends TestBase {

    private final GithubWebSteps steps = new GithubWebSteps();
    private final String expectedFileText = "How GitHub secures open source software";


    @Test
    @DisplayName("Positive test: download the PDF file and search for an expected text in it")
    public void filePDFShouldContainExpectedText() throws IOException {
        steps.openPage(fileUrl);

        step("Download PDF file and check that the downloaded file contains the expected text", () -> {
            File downloadedFile =  $("[href='/downloads/How-GitHub-secures-open-source-software.pdf']").download();
            PDF downloadedFileText = new PDF(downloadedFile);

            assertThat(downloadedFileText,PDF.containsText(expectedFileText));
        });

    }
}
