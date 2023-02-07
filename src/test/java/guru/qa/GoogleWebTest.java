package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleWebTest {

    @BeforeEach
    void setup() {
        open("https://google.com");
    }

    @CsvSource({
            "selenide, https://ru.selenide.org",
            "junit 5, https://junit.org"
    })
    @ParameterizedTest (name = "Проверка урла {0} в поиске по запросу {1}")
    @Tags({@Tag("BLOCKER"), @Tag("FEATURE")})
    void googleSearchTest(String searchQuery, String expectedUrl) {
        $("[name=q]").setValue(searchQuery).pressEnter();
        $("[id=search]").shouldHave(text(expectedUrl));

    }



}
