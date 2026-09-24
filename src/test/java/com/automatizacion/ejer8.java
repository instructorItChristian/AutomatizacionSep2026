package com.automatizacion;
//objetivo : pom

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class ejer8 {

String url="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";
WebDriver driver;


@BeforeTest 
public void setup(){
driver = new ChromeDriver();
driver.get(url);

}

@Test 
public void login(){

    PaginaInicio inicio = new PaginaInicio(driver);
    inicio.HacerClickSignUp();

    PaginaLogin ingreso = new PaginaLogin(driver);

    //ojo con los datos de logueo -- usar una cuenta valida para el sitio y su base
    ingreso.EscribirEmail("test@test.com");
    ingreso.EscribirPass("test1234");
    ingreso.HacerClickIngresar();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement btn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logout")));


Assert.assertEquals(driver.getCurrentUrl(), "file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html");

    inicio.hacerClickLogout();



}


@Test 
public void BuscarPalabra(){
    PaginaInicio inicio = new PaginaInicio(driver);
    inicio.EscribirPalabraABuscar("silla");
    inicio.HacerClickBuscador();



}

}
