import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HomeworkHeaderTest {
    @Test
    public void homeworkHeaderTest(){
        Response response = RestAssured
                .post("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        assertNotNull(response.getHeaders(), "Headers are absent");
        assertEquals("Some secret value", response.getHeader("x-secret-homework-header"), "HomeWork header contains incorrect value");
    }
}
