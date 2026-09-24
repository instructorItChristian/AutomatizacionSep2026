package com.automatizacion;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ejer7 {

//observacion: ojo con el path
String url2="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";

WebDriver driver;


//if (condicion) {accionV} else {accionf} 

@Parameters("navegador")
@BeforeTest
public void setup(String navegador){

if (navegador.equalsIgnoreCase("chrome")){

    driver = new ChromeDriver();
}else if(navegador.equalsIgnoreCase("firefox")){


driver= new FirefoxDriver();
}


driver.get(url2);
    }


@Test
public void BuscarPalabraChromeLocal(){

//escribir la palabra a buscar 
WebElement txtBuscador = driver.findElement(By.id("search-input"));

txtBuscador.sendKeys("silla");

//hacer enter 
WebElement boton = driver.findElement(By.id("search-submit"));

boton.sendKeys(Keys.ENTER);
}


}
