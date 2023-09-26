import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortStringTest {
    @ParameterizedTest
    @ValueSource(strings = {"First, I wake up. Then, I get dressed. I walk to school. I do not ride a bike. I do not ride the bus. I like to go to school. It rains. I do not like rain. I eat lunch. I eat a sandwich and an apple.",
    "Less then 15sym"})
    public void shortStringTest(String str){
        assertTrue(str.length() > 15, "Length of the string '" + str + "' < or = 15 symbols");
    }
}
