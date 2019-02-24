import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.*;

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

    /**
     * Сравнение активной ссылки с ожидаемой
     */
    public void  assertCurrentLinkEqualsExpected (String expectedLink) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(),5);
        wait.until(ExpectedConditions.urlToBe(expectedLink));
        String url = url();

        if (!url.equals(expectedLink)){
            throw new AssertionError(String.format("Текущая ссылка %s не равна ожидаемой %s", url, expectedLink));
        }
    }

    /**
     * Метод  нажатия кнопки "Выход" со страницы пользователя
     */
    public void clickExitfromUserPage (SelenideElement element) {
        if ($(element).is(exist)){
            $(byText("Нет, спасибо")).click();
            checkEntityExists("Выход");
            $(byText("Выход")).click();
        }
        else {
            checkEntityExists("Выход");
            $(byText("Выход")).click();
        }
    }

    /**
     * Метод авторизации, получает логин пароль и кликает "Войти"
     * @param login - логин
     * @param password - пароль
     */
    public void authtorazation (String login, String password) {
        fieldLogin().val(login);
        fieldPassword().val(password);
        getloginButtonOnAuthPage().click();
    }

    /**
     * Проверка, что в блоке пользователя на странице пользовтеля находится ожидаемое имя
     * @param expectedUser - ожидаемое имя пользователя
     */
    public void checkUserLoginExistsOnUserPage (String expectedUser) {
        getUserloginOnPage().shouldBe(visible).shouldHave(text(expectedUser));
    }
}
