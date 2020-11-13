package pageObject;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.DriverFactory;

public class cadastrarDadosPrecoPage {

	@FindBy(how = How.ID, using = "selectpriceoption")
	public WebElement abaAtiva;

	@FindBy(how = How.XPATH, using = "//*[@id='idealsteps-nav']/ul/li[4]")
	public WebElement getValue;

	@FindBy(how = How.XPATH, using = "//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[2]/span")
	public WebElement selectPrice;

	@FindBy(how = How.ID, using = "nextsendquote")
	public WebElement buttonNext;

	/**
	 * Métodos para validar o formulário de preços
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

	public void preencherFormularioPrice() {
		selectPrice.click();
		assertTrue(selectPrice.isEnabled());

		buttonNext.click();

	}

}
