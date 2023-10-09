package PageObjects;

import org.openqa.selenium.By;

public class YourCartPage {

    // Objetos da página de Carrinho

    public By BotaoCheckout = By.id("checkout");

    public By BotaoContinueShopping = By.id("continue-shopping");

    public By RemoveProdutoNoCarrinho = By.id("remove-sauce-labs-backpack");

    public By ValorPrimeiroProdutoNoCarrinho = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");

    public By ValorSegundoProdutoNoCarrinho = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");


    // Checkout: Informações do usuário

    public By CampoFirstName = By.id("first-name");

    public By CampoLastName = By.id("last-name");

    public By CampoPostalCode = By.id("postal-code");

    public By BotaoContinue = By.id("continue");

    // Sua Informação

    public static String Nome = "Kauã";

    public static String Sobrenome = "Machado Grathwohl";

    public static String CEP = "00000-000";


    // Checkout: Overview

    public By BotaoFinish = By.id("finish");

    public By BotaoBackHome = By.id("back-to-products");

    public By MensagemCompraFinalizada = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

    public By ValorTotalCompra = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");


    // Checkout: Complete

    public By MensagemCompraFinalizadaComplete = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

}
