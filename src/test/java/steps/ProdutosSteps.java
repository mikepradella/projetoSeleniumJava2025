package steps;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ProdutosPage;

public class ProdutosSteps {

    ProdutosPage produtosPage;


    public ProdutosSteps() {
        produtosPage = new ProdutosPage(Hooks.driver);
    }

    @When("adiciono o produto {string} ao carrinho")
    public void adiciono_o_produto_ao_carrinho(String string) {
        produtosPage.clicarAdicionar();
    }

    @Then("o carrinho deve conter {int} item")
    public void o_carrinho_deve_conter_item(Integer int1) {
        produtosPage.validaCarrinho("1");
    }
    @When("clico no ícone do carrinho")
    public void clico_no_ícone_do_carrinho() {
        produtosPage.clicarCarrinho();
    }

    @Then("devo ver o produto {string} no carrinho")
    public void devo_ver_o_produto_no_carrinho(String string) {
        produtosPage.validaProduto(string);
    }

}
