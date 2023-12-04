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

public class CompaniesPage extends Base {



    public CompaniesPage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(id = "sTest-addCompanyBtn")
    public WebElement AddCompanyBtn;

    public void ClickAddCompanyBtn(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(AddCompanyBtn));
        AddCompanyBtn.click();
        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.visibilityOf(companyName));
    }

    @FindBy(id = "sTest-companyNameTxt")
    public WebElement companyName;

    @FindBy(id = "sTest-companyWebsiteTxt")
    public WebElement companyWebsiteUrl;

    @FindBy(id = "sTest-companyCityTxt")
    public WebElement companyCity;

    @FindBy(id = "sTest-aboutCompany")
    public WebElement companyAbout;

    @FindBy(id = "sTest-companyAddress")
    public WebElement companyAddress;

    @FindBy(id = "sTest-companySubmitBtn")
    public WebElement submitCompany;

    @FindBy(id = "sTest-cContactFNameTxt")
    public WebElement cContactFirstName;

    @FindBy(id = "sTest-cContactLastNameTxt")
    public WebElement cContactLastName;

    @FindBy(id = "sTest-cContactDesignationTxt")
    public WebElement cContactDesignation;

    @FindBy(id = "sTest-cContactEmailTxt")
    public WebElement cContactEmail;

    @FindBy(id = "sTest-cContactNumberTxt")
    public WebElement cContactPhone;

    @FindBy(id = "sTest-cContactCityTxt")
    public WebElement cContactCity;

    public void setCompanyName(String name){
        companyName.sendKeys(name);
    }
    public void setCompanyWebsiteUrl(String url){
        companyWebsiteUrl.sendKeys(url);
    }

    public void setCompanyCity(String city){
        companyCity.sendKeys(city);
    }
    public void setCompanyAbout(String about){
        companyAbout.sendKeys(about);
    }
    public void setCompanyAddress(String address){
        companyAddress.sendKeys(address);
    }

    public void setcContactFirstName(String firstName){
        cContactFirstName.sendKeys(firstName);
    }
    public void setcContactLastName(String lastName){
        cContactLastName.sendKeys(lastName);
    }

    public void setcContactDesignation(String designation){
        cContactDesignation.sendKeys(designation);
    }

    public void setcContactEmail(String email){
        cContactEmail.sendKeys(email);
    }

    public void setcContactPhone(String phone){
        cContactPhone.sendKeys(phone);
    }

    public void setcContactCity(String city){
        cContactCity.sendKeys(city);
    }
    @FindBy(id = "sTest-ContactDetailsListBreadcrumb")
    public WebElement flag;
    public void ClickSubmit(){
        submitCompany.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(flag));
    }

}
