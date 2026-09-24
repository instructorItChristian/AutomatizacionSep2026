package com.automatizacion;


//objetivo : ejercicio con driver, chrome, chrome beta y firefox


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ejer2 {

//variales

String url ="https://automationexercise.com/products";
//observacion: ojo con el path
String url2="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";
//observacion: ojo con el path
String chromepath ="D:\\educacionIT2\\Cursos\\workspaceVSC\\cursoAutomatizacionSep2026\\demo\\Drivers\\chromedriver152.0.7977.82.exe";
//observacion: ojo con el path
String chromeBetaPath="D:\\educacionIT2\\Cursos\\workspaceVSC\\cursoAutomatizacionSep2026\\demo\\Drivers\\chromedriver154.0.8037.0.exe";
//observacion: ojo con el path
String FireFoxPath="Drivers\\geckodriver0.37.1.exe";

WebDriver driver;


//metodos o acciones
@Test
public void BuscarPalabraChrome(){

System.setProperty("webdriver.chrome.driver", chromepath);


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
public void BuscarPalabraChromeBeta_Local(){
//linea para configurar que driver voy a usar

System.setProperty("webdriver.chrome.driver", chromeBetaPath);

//lineas para configurar el uso de un navegador especifico

ChromeOptions options = new ChromeOptions();
//determina que navegador voy a utilizar
//observacion: ojo con el path
options.setBinary("C:/Program Files/Google/Chrome Beta/Application/chrome.exe");

//otras opciones que podemos tener con options

//options.addArguments("--start-maximized");
//options.addArguments("--incognito");

driver = new ChromeDriver(options);

driver.get(url2);

//escribir la palabra a buscar 
WebElement txtBuscador = driver.findElement(By.id("search-input"));

txtBuscador.sendKeys("silla");

//hacer enter 
WebElement boton = driver.findElement(By.id("search-submit"));

boton.sendKeys(Keys.ENTER);
}



//metodos o acciones
@Test
public void BuscarPalabrafirefox(){
System.setProperty("webdriver.firefox.driver", FireFoxPath);
driver = new FirefoxDriver();
driver.get(url);
//escribir la palabra a buscar 
WebElement txtBuscador = driver.findElement(By.id("search_product"));
txtBuscador.sendKeys("dress");
//hacer enter 
WebElement boton = driver.findElement(By.id("submit_search"));
boton.sendKeys(Keys.ENTER);

//driver.close();
}




}
