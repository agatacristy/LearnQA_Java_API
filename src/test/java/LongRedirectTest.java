import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class LongRedirectTest {
    @Test
    public void longRedirectTest(){
        String locationHeader = "https://playground.learnqa.ru/api/long_redirect";
        int statusCode = 0;
        int i = 0;
        Response response;

        while (statusCode != 200) {
             response = RestAssured
                 .given()
                 .redirects()
                 .follow(false)
                 .when()
                 .get(locationHeader)
                 .andReturn();

             locationHeader = response.getHeader("Location");
             statusCode = response.getStatusCode();
             i = i+1;
         }

         System.out.println("Number of redirects = " + (i-1));
    }
}
