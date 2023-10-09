package LoginTests;

import PageObjects.LoginPage;
import helpers.Functions;
import helpers.WebDriverConfig;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Valida_Usuario_Bloqueado {

    WebDriver driver =
            WebDriverConfig.Instance().driver;

    Functions functions = new Functions();

    LoginPage loginPage = new LoginPage();


    @Test
    public void LoginLockedOutUser() {

        functions.PreencheCampo(loginPage.Usuario, loginPage.UsuarioBloqueado);
        functions.PreencheCampo(loginPage.Senha, loginPage.SenhaPadrao);
        functions.ClicaComponente(loginPage.BotaoLogin);

        driver.manage().timeouts().implicitlyWait(2, java.util.concurrent.TimeUnit.SECONDS);;

        if (functions.ObterTexto(loginPage.MensagemErroLogin).equals("Epic sadface: Sorry, this user has been locked out.")) {
            System.out.println("Usuário bloqueado!");
            functions.ClicaComponente(loginPage.ButtonXMensagemErro);
        } else {
            System.err.println("Usuário não bloqueado! Validação incorreta da mensagem de erro!");
        }

        System.out.println("Teste finalizado!");
    }
}