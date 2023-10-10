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

import static org.testng.Assert.assertNotNull;

/* Dado que eu esteja logado no site

    E desejo fazer uma compra sem itens

    Quando eu ir para o carrinho

    E tente finalizar a compra

    Então a compra não deve ser realizada com sucesso */

public class Não_Deve_Permitir_Compra_Sem_Itens {

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
    public void AcessaCarrinho() {
        functions.ClicaComponente(productsPage.BotaoCarrinho);

        assertNotNull(cartPage.BotaoCheckout, "Carrinho não acessado!");

    }

    @Test(dependsOnMethods = "AcessaCarrinho")
    public void RealizaCheckout() {

        functions.ClicaComponente(cartPage.BotaoCheckout);

        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html")) {

            System.err.println("--------------------------------------------------------------------------------------");
            System.err.println("Checkout realizado, porém deveria ter uma tranca para não permitir a compra sem itens!");
            System.err.println("--------------------------------------------------------------------------------------");

        }
        else {
            System.out.println("Checkout não realizado! Problemas com o checkout!");
        }
    }

    @AfterTest
    public void FechaNavegador() {
        System.out.println("Teste finalizado com sucesso!");
        driver.quit();
    }
}

