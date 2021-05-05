package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.Driver;
import org.junit.Assert;
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

    @FindBy(xpath="//button[@id='DeleteConfirmationModal-ActionButton']")
    public WebElement deletConfirm;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/strong[1]/span[2]")
    public WebElement verifyEmptList;

    @FindBy(id="StickActionHeader-SelectAll")
    public WebElement selectAll;

   @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/strong[1]")
    public WebElement productCount;

    public void addItemToFavorite(){
        BrowserUtils.waitFor(5);
        jse.executeScript("arguments[0].scrollIntoView(true);",addFavoriteBtn);
        addFavoriteBtn.click();
        menuLink.click();
        BrowserUtils.waitFor(5);
        favoriteList.click();

    }
    public void verifyList(){

       Assert.assertTrue(productCount.getText().contains("ürün"));

    }
    public void removeFromList(){

        selectAll.click();
        deleteFav.click();
        deletConfirm.click();

    }
    public void verifyEmptyList(){
        Assert.assertTrue(verifyEmptList.getText().contains("şu an boş"));
    }



}
