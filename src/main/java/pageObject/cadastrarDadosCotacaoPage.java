package pageObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.DriverFactory;

public class cadastrarDadosCotacaoPage {

	@FindBy(how = How.ID, using = "sendquote")
	public WebElement abaAtiva;

	@FindBy(how = How.XPATH, using = "//*[@id='idealsteps-nav']/ul/li[5]")
	public WebElement getValue;

	@FindBy(how = How.ID, using = "email")
	public WebElement inputEmail;

	@FindBy(how = How.ID, using = "phone")
	public WebElement inputPhone;

	@FindBy(how = How.ID, using = "username")
	public WebElement inputUsername;

	@FindBy(how = How.ID, using = "password")
	public WebElement inputPassword;

	@FindBy(how = How.ID, using = "confirmpassword")
	public WebElement inputConfirmPassword;

	@FindBy(how = How.ID, using = "sendemail")
	public WebElement buttonNext;

	@FindBy(how = How.XPATH, using = "/html/body/div[4]/h2")
	public WebElement retornoMsgm;

	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[7]/div/button")
	public WebElement buttonConfirm;

	/**
	 * Método para validação do formulário de cotação
	 * 
	 * @param nomeAba
	 */

	public void validarAbaAtiva(String nomeAba) {
		DriverFactory.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String abaValue = abaAtiva.getText();
		String expectValue = nomeAba;

		// Validação atributo esta ativo e o valor da aba
		assertTrue("A aba Selecionada não está ativa: ", getValue.getAttribute("class").contains("step-active"));
		assertTrue("Aba selelecionada não contém o titulo correto ", abaValue.contains(expectValue));
	}

	public void preencherFormularioQuote() {

		inputEmail.clear();
		inputEmail.sendKeys("rafaeltulio9@gmail.com");

		inputPhone.clear();
		inputPhone.sendKeys("41991674122");

		inputUsername.clear();
		inputUsername.sendKeys("rafael.tulio");

		inputPassword.clear();
		inputPassword.sendKeys("Teste@2020");

		inputConfirmPassword.clear();
		inputConfirmPassword.sendKeys("Teste@2020");

		buttonNext.click();
	}

	public void validarMensagemRetorno(String mensagemSucesso) {
		DriverFactory.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(retornoMsgm.getText());

		assertEquals(mensagemSucesso, retornoMsgm.getText());

		buttonConfirm.click();

	}

}
