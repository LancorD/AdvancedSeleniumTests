package all.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MainPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor jsExecutor;
    public String email = "test@test.ru";

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor) driver;
    }

    @FindBy(name = "email")
    public WebElement inputEmail;
    @FindBy(id = "sendMe")
    public WebElement buttonChooseName;
    @FindBy(id = "boy")
    public WebElement radioBoy;
    @FindBy(id = "girl")
    public WebElement radioGirl;
    @FindBy(className = "result-text")
    public WebElement resultText;
    @FindBy(className = "your-email")
    public WebElement textYourMail;
    @FindBy(tagName = "iframe")
    public WebElement frame;
    @FindBy(className = "form-error")
    public WebElement textErrorMessage;
    @FindBy(className = "header")
    public WebElement header;
    @FindBy(xpath = "(//*[@class = 'socialLinks__link'])[2]")
    public WebElement goToVkontakte;
    @FindBy(xpath = "(//*[@class = 'footer__contactItem descriptionText'])[2]")
    public WebElement goToSkillBox;



    public void open (){
        driver.navigate().to("http://qajava.skillbox.ru/module5/homework/");
    }

    public void switchToFrame(){
        driver.switchTo().frame(frame);
    }

    public void goToMainPage(){
        driver.switchTo().defaultContent();
    }



}
