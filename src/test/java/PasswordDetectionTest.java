import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;

public class PasswordDetectionTest {
    @Test
    public void passwordDetectionTest(){
        String login = "super_admin";
        String[] passwords = new String[]{"password",
                "123456",
                "123456789",
                "12345678",
                "12345",
                "qwerty",
                "abc123",
                "football",
                "1234567",
                "monkey",
                "111111",
                "letmein",
                "1234",
                "1234567890",
                "dragon",
                "baseball",
                "sunshine",
                "iloveyou",
                "trustno1",
                "princess",
                "adobe123",
                "123123",
                "welcome",
                "login",
                "admin",
                "welcome",
                "qwerty123",
                "solo",
                "1q2w3e4r",
                "666666",
                "master",
                "photoshop",
                "1qaz2wsx",
                "qwertyuiop",
                "ashley",
                "mustang",
                "121212",
                "starwars",
                "654321",
                "bailey",
                "access",
                "flower",
                "555555",
                "passw0rd",
                "shadow",
                "lovely",
                "654321",
                "7777777",
                "michael",
                "!@#$%^&*",
                "jesus",
                "password1",
                "superman",
                "master",
                "hello",
                "charlie",
                "888888",
                "michael",
                "696969",
                "hottie",
                "freedom",
                "aa123456",
                "qazwsx",
                "ninja",
                "azerty",
                "solo",
                "loveme",
                "whatever",
                "donald",
                "trustno1",
                "batman",
                "zaq1zaq1",
                "qazwsx",
                "Football",
                "000000",
                "starwars",
                "123qwe"
        };
        String responseCookie;
        String text;
        int i = 0;
        Response responseGetPassword;
        XmlPath responseForCheck;
        Map<String,String> body = new HashMap<>();
        body.put("login", login);
        Map<String, String> cookies = new HashMap<>();

        while ( i < passwords.length) {

            body.put("password", passwords[i]);
            responseGetPassword = RestAssured
                    .given()
                    .body(body)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();
            responseCookie = responseGetPassword.getCookie("auth_cookie");

            cookies.put("auth_cookie", responseCookie);
            responseForCheck = RestAssured
                    .given()
                    .cookies(cookies)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                    .htmlPath();
            text = responseForCheck.getString("html.body");

            if (text.equals("You are NOT authorized")){
                i = i+1;
            }else{
                System.out.println("Correct password = " + passwords[i]);
                i = passwords.length + 1;
            }
        }
    }
}
