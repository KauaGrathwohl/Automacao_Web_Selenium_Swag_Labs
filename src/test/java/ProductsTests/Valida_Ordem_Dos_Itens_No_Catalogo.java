package ProductsTests;

import PageObjects.CartPage;
import PageObjects.LoginPage;
import PageObjects.ProductsPage;
import helpers.Functions;
import helpers.WebDriverConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/* Dado que eu esteja logado no site

    E acesso o menu principal de produtos

    E Ordeno os produtos por nome (A-Z)

    E Ordeno os produtos por nome (Z-A)

    E Ordeno os produtos por preço (baixo-alto)

    E Atualizo a página

    Então as ordenações devem estar de forma correta */

public class Valida_Ordem_Dos_Itens_No_Catalogo {

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

    @Test
    public void ValidaOrdenacaoAtoZ(){

        functions.ClicaComponente(productsPage.BotaoOrdenacao);

        productsPage.BotaoOrdenacao.equals(Keys.chord(Keys.CONTROL, "home"));

        Assert.assertEquals(functions.ObterTexto(productsPage.DescricaoPrimeiroProduto), "Sauce Labs Backpack", "Ordenação do item diferente do esperado!");

    }


    @Test(dependsOnMethods = "ValidaOrdenacaoAtoZ")
    public void ValidaOrdenacaoZtoA(){

        functions.ClicaComponente(productsPage.BotaoOrdenacao);

        productsPage.BotaoOrdenacao.equals(Keys.chord(Keys.CONTROL, "down"));

        Assert.assertEquals(functions.ObterTexto(productsPage.DescricaoPrimeiroProduto), "Test.allTheThings() T-Shirt (Red)", "Ordenação do item diferente do esperado!");

    }


    @Test(dependsOnMethods = "ValidaOrdenacaoZtoA")
    public void ValidaOrdenacaoLowtoHigh(){

        functions.ClicaComponente(productsPage.BotaoOrdenacao);

        productsPage.BotaoOrdenacao.equals(Keys.chord(Keys.CONTROL, "down, down"));

        Assert.assertEquals(functions.ObterTexto(productsPage.DescricaoPrimeiroProduto), "Sauce Labs Onesie", "Ordenação do item diferente do esperado!");
    }


    @Test(dependsOnMethods = "ValidaOrdenacaoLowtoHigh")
    public void ValidaOrdenacaoHightoLow(){

        functions.ClicaComponente(productsPage.BotaoOrdenacao);

        productsPage.BotaoOrdenacao.equals(Keys.chord(Keys.CONTROL, "end"));

        Assert.assertEquals(functions.ObterTexto(productsPage.DescricaoPrimeiroProduto), "Sauce Labs Fleece Jacket", "Ordenação do item diferente do esperado!");

    }


    @AfterTest
    public void FechaNavegador(){
        System.out.println("Casos de testes de ordenação finalizados");
        driver.quit();
    }










}

