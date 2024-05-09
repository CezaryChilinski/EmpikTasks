import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GitHub_GET {
    private static final String BASE_URL = "https://api.github.com/users/";
    private static final String USERNAME = "octocat";

    private Response getRequest(String username) {
        return given().get(BASE_URL + username).thenReturn();
    }

    @Test
    void statusCodeShouldBe200() {
        getRequest(USERNAME).then().statusCode(200);
    }

    @Test
    void userLoginIsCorrect() {
        getRequest(USERNAME).then().body("login", equalTo(USERNAME));
    }

    @Test
    void userIdIsCorrect() {
        getRequest(USERNAME).then().body("id", equalTo(583231));
    }

    @Test
    void linksContainUserLogin() {
        getRequest(USERNAME).then()
                .body("url", containsString(USERNAME))
                .body("gists_url", containsString(USERNAME))
                .body("starred_url", containsString(USERNAME))
                .body("subscriptions_url", containsString(USERNAME))
                .body("organizations_url", containsString(USERNAME))
                .body("repos_url", containsString(USERNAME))
                .body("events_url", containsString(USERNAME))
                .body("received_events_url", containsString(USERNAME));
    }
}
