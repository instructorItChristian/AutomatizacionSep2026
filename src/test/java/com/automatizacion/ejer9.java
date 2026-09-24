package com.automatizacion;



import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;

//objetivo : captura de evidencia


public class ejer9 {
String url="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";
String imagePath ="Evidencias\\";
String docPath ="Evidencias\\documentoEvidenciasContactUS.docx";

File screen;
WebDriver driver;

@BeforeSuite
public void setup(){
System.out.println("beforeSuite");
driver = new ChromeDriver();
    }

	@BeforeTest
public void beforetest(){
System.out.println("beforetest");
driver.navigate().to(url);
    }

		@BeforeClass

        public void beforeclass(){
System.out.println("beforeclass");
    }
			@BeforeMethod
    public void beforemethod(){
System.out.println("beforemethod");
    }


@Test(description = "Cp001 - Envio de msj en CONTACT US", priority = 0)
public void FormContacUs() throws InvalidFormatException, IOException, InterruptedException {

//incluimos el wait para cuando carga la pagina
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-grid > div:nth-child(3) > div:nth-child(1) > img")));
    
Date fecha = new Date();

Calendar cal = Calendar.getInstance();
cal.setTime(fecha);

    int hora = cal.get(Calendar.HOUR_OF_DAY); //0 -23
    int min = cal.get(Calendar.MINUTE);

    String docpath2 ="Evidencias\\documentoEvidenciasContactUS"+LocalDate.now()+"H"+hora+"M"+min+".docx";



//captura de evidencia
CapturaEvidencia.escribirTituloEnDocumento(docPath, "Documento Evidencia de form Contact Us", 20);
CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docpath2, "Pantalla Inicial");


//hacer click en contact us

driver.findElement(By.linkText("Contact Us")).click();


//captura de evidencia
CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docpath2, "formulario Vacio");
//completar nombre

driver.findElement(By.xpath("//input[@data-qa=\"contact-name\"]")).sendKeys("pepe");

//completar email

driver.findElement(By.cssSelector("#contact-email")).sendKeys("correo@test.com");

//completar asunto

driver.findElement(By.id("contact-subject")).sendKeys("testQA");

//completar msj

driver.findElement(By.cssSelector("#contact-message")).sendKeys("Msj de prueba");

//seleccionar archivo

driver.findElement(By.xpath("//*[@id=\"contact-file\"]")).sendKeys("C:\\testenvio.txt");


//captura de evidencia

CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docpath2, "formulario Completo");

//click boton "enviar msj"

driver.findElement(By.cssSelector("#contact-submit")).click();


  WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#custom-alert-close")));
    

//captura de evidencia

CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docpath2, "Resultado de Ejecucion");

}


@Test (description = "Cp002 -- buscar palabra chrome", priority = 5)
public void BuscarPalabraChrome() throws IOException{

driver.navigate().to(url);

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-grid > div:nth-child(3) > div:nth-child(1) > img")));

//captura de evidencia

screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File(imagePath+ "01pantallaInicial.jpg"));


//escribir la palabra a buscar 
WebElement txtBuscador = driver.findElement(By.id("search-input"));

txtBuscador.sendKeys("silla");

//captura de evidencia

screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File(imagePath+ "02pantallaABuscar.jpg"));

//hacer enter 
WebElement boton = driver.findElement(By.id("search-submit"));

boton.sendKeys(Keys.ENTER);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-grid\"]/div/div[1]/img")));


//captura de evidencia

screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File(imagePath+ "03pantallaResultado.jpg"));

//esta linea es una validacion de la url final de proceso
Assert.assertEquals(driver.getCurrentUrl(), "file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html");

}





            @AfterMethod
               public void aftermethod(){
System.out.println("aftermethod");
    }
		@AfterClass
                  public void afterclass(){
System.out.println("afterclass");
    }
	@AfterTest

               public void aftertest(){
System.out.println("aftertest");

//driver.close();
    }
@AfterSuite
    public void aftersuite(){
System.out.println("aftersuite");
    }


}


