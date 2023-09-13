import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class RedirectTest {
    @Test
    public void redirectTest() {
        String locationHeader = "https://playground.learnqa.ru/api/long_redirect";
        String finalLocation = "";
        int statusCode = 0;
        Response response;

        while (locationHeader != null) {
            response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(locationHeader)
                    .andReturn();

            finalLocation = locationHeader;
            locationHeader = response.getHeader("Location");
        }
        System.out.println("Final location = " + finalLocation);
    }
}
