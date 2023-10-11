package PageObjects;

import org.openqa.selenium.By;

public class ProductsPage {

    // Objetos da página de Produtos

    public By TituloPagina = By.xpath("//span[@class='title']");


    // Objetos relacionados aos itens

    public By BotaoAddToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");

    public By BotaoAddToCartBikeLight = By.id("add-to-cart-sauce-labs-bike-light");

    public By BotaoRemoveBackpack = By.id("remove-sauce-labs-backpack");

    public By BotaoRemoveBikeLight = By.id("remove-sauce-labs-bike-light");



    // Acessa carrinho de compras

    public By BotaoCarrinho = By.xpath("//a[@class='shopping_cart_link']");


    // Botões menu lateral

    public By BotaoMenuLateral = By.id("react-burger-menu-btn");

    public By BotaoLogout = By.id("logout_sidebar_link");

    public By BotaoResetApp = By.id("reset_sidebar_link");

    public By BotaoX = By.id("react-burger-cross-btn");

    public By BotaoTodosOsItens = By.id("inventory_sidebar_link");

    public By BotaoSobre = By.id("about_sidebar_link");


    //  Objetos de ordenação

    public By BotaoOrdenacao = By.xpath("//select[@class='product_sort_container']");

    public By DescricaoPrimeiroProduto = By.xpath("//*[@id=\"item_4_title_link\"]/div");

}
