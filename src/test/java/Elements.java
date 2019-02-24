import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// Класс описывает элементы используемые на страницах

public class Elements {

    /**
     * получение Кнопки входа
     * @return кнопку входа
     */
    public SelenideElement loginButton() {
        return  $("a.sendAuth[data-ui='auth']");
    }

    /**
     * получение модального окна
     * @return окно авторизации
     */
    public SelenideElement authModal() {
        return $(".modal__content");
    }

    /**
     * Получение активной вкладки "вход"
     * @return активную вкладку "вход"
     */
    public SelenideElement activeTabLogin() {
        return $(".tabs__header__item.active[data-tab*='auth']");
    }

    /**
     * Получение вкладки "регистрация"
     * @return вкладку "регистрация"
     */
    public SelenideElement  tabRegistration(){
        return $(".tabs__header__item[data-tab*='registration']");
    }

    /**
     * Получение поля логин
     * @return поле логин
     */
    public SelenideElement fieldLogin(){
        return $("input[data-ui*='login']");
    }

    /**
     * Получение поля пароль
     * @return поле пароль
     */
    public SelenideElement fieldPassword(){
        return $("input[data-ui*='password']");
    }

    /**
     * Получение окна с информационным сообщением
     * @return блок с сообщением
     */
    public SelenideElement notifyMessage(){
        return $(".message_notify");
    }

    /**
     * Получение кнопки закрыть для окна с информационным сообщением
     * @return кнопка закрыть
     */
    public SelenideElement closeNotifyMessage(){
        return $(".close[title*=Закрыть]");
    }

    /**
     * Получение popup окна на странице пользователя
     * @return popup окно
     */
    public SelenideElement popupMessageOnUserPage(){
        return $(".onesignal-popover-dialog");
    }

    /**
     * Получение кнопки вход на странице авторизации
     * @return кнопку входа
     */
    public SelenideElement getloginButtonOnAuthPage(){
        return $("button.inputSubmit[data-ui='submit']");
    }

    /**
     * Получение блока с логином пользователя на странице пользователя
     * @return блок с логином пользователя
     */
    public SelenideElement getUserloginOnPage() {
      return   $(".username span");
    }
}
