package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWebTest {

    @BeforeEach
    void setup() {
        open("https://ru.selenide.org/");
    }

    static Stream<Arguments> selenideButtonsTest(){
        return Stream.of(
                Arguments.of("RU", List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы")),
                Arguments.of("EN", List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка наличия кнопок из списка {1} в локале {0}")
    @Tag("BLOCKER")
    void selenideButtonsTest(String locale, List<String> buttons){
        $$("#languages a").find(text(locale)).click();
        $$(".main-menu-pages a").filter(visible).
                shouldHave(CollectionCondition.texts(buttons));
    }

}
