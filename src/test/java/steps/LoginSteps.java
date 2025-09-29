package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.WebUtils;

/**
 * Classe de definição dos passos de login para testes automatizados com Cucumber.
 */
public class LoginSteps {

    LoginPage login;

    /**
     * Abre a página de login do sistema.
     */
    @Given("que estou na página de login")
    public void abrirPaginaLogin() {
        Hooks.driver.get("https://www.saucedemo.com/");
        login = new LoginPage(Hooks.driver);
    }

    /**
     * Preenche os campos de usuário e senha.
     * @param usuario Usuário a ser informado
     * @param senha Senha a ser informada
     */
    @When("eu digito o usuário {string} e a senha {string}")
    public void preencherCredenciais(String usuario, String senha) {
        login.preencherUsuario(usuario);
        login.preencherSenha(senha);
    }

    /**
     * Clica no botão de login.
     */
    @And("clico no botão de login")
    public void clicarBotaoLogin() {
        login.clicarLogin();
    }

    /**
     * Valida se o login foi realizado com sucesso.
     */
    @Then("devo ver a página inicial")
    public void validarLogin() {
        login.validaTexto();
    }

    @Then("valido mensagem de erro {string}")
    public void valido_mensagem_de_erro(String string) {
        login.validaTextoErro(string);
    }
}
