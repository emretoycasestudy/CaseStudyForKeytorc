package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class SearchPage extends BasePage {
    @FindBy(xpath = "(//p[@class='hb-pl-cn']/span)[1]")
     public WebElement firstItem;
    JavascriptExecutor jse=(JavascriptExecutor) Driver.get();

    public void searchItem(String item){
        BrowserUtils.waitFor(3);
        searchData.sendKeys(item);
        BrowserUtils.waitFor(2);
        searchBtn.click();
        BrowserUtils.waitFor(3);
    }
    public void selectPage(){
       // BrowserUtils.scrollToElement(secondPage);

        jse.executeScript("arguments[0].scrollIntoView(true);",secondPage);
        secondPage.click();

    }

    public void verifySamsungListing(String item){
        BrowserUtils.waitFor(5);
        jse.executeScript("arguments[0].scrollIntoView(true);",firstItem);
        WebElement actualList=Driver.get().findElement(By.xpath("(//p[@class='hb-pl-cn']/span)[1]"));
        Assert.assertTrue(actualList.getText().toLowerCase().contains(item));

    }

}
