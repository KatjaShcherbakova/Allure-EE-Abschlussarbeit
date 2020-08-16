package autotests.base.steps;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;

import static autotests.helpers.Environment.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GithubApiSteps {

    @Step("Create issue with the specified title")
    public Issue createIssueWithTitle(String title) {
        final Issue toCreate = new Issue();

        toCreate.setTitle(title);

        // @formatter:off
        return given()
                .filter(new AllureRestAssured())
                .header("Authorization","token " +tokenGithub )
                .baseUri(baseApiUrl)
                .body(toCreate)
        .when()
                .post("/repos/" + repository + "/issues")
        .then()
                .statusCode(201)
        .extract()
                .as(Issue.class);
        // @formatter:on
    }
}
