package LoginTests;

import PageObjects.LoginPage;
import helpers.Functions;
import helpers.WebDriverConfig;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Valida_Usuario_Correto {

    WebDriver driver =
            WebDriverConfig.Instance().driver;

    Functions functions = new Functions();

    LoginPage loginPage = new LoginPage();


    @Test
    public void LoginStardardUser() {

        functions.PreencheCampo(loginPage.Usuario, loginPage.UsuarioPadrao);
        functions.PreencheCampo(loginPage.Senha, loginPage.SenhaPadrao);
        functions.ClicaComponente(loginPage.BotaoLogin);

        driver.manage().timeouts().implicitlyWait(2, java.util.concurrent.TimeUnit.SECONDS);

        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.err.println("Login não realizado! Existe algum problema com usuário e senha!");
        }

        functions.ExecutaLogout();
    }
}
