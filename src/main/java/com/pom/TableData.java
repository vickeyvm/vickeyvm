package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableData {

    WebDriver driver;

    @FindBy(xpath="//summary")
    WebElement tableTag;

    @FindBy(id="jsondata")
    WebElement jsonData;

    @FindBy(id="refreshtable")
    WebElement refreshTable;

    public void clickTableTag(){
        tableTag.click();
    }

    public void sendJsonData(String data){
        jsonData.clear();
        jsonData.sendKeys(data);
    }

    public void clickRefreshTable(){
        refreshTable.click();
    }

    public TableData(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }



}
