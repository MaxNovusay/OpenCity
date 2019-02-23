import com.codeborne.selenide.Selenide;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;


// Смоук тест, проверяет доступность основных элементов на проекте.


public class OpenCityAuthTest extends Pages {

    @Test
    public void test() {
        Selenide.open("https://open.kzn.ru/");

        loginButton().click();
        fieldLogin().val("hdgs@mail.ru");
        fieldPassword().val("a1010f");
        $("button.inputSubmit[data-ui='submit']").click();
        String url = getWebDriver().getCurrentUrl();

        if (!url.equals("https://open.kzn.ru/cabinet/")){
            throw new AssertionError("Текущая ссылка не равна ожидаемой");
        }

        checkPageLoad("Главная", "Главная");
        $(".username span").shouldBe(visible).shouldHave(text("hdgs@mail.ru"));
        checkEntityExists("Выход");
        $(byText("Выход")).click();


    }

}
