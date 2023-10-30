package com.tests;

import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.AssertJUnit;
import com.base.BaseClass;
import com.configuration.Config;
import com.pom.TableData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClass<List> {

    public static WebDriver driver;
    BaseClass base;

    @BeforeClass
    public void openBrowser(){
        base = new BaseClass();
        driver = base.initialization();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void testCall() throws InterruptedException {
        TableData td = new TableData(driver);
        td.clickTableTag();
        Thread.sleep(2000);
        td.sendJsonData(Config.jsonData);
        Thread.sleep(2000);
        td.clickRefreshTable();

        //java.util.List<Config> expectedDataList = (java.util.List<Config>) parseConfigData(Config.jsonData);

        //WebElement table = driver.findElement(By.id("dynamictable"));

        WebElement table = driver.findElement(By.xpath("//table"));

        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
        // System.out.println(rows.size());


//        ///html/body/div/div[3]/div/table/tr[1]
//
        java.util.List<Config> expectedDataList = parseConfigData(Config.jsonData);

        for (int i = 1; i < rows.size(); i++) { // Start from the second row (index 1)
            WebElement row = rows.get(i);
            java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
            // System.out.println(cells.size());
            if (cells.size() == 3 && i < expectedDataList.size() ) { //&& i < expectedDataList.size()
                String name = cells.get(0).getText();
                int age = Integer.parseInt(cells.get(1).getText());
                String gender = cells.get(2).getText();

                System.out.println(name +"   "+age+"   "+gender);

                //Config con = new Config(name, age, gender);
                System.out.println(expectedDataList.get(i-1).getName()+ expectedDataList.get(i-1).getAge()+expectedDataList.get(i-1).getGender());


                Reporter.log("Validation for name " + name, true);
                Assert.assertEquals(name, expectedDataList.get(i-1).getName());

                Reporter.log("Validation for age " + age, true);
                Assert.assertEquals(age, expectedDataList.get(i-1).getAge());

                Reporter.log("Validation for Gender " + gender, true);
                AssertJUnit.assertEquals(gender, expectedDataList.get(i-1).getGender());

                Thread.sleep(1000);

            }
        }

    }

    private java.util.List<Config> parseConfigData(String jsonData) {
        return new ArrayList<>();
    }


    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
