package com.automatizacion;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//objetivo : anotaciones de testng -- form contact us


public class ejer4 {


String url="file:///D:/educacionIT2/Cursos/seleniumWEBdriver/2026/QA-mart/index.html";

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
public void FormContacUs() {

//hacer click en contact us

driver.findElement(By.linkText("Contact Us")).click();

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

//click boton "enviar msj"

driver.findElement(By.cssSelector("#contact-submit")).click();



}


@Test (description = "Cp002 -- buscar palabra chrome", priority = 5)
public void BuscarPalabraChrome(){

driver.navigate().to(url);

//escribir la palabra a buscar 
WebElement txtBuscador = driver.findElement(By.id("search-input"));

txtBuscador.sendKeys("silla");

//hacer enter 
WebElement boton = driver.findElement(By.id("search-submit"));

boton.sendKeys(Keys.ENTER);
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
