package PageObjects;

import org.openqa.selenium.By;

public class LoginPage {

    // Objetos da página de Login

    public By Usuario = By.id("user-name");

    public By Senha = By.id("password");

    public By BotaoLogin = By.id("login-button");

    public By MensagemErroLogin = By.xpath("//h3[@data-test='error']");

    public By MensagemErroUsuario = By.xpath("//h3[@data-test='error']");

    public By ButtonXMensagemErro = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button");


    /* Senhas e usuários válidos */

    // Usuários

    public static final String UsuarioPadrao = "standard_user";

    public static final String UsuarioBloqueado = "locked_out_user";

    public static final String UsuarioProblema = "problem_user";

    public static final String UsuarioPerformance = "performance_glitch_user";


    // Senha

    public static final String SenhaPadrao = "secret_sauce";
}
