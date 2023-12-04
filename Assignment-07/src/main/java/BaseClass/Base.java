package BaseClass;

import PageClasses.DashboardPage;
import PageClasses.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Base {
    //Opening Browser.
    public WebDriver driver=null;
    public Common commonElements=null;
    public void OpenBrowser(String browser){
        try{
            if(browser.equalsIgnoreCase("chrome")){
                System.setProperty("system.chrome.driver",System.getProperty("user-dir")+"/src/main/drivers/chromedriver.exe");
                driver=new ChromeDriver();
            }
            else if(browser.equalsIgnoreCase("firefox")){
                System.setProperty("system.gecko.driver",System.getProperty("user-dir")+"/src/main/drivers/geckodriver.exe");
                driver=new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                System.setProperty("system.edge.driver",System.getProperty("user-dir")+"/src/main/drivers/msedgedriver.exe");
                driver=new EdgeDriver();
            } else{
                System.setProperty("system.chrome.driver",System.getProperty("user-dir")+"/src/main/drivers/chromedriver.exe");
                driver=new ChromeDriver();
            }
        }
        catch(Exception e){
            System.out.println("Error connecting to driver");
            System.out.println(e.getMessage());
        }
        commonElements= PageFactory.initElements(driver, Common.class);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public LoginPage OpenApplication(){
        driver.get("https://neo-mr.recruitcrm.io/v1/");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sTestEmail")));
        return PageFactory.initElements(driver, LoginPage.class);

    }

    public void closeTest(){
        driver.close();
    }
    public void VerifyTitle(String expected){
        Assert.assertEquals(driver.getTitle(),expected);
    }

    public void doLogin(String email,String password){

    }

}
