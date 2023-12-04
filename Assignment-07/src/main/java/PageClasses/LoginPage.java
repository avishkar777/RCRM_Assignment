package PageClasses;

import BaseClass.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Base {

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(id = "sTestEmail")
    public WebElement emailField;

    @FindBy(id = "sTestPassword")
    public WebElement passField;

    @FindBy(id = "sTestLoginBtn")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"sTest-forgotPasswordLink\"]/a")
    public WebElement forgotPass;

    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterPass(String password){
        passField.sendKeys(password);
    }

    public DashboardPage clickLoginBtn(){
        loginBtn.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs("Dashboard | Recruit CRM"));
        return PageFactory.initElements(driver, DashboardPage.class);
    }
}
