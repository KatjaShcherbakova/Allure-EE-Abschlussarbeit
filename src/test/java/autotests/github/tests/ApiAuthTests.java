package autotests.github.tests;

import autotests.TestBase;
import autotests.shcherbakova.allure.Layer;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static autotests.helpers.Environment.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Layer("api")
@Owner("shcherbakova")
@Feature("Authorization")
@Story("Authorization on Githab by the API")
public class ApiAuthTests {

   // @formatter:off
   @Test
   @DisplayName("Authorization on Githab by the API using Username&Password and check the login in a response")  //  Password authentication to the API will be removed on November 13, 2020.
   @Tags({@Tag("api"), @Tag("github"), @Tag("auth")})
   void authGithubByUsernamePassword () {
       String login =  given()
                .filter(new AllureRestAssured())
                .auth().preemptive().basic(usernameGithub, passwordGithub)
                .baseUri(baseApiUrl)
        .when()
                .get("/user")
        .then()
                .statusCode(200)
        .extract()
                .path("login");

    step("Check that login in the response is correct", () -> {
        assertThat(login, is(usernameGithub));
    });
   }

   @Test
   @DisplayName("Authorization on Githab by the API using token and check the id in a response")
   @Tags({@Tag("api"), @Tag("github"), @Tag("auth")})
   void authGithubByToken () {
      Integer id = given()
              .filter(new AllureRestAssured())
              .header("Authorization","token " + tokenGithub)
              .baseUri(baseApiUrl)
        .when()
              .get("/user")
        .then()
              .statusCode(200)
        .extract()
              .path("id");
      step("Check that id in the response is correct", () -> {
          assertThat(id,is(69079947));
      });
   }
   // @formatter:on
}

