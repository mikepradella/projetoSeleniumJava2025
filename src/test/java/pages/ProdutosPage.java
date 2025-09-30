package pages;


import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtils;

public class ProdutosPage {
    WebDriver driver;

    public ProdutosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement campoAdicionarCarrinho;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement carrinho;


    public void clicarAdicionar() {
        campoAdicionarCarrinho.click();
    }

    public void validaCarrinho() {
        WebUtils.esperarElementoVisivel(driver,carrinho,2);
        WebUtils.validarTexto(driver,carrinho,"1");
    }


}
