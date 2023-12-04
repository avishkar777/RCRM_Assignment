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

public class ContactsPage extends Base {

    public ContactsPage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(id = "sTest-addContactBtn")
    public WebElement addContactBtn;

    @FindBy(id = "sTest-contactFirstnameTxt")
    public WebElement contactFirstName;

    @FindBy(id = "sTest-contactLastnameTxt")
    public WebElement contactLastName;

    @FindBy(xpath = "//input[@placeholder='Select Company']")
    public WebElement selectCompany;

    @FindBy(id = "sTest-contactDesignationTxt")
    public WebElement contactDesignation;

    @FindBy(id = "sTest-contactEmailTxt")
    public WebElement contactEmail;

    @FindBy(id = "sTest-contactContactnumberTxt")
    public WebElement contactMobile;

    @FindBy(id = "sTest-contactAddBtn")
    public WebElement submitContactBtn;

    public void ClickAddContactBtn(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(addContactBtn));
        addContactBtn.click();
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.visibilityOf(contactFirstName));
    }

    public void setContactFirstName(String firstName){
        contactFirstName.sendKeys(firstName);
    }

    public void setContactLastName(String lastName){
        contactLastName.sendKeys(lastName);
    }

    public void setSelectCompany(String company){
        selectCompany.sendKeys(company);
    }

    public void setContactDesignation(String designation){
        contactDesignation.sendKeys(designation);
    }
    public void setContactEmail(String email){
        contactEmail.sendKeys(email);
    }

    public void setContactMobile(String phone){
        contactMobile.sendKeys(phone);
    }

    @FindBy(id = "sTest-ContactDetailsListBreadcrumb")
    public WebElement flag;
    public void ClickSubmitBtn(){
        submitContactBtn.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(flag));
    }
}
