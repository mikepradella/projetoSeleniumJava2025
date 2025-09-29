package pages;


import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtils;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement textoLogado;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement campotextoErro;



    public void preencherUsuario(String user) {
        username.sendKeys(user);
    }

    public void preencherSenha(String pass) {
        password.sendKeys(pass);
    }

    public void clicarLogin() {
        loginBtn.click();
    }

    public void validaTexto() {
        WebUtils.esperarElementoVisivel(driver,textoLogado,2);
        System.out.println(textoLogado.getText());
    }
    public void validaTextoErro(String texto) {
        WebUtils.validarTexto(driver,campotextoErro,texto);
    }


}
