package com.automatizacion;


//objetivo : data provider en el archivo -- desde excel

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class ejer12 {

    
    
String url="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";
WebDriver driver;


@BeforeTest 
public void setup(){
driver = new ChromeDriver();
driver.get(url);

}

@Test (dataProvider = "datos login excel")
public void login(String email, String password){

    PaginaInicio inicio = new PaginaInicio(driver);
    inicio.HacerClickSignUp();

    PaginaLogin ingreso = new PaginaLogin(driver);

    //ojo con los datos de logueo -- usar una cuenta valida para el sitio y su base
    ingreso.EscribirEmail(email);
    ingreso.EscribirPass(password);
    ingreso.HacerClickIngresar();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement btn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logout")));


Assert.assertEquals(driver.getCurrentUrl(), "file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html");

   inicio.hacerClickLogout();



}


@DataProvider (name="datos login excel")
public Object[][] obtenerDatos() throws Exception{
return DatosExcel.leerExcel("datos\\datos_Login.xlsx", "Hoja1");
}

}

