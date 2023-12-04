package PageClasses;
import BaseClass.Base;
import BaseClass.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends Base {


    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(xpath = "//div[@class='column is-6'][1]/ul[@class='checklist']/li[1]")
    public WebElement importCandidates;

    @FindBy(xpath = "//div[@class='column is-6'][1]/ul[@class='checklist']/li[2]")
    public  WebElement connectEmail;

    @FindBy(xpath = "//div[@class='column is-6'][1]/ul[@class='checklist']/li[3]")
    public WebElement inviteTeammates;

    @FindBy(xpath = "//div[@class='column is-6'][2]/ul[@class='checklist']/li[1]")
    public WebElement importCompaniesAndContacts;

    @FindBy(xpath ="//div[@class='column is-6'][1]/ul[@class='checklist']/li[2]")
    public WebElement chromeExtension;

    public void ClickImportCandidates(){
        importCandidates.click();
    }

    public void ClickConnectEmail(){
        connectEmail.click();
    }

    public void ClickInviteTeammates(){
        inviteTeammates.click();
    }
}
