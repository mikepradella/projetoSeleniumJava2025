package pages;


import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtils;

public class ProdutosPage {
    private WebDriver driver;

    public ProdutosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement campoAdicionarCarrinho;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement carrinho;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cliqueCarrinho;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement validaProdutoCarrinho;




    public void clicarAdicionar() {
        WebUtils.esperarElementoVisivel(driver, campoAdicionarCarrinho, 2);
        campoAdicionarCarrinho.click();
    }

    public void validaCarrinho(String quantidade) {
        WebUtils.esperarElementoVisivel(driver,carrinho,2);
        WebUtils.validarTexto(driver,carrinho,quantidade);
    }

    public  void clicarCarrinho() {
       WebUtils.esperarElementoVisivel(driver,cliqueCarrinho,2);
         cliqueCarrinho.click();
    }

    public   void validaProduto(String produto) {
        WebUtils.validarTextoExato(driver,validaProdutoCarrinho,produto);
    }




}
