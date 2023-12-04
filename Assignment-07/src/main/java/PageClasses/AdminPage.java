package PageClasses;

import BaseClass.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage extends Base {

    public AdminPage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(id = "sTest-customJobIconAdminSettings")
    public WebElement jobField;

    public JobFieldPage ClickJobField(){
        jobField.click();
        return PageFactory.initElements(driver, JobFieldPage.class);
    }

    @FindBy(id = "sTest-customCandidateIconAdminSettings")
    public WebElement candidateField;
    public CandidateFieldPage ClickCandidateField(){
        candidateField.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs("Candidate Fields | Recruit CRM"));
        System.out.println("Admin page: clicking Candidate fields");
        return PageFactory.initElements(driver,CandidateFieldPage.class);
    }
}
