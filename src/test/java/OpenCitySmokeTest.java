
import org.junit.Test;
import com.codeborne.selenide.Selenide;


// Смоук тест, проверяет доступность основных элементов на проекте.


public class OpenCitySmokeTest extends Pages {

    @Test
    public void test() {
        Selenide.open("https://open.kzn.ru/");
        checkPageLoad("Главная", null);
        checkPageLoad("Подать заявку", "Подача заявки");
        checkPageLoad("Информация", "Полезная информация");
        checkPageLoad("Рейтинг УК", "Рейтинг УК");
        checkPageLoad("О проекте", "О проекте \"Открытая Казань\"");

        checkEntityExists(loginButton());
        loginButton().click();

        checkEntityExists(authModal());
        checkEntityExists(activeTabLogin());
        checkEntityExists(tabRegistration());
        checkEntityExists(fieldLogin());
        checkEntityExists(fieldPassword());
        checkEntityExists("Войти");
        checkEntityExists("Забыли пароль?");
        checkEntityExists("Войти через");

    }

}
