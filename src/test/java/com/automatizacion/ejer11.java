package com.automatizacion;

//objetivo : data provider en el archivo

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


import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class ejer11 {


    
String url="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";
WebDriver driver;


@BeforeTest 
public void setup(){
driver = new ChromeDriver();
driver.get(url);

}

@Test (dataProvider = "datos login")
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


@DataProvider (name="datos login")
public Object[][] obtenerDatos(){
Object [][] datos = new Object[4][2];

datos[0][0] = "maria@test.com"; 
datos[0][1] = "maria1234";

datos[1][0] = "juan@test.com";
datos[1][1] = "juan1234";

datos[2][0] = "test@test.com";
datos[2][1] = "test1234";

datos[3][0] = "pedro@test.com";
datos[3][1] = "pedro1234";


return datos;
}

}
