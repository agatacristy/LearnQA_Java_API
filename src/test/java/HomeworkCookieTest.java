import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeworkCookieTest {
    @Test
    public void homeworkCookieTest(){
       Response response = RestAssured
                .post("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();
        assertNotNull(response.getCookies(), "Cookies are absent");
        assertEquals("hw_value", response.getCookie("HomeWork"), "HomeWork cookie contains incorrect value");

    }
}
