package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {

    //elementos

    @FindBy(linkText ="Signup/Login")
    WebElement linkSignUp;


    @FindBy(id ="nav-logout")
    WebElement BotonLogOut;


    //elementos de buscar palabra

    @FindBy(id = "search-input")
    WebElement txtBuscador;

    @FindBy(id = "search-submit")
    WebElement botonConfirmacioBusqueda;


    //constructor

    public PaginaInicio(WebDriver driver){
        PageFactory.initElements(driver, this);
        }

    //acciones

    public void HacerClickSignUp(){
            linkSignUp.click();
        }

        public void hacerClickLogout(){
            BotonLogOut.click();
             }


public void EscribirPalabraABuscar(String palabra){
txtBuscador.sendKeys(palabra);
}

public void HacerClickBuscador(){
botonConfirmacioBusqueda.click();
    }

}
