package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTest {

    @Disabled
    @DisplayName("Проверка 3 > 2")
    @Test
    void firstTest(){
        assertTrue(3 > 2);
    }

    @DisplayName("Проверка 3 > 1")
    @Test
    void secondTest(){
        assertTrue(3 > 1);
    }
}
