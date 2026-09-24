package com.automatizacion;


//objetivo : buscar palabra en sitio de internet y mas....

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ejer1 {


//variales

String url ="https://automationexercise.com/products";
//observacion: ojo con el path
String url2="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";

WebDriver driver;


//metodos o acciones
@Test
public void BuscarPalabraChrome(){
driver = new ChromeDriver();

driver.get(url);

//escribir la palabra a buscar 
WebElement txtBuscador = driver.findElement(By.id("search_product"));

txtBuscador.sendKeys("dress");

//hacer enter 
WebElement boton = driver.findElement(By.id("submit_search"));

boton.sendKeys(Keys.ENTER);
}



@Test
public void BuscarPalabraChromeLocal(){
driver = new ChromeDriver();

driver.get(url2);

//escribir la palabra a buscar 
WebElement txtBuscador = driver.findElement(By.id("search-input"));

txtBuscador.sendKeys("silla");

//hacer enter 
WebElement boton = driver.findElement(By.id("search-submit"));

boton.sendKeys(Keys.ENTER);
}



}
