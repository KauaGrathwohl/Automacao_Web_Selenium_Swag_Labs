package helpers;

import PageObjects.LoginPage;
import PageObjects.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Functions {

    WebDriver driver =
            WebDriverConfig.Instance().driver;

    ProductsPage productsPage = new ProductsPage();

    LoginPage loginPage = new LoginPage();

    // Função para preencher algum campo em específico

    public void PreencheCampo(By identificador, String texto) {

        WebElement componente = RetornaValor(identificador);
        componente.sendKeys(texto);
    }


    // Função para clicar em algum elemento em específico

    public void ClicaComponente(By identificador) {

        WebElement componente = RetornaValor(identificador);
        componente.click();
    }


    // Função para retornar o texto de algum elemento em específico

    public WebElement RetornaValor(By identificador) {

        WebElement componente = driver.findElement(identificador);
        return componente;
    }


    // Função para obter o texto de um objeto

    public String ObterTexto(By identificador) {
        WebElement componente = RetornaValor(identificador);
        return componente.getText();
    }


    // Função para dar logout no site quando necessário

    public void ExecutaLogout(){
        ClicaComponente(productsPage.BotaoMenuLateral);
        driver.manage().timeouts().implicitlyWait(2, java.util.concurrent.TimeUnit.SECONDS);
        ClicaComponente(productsPage.BotaoLogout);
    }

    // Limpa campo desejado

    public void LimpaCampo(By identificador) {
        WebElement componente = RetornaValor(identificador);
        componente.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }

    // Função para realizar login com usuário padrão

    public void LoginStardardUser() {

        PreencheCampo(loginPage.Usuario, loginPage.UsuarioPadrao);
        PreencheCampo(loginPage.Senha, loginPage.SenhaPadrao);
        ClicaComponente(loginPage.BotaoLogin);
    }
}
