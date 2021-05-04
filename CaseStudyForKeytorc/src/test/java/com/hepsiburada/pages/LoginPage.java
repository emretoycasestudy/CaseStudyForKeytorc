package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.ConfigurationReader;
import com.hepsiburada.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "login")
    public WebElement girisYap;

    @FindBy(name= "username")
    public WebElement email;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(id="btnLogin")
    public WebElement loginBtn;

    String myEmail= ConfigurationReader.get("email");
    String myPassword= ConfigurationReader.get("password");

    public void signIn(){
        BrowserUtils.hover(menuLink);
        girisYap.click();
        email.sendKeys(myEmail);
        password.sendKeys(myPassword, Keys.ENTER);


    }
    public void loginVerify(){
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        String expectedTitle="Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle );
    }



}
