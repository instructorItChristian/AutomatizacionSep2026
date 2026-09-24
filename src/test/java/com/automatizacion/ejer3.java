package com.automatizacion;

import java.time.Duration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//objetivo : registrarme en el sito qa-mart

public class ejer3 {
//ojo con esta linia -- hay que apuntar a tu ubicacion del sitio
String url ="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/login.html";
WebDriver driver;

@Test
public void RegistrarUsuario(){
driver = new ChromeDriver();
driver.navigate().to(url);


//ingresar un nombre de usuario
driver.findElement(By.id("pre-username")).sendKeys("test96321458");

//ingresar un email
driver.findElement(By.cssSelector("#pre-email")).sendKeys("test96321458@test.com");


//click en el boton "comenzar registro"

driver.findElement(By.xpath("//*[@id=\"preregister-submit\"]")).click();

//-------------------------------------------------------------------

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signup-title-mr")));

//-------------------------------------------------------------------


//seleccionar un titulo

driver.findElement(By.id("signup-title-mr")).click();

//escribir una pass

driver.findElement(By.xpath("//*[@id=\"signup-password\"]")).sendKeys("test1234");

//seleccionar una fecha de nacimiento

    //dia

    Select dia = new Select (driver.findElement(By.cssSelector("#dob-day")));
        dia.selectByVisibleText("15");

    //mes

    Select month = new Select (driver.findElement(By.id("dob-month")));
        month.selectByValue("5");
    //año

    Select year = new Select (driver.findElement(By.id("dob-year")));
        year.selectByIndex(5);


    //campos de novedades

    driver.findElement(By.xpath("//*[@id=\"signup-offers\"]")).click();

    //escribir un nombre 

    driver.findElement(By.id("signup-firstname")).sendKeys("pepe");

    //escribir un apellido
    driver.findElement(By.xpath("//*[@id=\"signup-lastname\"]")).sendKeys("Argento");

    //escribir una empresa
    driver.findElement(By.cssSelector("#signup-company")).sendKeys("Clase de automatizacion");

    //escribir una direccion 

    driver.findElement(By.xpath("//*[@id=\"signup-address1\"]")).sendKeys("Calle QA 1234");

    //esribir una direccion2

    driver.findElement(By.id("signup-address2")).sendKeys("es una casa");

    //seleccionar un pais

    Select pais = new Select(driver.findElement(By.cssSelector("#signup-country")));
    pais.selectByVisibleText("Colombia");

    //escribir una provincia

    driver.findElement(By.id("signup-state")).sendKeys("Provincia QA");

    //escribir un cp

    driver.findElement(By.xpath("//*[@id=\"signup-zip\"]")).sendKeys("1234");

    //escribir un telefono
    driver.findElement(By.id("signup-phone")).sendKeys("12345678");


    //click en boton "crear cuenta"
    
    driver.findElement(By.cssSelector("#signup-submit")).click();



}

}
