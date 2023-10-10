package ProductsTests;

import PageObjects.LoginPage;
import PageObjects.ProductsPage;
import PageObjects.CartPage;
import helpers.Functions;
import helpers.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

 /* Dado que eu esteja logado no site

    E desejo fazer uma compra de 2 itens diferentes

    Quando eu selecionar os itens

    E adicionar ao carrinho

    E finalizar a compra

    Então a compra deve ser realizada com sucesso */


public class Realiza_Compra_Itens_Diferentes {

    private WebDriver driver;
    private Functions functions;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;


    @BeforeTest
    public void SetUp() {
        driver = WebDriverConfig.Instance().driver;

        functions = new Functions();
        loginPage = new LoginPage();

        productsPage = new ProductsPage();
        cartPage = new CartPage();

        functions.LoginStardardUser();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Login não realizado! Existe algum problema com usuário e senha!");
    }


    @Test(dependsOnMethods = "SetUp")
    public void AdicionaItensNoCarrinho() {

        functions.ClicaComponente(productsPage.BotaoAddToCartBackpack);
        functions.ClicaComponente(productsPage.BotaoAddToCartBikeLight);

        assertNotNull(productsPage.BotaoRemoveBackpack, "Item Backpack não adicionado ao carrinho!");
        assertNotNull(productsPage.BotaoRemoveBikeLight, "Item Bike Light não adicionado ao carrinho!");

        System.out.println("Itens adicionados ao carrinho com sucesso!");
    }


    @Test(dependsOnMethods = "AdicionaItensNoCarrinho")
    public void AcessaCarrinho() {

        functions.ClicaComponente(productsPage.BotaoCarrinho);
        assertNotNull(cartPage.BotaoCheckout, "Carrinho não acessado!");
    }


    @Test(dependsOnMethods = "AcessaCarrinho")
    public void RealizaCheckout() {

        Assert.assertEquals(functions.ObterTexto(cartPage.ValorPrimeiroProdutoNoCarrinho) , "$29.99" , "Valor do primeiro produto difere do esperado!");
        Assert.assertEquals(functions.ObterTexto(cartPage.ValorSegundoProdutoNoCarrinho) , "$9.99" , "Valor do segundo produto difere do esperado!");

        functions.ClicaComponente(cartPage.BotaoCheckout);

        assertNotNull(cartPage.CampoFirstName, "Checkout não acessado!");

        functions.PreencheCampo(cartPage.CampoFirstName, cartPage.Nome);
        functions.PreencheCampo(cartPage.CampoLastName, cartPage.Sobrenome);
        functions.PreencheCampo(cartPage.CampoPostalCode, cartPage.CEP);

        functions.ClicaComponente(cartPage.BotaoContinue);
    }


    @Test(dependsOnMethods = "RealizaCheckout")
    public void FinalizaCompra() {

        Assert.assertEquals(functions.ObterTexto(cartPage.ValorTotalCompra),"Total: $43.18", "Valor total difere do esperado!");

        functions.ClicaComponente(cartPage.BotaoFinish);

        assertNotNull(cartPage.MensagemCompraFinalizada, "Compra não finalizada!");

        functions.ClicaComponente(cartPage.BotaoBackHome);
        functions.ExecutaLogout();

        System.out.println("Pedido finalizado com sucesso!");
    }


    @AfterTest
    public void FechaNavegador() {

        System.out.println("Teste finalizado com sucesso!");
        driver.quit();
    }
}
