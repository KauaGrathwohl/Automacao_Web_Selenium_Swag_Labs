package LoginTests;

import PageObjects.LoginPage;
import PageObjects.ProductsPage;
import helpers.Functions;
import helpers.WebDriverConfig;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Valida_Usuario_Performance {

    WebDriver driver =
            WebDriverConfig.Instance().driver;

    Functions functions = new Functions();

    LoginPage loginPage = new LoginPage();

    ProductsPage productsPage = new ProductsPage();

    @Test
    public void LoginPerformanceGlitchUser() throws InterruptedException {

        if ((functions.ObterTexto(loginPage.Usuario) != "") || (functions.ObterTexto(loginPage.Senha) != "")) {

            functions.LimpaCampo(loginPage.Usuario);
            functions.LimpaCampo(loginPage.Senha);
        }

        // Insere novamente usuário e senha

        functions.PreencheCampo(loginPage.Usuario, loginPage.UsuarioPerformance);
        functions.PreencheCampo(loginPage.Senha, loginPage.SenhaPadrao);
        functions.ClicaComponente(loginPage.BotaoLogin);

        // Verifica se o botão do menu lateral está disponível

        if (productsPage.BotaoMenuLateral == null) {
            System.err.println("Login não realizado! Tempo de espera do carregamento do site maior que o esperado!");
        }

        functions.ExecutaLogout();
    }

    public void FechaNavegador() {
        System.out.println("Testes de login finalizados com sucesso!");
        driver.quit();
    }
}
