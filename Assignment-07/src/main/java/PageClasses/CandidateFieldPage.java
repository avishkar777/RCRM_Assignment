package PageClasses;

import BaseClass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CandidateFieldPage extends Base {

    public CandidateFieldPage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(id = "sTest-addFieldBtn")
    public WebElement addFieldBtn;

    @FindBy(xpath = "//div[@class='field']/div/input")
    public WebElement fieldName;

    @FindBy(id = "sTest-enabled")
    public WebElement fieldType;

    public void ClickAddFieldBtn(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(addFieldBtn));
        addFieldBtn.click();
    }

    public void SetFieldName(String field_name){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(fieldName));
        fieldName.sendKeys(field_name);
    }

    public void SetFieldType(String field_type){
        WebElement toClickField=null;
        fieldType.click();
        List<WebElement> type=driver.findElements(By.xpath("//*[@id=\"sTest-enabled\"]/div[3]/div/a"));
        for(WebElement x:type){
            String fieldTypename=x.getText();
            if(fieldTypename.equalsIgnoreCase(field_type)){
                toClickField=x;
                break;
            }
        }
        toClickField.click();
    }

    @FindBy(id = "sTest-saveCustomBtn")
    public WebElement saveField;

    public void ClickSaveField(){
        saveField.click();
    }

}
