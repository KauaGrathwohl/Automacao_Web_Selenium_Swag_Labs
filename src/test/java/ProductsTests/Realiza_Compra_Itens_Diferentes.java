package ProductsTests;

import PageObjects.LoginPage;
import PageObjects.ProductsPage;
import PageObjects.YourCartPage;
import helpers.Functions;
import helpers.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;


 /* Dado que eu esteja logado no site

    E desejo fazer uma compra de 2 itens diferentes

    Quando eu selecionar os itens

    E adicionar ao carrinho

    E finalizar a compra

    Então a compra deve ser realizada com sucesso */


public class Realiza_Compra_Itens_Diferentes {

    WebDriver driver =
            WebDriverConfig.Instance().driver;

    Functions functions = new Functions();

    LoginPage loginPage = new LoginPage();

    ProductsPage productsPage = new ProductsPage();

    YourCartPage yourCartPage = new YourCartPage();


    @Test(groups = "Realiza_Compra_Itens_Diferentes")
    public void ConfiguracaoInicial() {

        functions.LoginStardardUser();

        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.err.println("Login não realizado! Existe algum problema com usuário e senha!");
        }
    }


    @Test(dependsOnMethods = "ConfiguracaoInicial")
    public void AdicionaItensNoCarrinho() {

        functions.ClicaComponente(productsPage.BotaoAddToCartBackpack);
        functions.ClicaComponente(productsPage.BotaoAddToCartBikeLight);

        if (productsPage.BotaoRemoveBackpack == null) {
            System.err.println("Item Backpack não adicionado ao carrinho!");
        }

        if (productsPage.BotaoRemoveBikeLight == null) {
            System.err.println("Item Bike Light não adicionado ao carrinho!");
        }

        System.out.println("Itens adicionados ao carrinho com sucesso!");
    }


    @Test(dependsOnMethods = "AdicionaItensNoCarrinho")
    public void AcessaCarrinho() {
        functions.ClicaComponente(productsPage.BotaoCarrinho);

        if (yourCartPage.BotaoCheckout == null) {
            System.err.println("Carrinho não acessado!");
        }
    }


    @Test(dependsOnMethods = "AcessaCarrinho")
    public void RealizaCheckout() {

        assertEquals("$29.99" , functions.ObterTexto(yourCartPage.ValorPrimeiroProdutoNoCarrinho));

        assertEquals("$9.99" , functions.ObterTexto(yourCartPage.ValorSegundoProdutoNoCarrinho));

        functions.ClicaComponente(yourCartPage.BotaoCheckout);

        if (yourCartPage.CampoFirstName == null) {
            System.err.println("Checkout não acessado!");
        }

        functions.PreencheCampo(yourCartPage.CampoFirstName, yourCartPage.Nome);
        functions.PreencheCampo(yourCartPage.CampoLastName, yourCartPage.Sobrenome);
        functions.PreencheCampo(yourCartPage.CampoPostalCode, yourCartPage.CEP);

        functions.ClicaComponente(yourCartPage.BotaoContinue);
    }


    @Test(dependsOnMethods = "RealizaCheckout")
    public void FinalizaCompra() {

        assertEquals("Total: $43.18" , functions.ObterTexto(yourCartPage.ValorTotalCompra));

        functions.ClicaComponente(yourCartPage.BotaoFinish);

        if (yourCartPage.MensagemCompraFinalizada == null) {
            System.err.println("Compra não finalizada!");
        }

        functions.ClicaComponente(yourCartPage.BotaoBackHome);

        functions.ExecutaLogout();

        System.out.println("Pedido finalizado com sucesso!");
    }


    @AfterTest
    public void FechaNavegador() {
        driver.quit();
    }
}
