package PageClasses;

import BaseClass.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobFieldPage extends Base {

    public JobFieldPage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(id = "sTest-addFieldBtn")
    public WebElement addFieldBtn;

    @FindBy(xpath = "//input[@name='custumField0']")
    public WebElement FieldName;

    @FindBy(xpath = "//div[@name='Custom Field Type']")
    public WebElement FieldType;

    @FindBy(id = "sTest-saveCustomBtn")
    public WebElement saveField;

    public void ClickAddFieldBtn(){
        addFieldBtn.click();
    }

    public void setFieldName(String fieldName){
        FieldName.sendKeys(fieldName);
    }


}
