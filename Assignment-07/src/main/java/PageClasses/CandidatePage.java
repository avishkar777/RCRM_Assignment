package PageClasses;

import BaseClass.Base;
import BaseClass.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CandidatePage extends Base {

    String firstName;
    String lastName;



    @FindBy(id = "sTest-candidateDetailsBreadcrumb")
    public WebElement flag;

    public CandidatePage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(id = "sTest-addCandidateBtn")
    public WebElement addCandidateBtn;

    @FindBy(id = "sTest-candidateFirstName")
    public WebElement candidateFirstName;

    @FindBy(id = "sTest-candidateLastName")
    public WebElement candidateLastName;

    @FindBy(id = "sTest-candidateEmail")
    public WebElement candidateEmail;

    @FindBy(id = "sTest-candidateCity")
    public WebElement candidateCity;

    @FindBy(id = "sTest-candidateAddress")
    public WebElement candidateAddress;

    @FindBy(id = "sTest-candidateWillingToRelocateSwitch")
    public WebElement reallocateBtn;

    @FindBy(id = "sTest-candidateMobile")
    public WebElement candidateMobile;

    @FindBy(id = "sTest-candidateAddBtn")
    public WebElement submitCandidate;

    public void ClickAddCandidateBtn(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(addCandidateBtn));
        addCandidateBtn.click();
        WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.visibilityOf(candidateFirstName));
    }
    public void ReallocateClick(){
        reallocateBtn.click();
    }


    public void setCandidateFirstName(String firstName){
        candidateFirstName.sendKeys(firstName);
    }
    public void setCandidateLastName(String lastName){
        candidateLastName.sendKeys(lastName);
    }


    public void setCandidateEmail(String email){
        candidateEmail.sendKeys(email);
    }

    public void setCandidateCity(String city){
        candidateCity.sendKeys(city);
    }

    public void setCandidateAddress(String address){
        candidateAddress.sendKeys(address);
    }
    public void setCandidateMobile(String mobile){
        candidateMobile.sendKeys(mobile);
    }

    public void SubmitCandidate(){
        submitCandidate.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(flag));
    }


}
