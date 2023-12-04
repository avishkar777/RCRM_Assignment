package TestCases;

import BaseClass.Base;
import PageClasses.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestCaseOne {

    Base base=new Base();
    DashboardPage dashboardPage;
    LoginPage loginPage;
    CandidatePage candidatePage;
    CompaniesPage companiesPage;
    ContactsPage contactsPage;
    JobPage jobPage;

    AdminPage adminPage;
    JobFieldPage jobFieldPage;
    CandidateFieldPage candidateFieldPage;
    @Test()
    @Parameters({"browser"})
    public void LoginTest(String browser){
        base.OpenBrowser(browser);
        loginPage= base.OpenApplication();
        loginPage.enterEmail("avishkargautam777@gmail.com");
        loginPage.enterPass("ashish12");
        dashboardPage=loginPage.clickLoginBtn();
    }

    @Test(dependsOnMethods = {"LoginTest"})
    public void AddCandidate(){
        candidatePage=base.commonElements.ClickCandidateIcon();
        candidatePage.ClickAddCandidateBtn();
        candidatePage.setCandidateFirstName("Suraj");
        candidatePage.setCandidateLastName("shah");
        candidatePage.setCandidateEmail("surajShah77@gmail.com");
        candidatePage.setCandidateCity("Noida");
        candidatePage.setCandidateAddress("H-86 Sector-55");
        candidatePage.ReallocateClick();
        candidatePage.setCandidateMobile("7776564646");
        candidatePage.SubmitCandidate();

    }

    @Test(dependsOnMethods = {"LoginTest"})
    public void AddCompanyContact(){
        companiesPage=base.commonElements.ClickCompaniesIcon();
        companiesPage.ClickAddCompanyBtn();
        companiesPage.setCompanyName("Kissan");
        companiesPage.setCompanyWebsiteUrl("https://www.kissan.com");
        companiesPage.setCompanyCity("Mumbai");
        companiesPage.setCompanyAbout("We are food company");
        companiesPage.setcContactFirstName("Rahul");
        companiesPage.setcContactLastName("Aggarwal");
        companiesPage.setcContactDesignation("Director");
        companiesPage.setcContactEmail("rahulsweet@gmail.com");
        companiesPage.setcContactPhone("9567463535");
        companiesPage.setcContactCity("Meerut");
        companiesPage.ClickSubmit();

    }
    @Test(dependsOnMethods = {"LoginTest"})
    public void AddContact(){
        contactsPage=base.commonElements.ClickContactIcon();
        contactsPage.ClickAddContactBtn();
        contactsPage.setContactFirstName("Shivam");
        contactsPage.setContactLastName("");
        contactsPage.setSelectCompany("Kissan");
        WebDriverWait wait= new WebDriverWait(contactsPage.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul li[id$='option-0']"))).click();
        contactsPage.setContactDesignation("Director");
        contactsPage.setContactEmail("shivamsharma@gmail.com");
        contactsPage.setContactMobile("9756565656");
        contactsPage.ClickSubmitBtn();

    }

    @Test(dependsOnMethods = {"LoginTest"})
    public void AddJob(){
        jobPage= base.commonElements.ClickJobIcon();
        jobPage.ClickAddJobBtn();
        jobPage.setJobTitle("People Operation");
        jobPage.setNoOfOpenings("5");
        jobPage.setSelectCompany("Kissan");
        jobPage.setJobType();
        jobPage.setJobCategory("Management");
        jobPage.setSkill("Excel");
        jobPage.setSkill("Communication Skills");
        jobPage.ClickSubmitJobBtn();
    }

    @Test(dependsOnMethods = {"LoginTest"})
    public void AddCandidateCustomField(){
        adminPage=base.commonElements.ClickAdminSetting();
        candidateFieldPage=adminPage.ClickCandidateField();
        candidateFieldPage.ClickAddFieldBtn();
        candidateFieldPage.SetFieldName("Expected DOJ");
        candidateFieldPage.SetFieldType("Date");
        candidateFieldPage.ClickSaveField();

    }

    @AfterTest
    public void close(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        base.closeTest();
    }

}
