package com.automatizacion;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ejer15 {

String url ="https://www.selenium.dev/";
WebDriver driver;

@BeforeTest 
public void setup(){

    //agregamos la linea para boni garcia
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get (url);

}

@Test 
public void test(){
System.out.println("prueba automatizacion con boni garcia");

}

}
