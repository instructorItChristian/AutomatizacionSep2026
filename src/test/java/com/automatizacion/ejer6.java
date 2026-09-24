package com.automatizacion;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

//objetivo: captura evidencia con scrolling

public class ejer6 {

    WebDriver driver;

    @Test 
    public void ScrollScreenshot() throws IOException {
        driver = new ChromeDriver();

        driver.get("http://www.bbc.com");
        driver.manage().window().maximize();

        Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(), "PNG", new File("Evidencias\\fullpageScreenShot.png"));

        driver.close();

        }

}
