package all;

import all.Pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainPageTest extends TestBase {
    @Test
    public void mainPage_EnterDataBoyAndPressSend_DataCorrect(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();

        //act
        page.inputEmail.sendKeys(page.email);
        page.buttonChooseName.click();

        //assert

        Assertions.assertAll(
                () -> Assertions.assertTrue(page.resultText.getText().contains("мальчика"), "Итоговый текст сформирован не верно"),
                () -> Assertions.assertEquals(page.email, page.textYourMail.getText(), "Итоговый E-mail не отобразился или не верен")
        );
    }
    @Test
    public void mainPage_EnterDataGirlAndPressSend_DataCorrect(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();

        //act
        page.radioGirl.click();
        page.inputEmail.sendKeys(page.email);
        page.buttonChooseName.click();

        //assert

        Assertions.assertAll(
                () -> Assertions.assertTrue(page.resultText.getText().contains("девочки"), "Итоговый текст сформирован не верно"),
                () -> Assertions.assertEquals(page.email, page.textYourMail.getText(), "Итоговый E-mail не отобразился или не верен")
        );
    }
    @Test
    public void mainPage_NotEnterDataAndPressSend_GetSendMessage(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();

        //act
        page.buttonChooseName.click();

        //assert
        Assertions.assertEquals("Введите email", page.textErrorMessage.getText(), "Текст сообщения об ошибке не вышел");
    }
    @Test
    public void mainPage_EnterIncorrectDataAndPressSend_GetSendMessage(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();

        //act
        page.inputEmail.sendKeys("1234");
        page.buttonChooseName.click();

        //assert

        Assertions.assertEquals("Некорректный email", page.textErrorMessage.getText(), "Текст сообщения об ошибке не вышел");
    }
    @Test
    public void mainPage_GoToSocialLink_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        page.switchToFrame();

        //act
        page.goToVkontakte.click();

        //assert
        Assertions.assertEquals(2, getAllWindow().size(), "После клика по ссылке социальной сети новая вкладка не открылась");
    }
    @Test
    public void mainPage_GoToSkillBoxCloseNewWindow_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        page.switchToFrame();

        //act
        page.goToSkillBox.click();
        switchNewWindow();
        driver.close();
        switchToWindow(initialWindow);

        //assert
        Assertions.assertEquals(1, getAllWindow().size(), "Окно не закрылось");
    }
    @Test
    public void mainPage_EnterDataAndPressSend_HeaderIsDisplay(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();

        //act
        page.inputEmail.sendKeys(page.email);
        page.buttonChooseName.click();
        page.goToMainPage();

        //assert
        Assertions.assertTrue(page.header.isDisplayed(), "Хедер не виден");
    }
    @Test
    public void mainPage_GoToSkillBoxCloseNewWindow_OldWindowInputIsDisplay(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        page.switchToFrame();

        //act
        page.goToSkillBox.click();
        switchNewWindow();
        driver.close();
        switchToWindow(initialWindow);
        page.switchToFrame();

        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, getAllWindow().size(), "Окно не закрылось"),
                () -> Assertions.assertTrue(page.inputEmail.isDisplayed(), "Ввод E-mail виден")
        );
    }
}
