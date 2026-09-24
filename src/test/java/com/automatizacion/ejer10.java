package com.automatizacion;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ejer10 {


String url ="https://demoqa.com/alerts";
WebDriver driver;

@BeforeTest 
public void setup(){
    driver = new ChromeDriver();
    driver.get(url);

    }

    @Test (description ="cp001 - Click Button to see alert ")
    public void alert1(){
            driver.findElement(By.id("alertButton")).click();
            Alert VAlerta = driver.switchTo().alert();
            VAlerta.accept();

        }

         @Test (description = "cp002 - On button click, alert will appear after 5 seconds")
    public void alert2(){
                driver.findElement((By.xpath("//*[@id=\"timerAlertButton\"]"))).click();

                WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
                wait.until(ExpectedConditions.alertIsPresent());

                Alert VAlerta = driver.switchTo().alert();
            VAlerta.accept();

        }
         @Test (description = "cp003 - On button click, confirm box will appear")
    public void alert3(){

        driver.findElement((By.id("confirmButton"))).click();
         Alert VAlerta = driver.switchTo().alert();
            VAlerta.dismiss();


        }
         @Test 
    public void alert4(){
                driver.findElement(By.id("promtButton")).click();
                Alert VAlerta = driver.switchTo().alert();
                VAlerta.sendKeys("clase de automatizacion");
                VAlerta.accept();

        }



}
