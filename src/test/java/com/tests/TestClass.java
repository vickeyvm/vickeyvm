package com.tests;

import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.AssertJUnit;
import com.base.BaseClass;
import com.configuration.Config;
import com.pom.TableData;
import com.pom.TableHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

        //WebElement table = driver.findElement(By.id("dynamictable"));

        WebElement table = driver.findElement(By.xpath("//table"));

        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
        // System.out.println(rows.size());


//        ///html/body/div/div[3]/div/table/tr[1]
//
         for (WebElement row : rows) {
            java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
            // System.out.println(cells.size());
            if (cells.size() == 3) {
                String name = cells.get(0).getText();
                int age = Integer.parseInt(cells.get(1).getText());
                String gender = cells.get(2).getText();

                System.out.println(name +"   "+age+"   "+gender);

                Config con = new Config(name, age, gender);
                //System.out.println(con.getName()+ con.getAge()+con.getGender());
                Reporter.log("validation for name "+ name, true);

                Assert.assertEquals(name,con.getName());
                Reporter.log("validation for age ", true);
                Assert.assertEquals(age,con.getAge());
                Reporter.log("validation for Gender", true);
                AssertJUnit.assertEquals(gender,con.getGender());
                Thread.sleep(1000);
            }
        }

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
