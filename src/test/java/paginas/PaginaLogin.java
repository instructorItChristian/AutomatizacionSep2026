package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
    //elementos

    @FindBy(id="login-email")
    WebElement txtemail;


     @FindBy(xpath = "//*[@id=\"login-password\"]")
    WebElement txtpass;

     @FindBy(css = "#login-submit")
    WebElement botonIngresar;



    

    //constructor

      public PaginaLogin(WebDriver driver){
        PageFactory.initElements(driver, this);
      }

    //acciones

    public void EscribirEmail(String email){
                txtemail.sendKeys(email);

        }

         public void EscribirPass(String pass){
                txtpass.sendKeys(pass);

        }


         public void HacerClickIngresar(){
                botonIngresar.click();

        }

       
}
