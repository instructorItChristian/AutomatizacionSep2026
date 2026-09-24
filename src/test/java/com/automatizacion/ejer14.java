package com.automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ejer14 {

    String url ="https://demo.guru99.com/test/table.html";
    WebDriver driver;


    @BeforeTest 
    public void setup(){
driver= new ChromeDriver();
driver.get(url);

        }

        @Test 
        public void imprimirValoresTabla(){
String valor1 = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[2]")).getText();

System.out.println("primera fila, segunda columna:  "+ valor1);

String valor2 = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText();

System.out.println ("cuarta fila, segunda columna: "+ valor2);



            }

}
