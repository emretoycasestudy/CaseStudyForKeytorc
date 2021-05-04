package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritePage extends BasePage{
    JavascriptExecutor jse=(JavascriptExecutor) Driver.get();
    @FindBy(xpath = "(//*[@id=\"heartWrapper\"])[3]")
    public WebElement addFavoriteBtn;

    @FindBy(xpath = "//a[@title='Beğendiklerim']")
    public WebElement favoriteList;

    @FindBy(xpath = "(//*[@id=\"css_cs_pointer\"]/div)[1]")
    public WebElement selectFav;

    @FindBy(xpath = "//button[@id='StickActionHeader-RemoveSelected']")
    public WebElement deleteFav;

    @FindBy(id="DeleteConfirmationModal-Subtitle")
    public WebElement deletConfirm;

    @FindBy(xpath = "//strong[@id='css_cs_cursor']")
    public WebElement verifyEmptList;

    @FindBy(id="StickActionHeader-SelectAll")
    public WebElement selectAll;

  //  @FindBy(xpath = "//strong[@id='css_cs_cursor']")
    // public WebElement productCount;

    public void addItemToFavorite(){
        BrowserUtils.waitFor(10);
        jse.executeScript("arguments[0].scrollIntoView(true);",addFavoriteBtn);
        addFavoriteBtn.click();
        menuLink.click();
        BrowserUtils.waitFor(5);
        favoriteList.click();

    }
    public void verifyList(){
        BrowserUtils.waitFor(5);

       //Assert.assertTrue(Boolean.parseBoolean(verifyEmptList.getAttribute("value")));
        Assert.assertFalse(verifyEmptList.getText().contains("şu an boş"));


    }
    public void removeFromList(){
        BrowserUtils.waitFor(2);
        selectFav.click();
        BrowserUtils.waitFor(2);
        deleteFav.click();
        BrowserUtils.waitFor(2);
        deletConfirm.click();
        BrowserUtils.waitFor(2);

    }
    public void verifyEmptyList(){
        Assert.assertTrue(verifyEmptList.getText().contains("şu an boş"));
    }



}
