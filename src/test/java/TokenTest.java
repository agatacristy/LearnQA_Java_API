import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class TokenTest {
    @Test
    public void tokenTest(){
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String token = response.get("token");
        int seconds = response.getInt("seconds")*1000;

        response = RestAssured
                .given()
                .queryParam("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String status = response.get("status");
        if (status.equals("Job is NOT ready")) {
            try {
                Thread.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            response = RestAssured
                    .given()
                    .queryParam("token", token)
                    .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                    .jsonPath();
            status = response.get("status");
            String result = response.get("result");

            if (status.equals("Job is ready") && (result != null)){
                System.out.println("Success test");
                System.out.println("result = " + result);
            }else{
                System.out.println("Incorrect result");
                System.out.println("status = " + status);
                System.out.println("result = " + result);
            }
        }else{
            System.out.println("Too long - Job has already been finished");
        }

    }
}
