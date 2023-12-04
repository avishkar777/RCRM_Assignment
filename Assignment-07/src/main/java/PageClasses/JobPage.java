package PageClasses;

import BaseClass.Base;
import BaseClass.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobPage extends Base {

    public JobPage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(xpath = "//iframe[@title='Rich Text Editor, editor1']")
    public WebElement iframe;

    @FindBy(id = "jobDescriptionText_body")
    public WebElement jobDescTextArea;

    @FindBy(xpath = "//*[@id=\"sTest-jobNoOfopeningsTxt\"]/div[3]/div/div/div/input")
    public WebElement searchBarOpenings;

    @FindBy(xpath = "//*[@id='sTest-jobNoOfopeningsTxt']/div[3]/div/a[1]")
    public WebElement openingsNumber;

    @FindBy(id = "sTest-addJobListBtn")
    public WebElement addJobBtn;

    @FindBy(id = "sTest-jobNameTxt")
    public WebElement jobTitle;

    @FindBy(id = "sTest-jobNoOfopeningsTxt")
    public WebElement noOfOpenings;


    @FindBy(id = "sTest-companysearchControl")
    public WebElement selectCompany;

    @FindBy(id = "sTest-jobType")
    public WebElement jobType;

    @FindBy(id = "sTest-jobCategoryTxt")
    public WebElement jobCategory;

    @FindBy(css = ".taginput.control.skill-tags>div>div>div>input")
    public WebElement skill;

    @FindBy(id = "sTest-companyAddBtn")
    public WebElement submitJobBtn;

    public void ClickAddJobBtn(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(addJobBtn));
        addJobBtn.click();
        wait.until(ExpectedConditions.visibilityOf(jobTitle));
    }

    public void setJobTitle(String title){
        jobTitle.sendKeys(title);
    }

    public void setNoOfOpenings(String num){
        noOfOpenings.click();
        searchBarOpenings.sendKeys(num);
        openingsNumber.click();

    }

    public void setSelectCompany(String company){
        selectCompany.click();
        selectCompany.sendKeys(company);
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sTest-addJObCompanyLabel\"]/div/div/div/div[2]/div/a"))).click();
    }

    public void setSkill(String value){
        skill.sendKeys(value);
        skill.sendKeys(Keys.ENTER);
    }

    @FindBy(id = "sTest-jobDetailsListBreadcrumb")
    public WebElement flag;
    public void ClickSubmitJobBtn(){
        submitJobBtn.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(flag));
    }

    public void setJobType(){
        jobType.click();
        driver.findElement(By.cssSelector(".dropdown-menu.is-opened-top>.dropdown-content>a:nth-of-type(2)")).click();
    }

    public void setJobCategory(String job_category){
        jobCategory.sendKeys(job_category);
    }

    public void setJobDescription(String description){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.switchTo().frame(iframe);
        WebElement body=driver.findElement(By.id("jobDescriptionText_body"));
        body.sendKeys(description);
        driver.switchTo().parentFrame();

    }


}
