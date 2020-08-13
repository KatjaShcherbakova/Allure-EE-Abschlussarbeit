package autotests.base.steps;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;

import static io.restassured.RestAssured.given;

public class GithubApiSteps {

    @Step("Create issue with the specified title")
    public Issue  createIssue(String title) {

        Issue toCreate = new Issue();
        toCreate.setTitle(title);

        // @formatter:off
        return given()
                .filter(new AllureRestAssured())
                .header("Authorization","token 368e84595ea37d5a51b875a78a293cd9170dc123")
                .baseUri("https://api.github.com")
                .body(toCreate)
        .when()
                .post("repos/KatjaShcherbakova/Autotests-examples/issues")
        .then()
                .statusCode(201)
        .extract()
                .as(Issue.class);
        // @formatter:on
    }
}
