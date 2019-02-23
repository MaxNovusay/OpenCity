import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

// Класс описывает методы для тестов страниц

public class Pages extends Elements {

    /**
     * Проверяет нажатие на кнопку(ссылку) меню, после загрузки страницы - проверяет заголовок, если он был передан,
     * @param link  - название ссылки
     * @param expectedHeader - ожидаемый заголовок
     */
    public void checkPageLoad (String link, String expectedHeader) {
        $(byText(link)).click();
        if (expectedHeader == null) {

        }
        else {
            $("h1").shouldBe(visible).shouldHave(text(expectedHeader));
        }
    }

    /**
     * Проверка существует ли элемент на странице
     * @param element - передаем элемент объект класса SenelideElement
     */
    public void checkEntityExists (SelenideElement element) {
        element.shouldBe(exist);
    }

    /**
     * Проверка существует ли элемент на странице
     * @param element - передаем ожидаемый текст элемента
     */
    public void checkEntityExists (String element) {
        $(byText(element)).shouldBe(exist);
    }
}
