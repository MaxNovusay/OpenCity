import com.codeborne.selenide.Selenide;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;


// Тест проверки авторизации


public class OpenCityAuthTest extends Pages {

    private String notifyMessage = " \n" +
            "Ошибка входа в личный кабинет\n" +
            "Неправильные логин и/или пароль," +
            " проверьте свои данные. Если Вы в первый раз на данном сайте - зарегистрируйтесь." +
            " Также, попробуйте восстановить доступ к своей учетной записи";

    @Test
    public void test() {
        Selenide.open("https://open.kzn.ru/");

        loginButton().click();
        authtorazation("hdgs@mail.ru", "a1010f");
        checkPageLoad("Главная", "Главная");
        checkUserLoginExistsOnUserPage("hdgs@mail.ru");
        assertCurrentLinkEqualsExpected("https://open.kzn.ru/cabinet/");

        clickExitfromUserPage(popupMessageOnUserPage());
        assertCurrentLinkEqualsExpected("https://open.kzn.ru/");
        loginButton().click();
        authtorazation("hdgs@mail.r", "a1010f");

        checkEntityExists(notifyMessage());
        notifyMessage().shouldHave(text(notifyMessage));
        closeNotifyMessage().click();

        authtorazation("hdgs@mail.ru", "a1010");
        checkEntityExists(notifyMessage());

        notifyMessage().shouldHave(text(notifyMessage));

    }

}
