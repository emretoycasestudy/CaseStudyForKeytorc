package com.hepsiburada.pages;

import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(className = "sf-OldMyAccount-PhY-T")
            public WebElement menuLink;

    @FindBy(className = "desktopOldAutosuggestTheme-input")
    public WebElement searchData;

    @FindBy(className = "SearchBoxOld-buttonContainer")
    public WebElement searchBtn;

    @FindBy(className= "pagination")
    public WebElement pageSelect;

    @FindBy(xpath = "//*[@id=\"pagination\"]/ul/li[2]")
    public WebElement secondPage;







}
