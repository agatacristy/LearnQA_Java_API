import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class GetJsonHomeworkTest {
    @Test
    public void testGetJsonHomeworkTest(){
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        response.prettyPrint();
        System.out.println(response.get("messages[1].message").toString());
    }
}
