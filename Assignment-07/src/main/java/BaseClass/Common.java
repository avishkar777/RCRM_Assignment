package BaseClass;

import PageClasses.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Common extends Base{
    //constructor
    public Common(WebDriver driver){
        this.driver=driver;
    }

    //dashboardIcon webelement and click
    @FindBy(id = "sTest-dashboradIcon")
    public WebElement dashboardIcon;
    public DashboardPage ClickDashboardIcon(){
        dashboardIcon.click();
        return PageFactory.initElements(driver, DashboardPage.class);
    }

    //candidatesIcon webelement and click
    @FindBy(id = "sTest-candidateIcon")
    public WebElement candidatesIcon;
    public CandidatePage ClickCandidateIcon(){
        candidatesIcon.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs("Candidates | Recruit CRM"));
        return PageFactory.initElements(driver, CandidatePage.class);
    }


    //companiesIcon webelement and click
    @FindBy(id = "sTest-companiesIcon")
    public WebElement companiesIcon;

    public CompaniesPage ClickCompaniesIcon(){
        companiesIcon.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs("Companies | Recruit CRM"));
        return PageFactory.initElements(driver, CompaniesPage.class);
    }


    //contactsIcon webelement and click
    @FindBy(id = "sTest-contactsIcon")
    public WebElement contactsIcon;
    public ContactsPage ClickContactIcon(){
        contactsIcon.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs("Contacts | Recruit CRM"));
        return PageFactory.initElements(driver,ContactsPage.class);
    }

    //jobsIcon webelement and click
    @FindBy(id = "sTest-jobsIcon")
    public WebElement jobsIcon;

    public JobPage ClickJobIcon(){
        jobsIcon.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs("Jobs | Recruit CRM"));
        return PageFactory.initElements(driver, JobPage.class);
    }

    //Taskmeeting icon webelement and click
    @FindBy(id = "sTest-mailBoxIcon")
    public WebElement mailIcon;

    @FindBy(id = "sTest-taskAppointmentIcon")
    public WebElement taskMeetingIcon;

    @FindBy(id = "sTest-dealsIcon")
    public WebElement dealsIcon;

    //reportIcon webelement and click
    @FindBy(id = "sTest-reportsIcon")
    public WebElement reportsIcon;

    @FindBy(id = "sTest-placementAndBillingIcon")
    public WebElement billingsIcon;

    //AdminSetting webelement and click
    @FindBy(id = "sTest-adminSettingIcon")
    public WebElement adminSetting;

    public AdminPage ClickAdminSetting(){
        adminSetting.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs("Admin Settings | Recruit CRM"));
        return PageFactory.initElements(driver, AdminPage.class);
    }

    //ProfileBtn WebElement and click
    @FindBy(id = "sTest-dpLinkInAppBtn")
    public WebElement profileBtn;

    public void ClickProfileBtn(){
        profileBtn.click();
    }

    //SignOut WebElement and click
    @FindBy(id = "sTest-signOutInAppBtn")
    public WebElement signOut;

    public LoginPage ClickSignOut(){
        signOut.click();
        return PageFactory.initElements(driver,LoginPage.class);
    }


}
