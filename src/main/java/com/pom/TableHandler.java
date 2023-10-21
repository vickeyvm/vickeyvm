package com.pom;

import com.configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableHandler {
    private static WebDriver driver;

    public TableHandler(WebDriver driver) {
        this.driver = driver;
    }

//    public static List<Config> retrieveDataFromTable(String tableName, int row, int column) {
//        WebElement table = driver.findElement(By.id(tableName));
//        WebElement cell = table.findElement(By.xpath("//tr[" + row + "]/td[" + column + "]"));
//        return cell.getText();
//    }
}
