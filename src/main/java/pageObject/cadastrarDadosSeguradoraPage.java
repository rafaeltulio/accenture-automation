package pageObject;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import util.DriverFactory;

public class cadastrarDadosSeguradoraPage {

	@FindBy(how = How.ID, using = "enterinsurantdata")
	public WebElement abaAtiva;
	
	@FindBy(how = How.XPATH, using = "//*[@id='idealsteps-nav']/ul/li[2]")
	public WebElement getValue;
	
	@FindBy(how = How.ID, using = "firstname")
	public WebElement inputFirstName;
	
	@FindBy(how = How.ID, using = "lastname")
	public WebElement inputLastName;
	
	@FindBy(how = How.ID, using = "birthdate")
	public WebElement inputCalendar;
	
	@FindBy(how = How.ID, using = "country")
	public WebElement selectCountry;
	
	@FindBy(how = How.ID, using = "zipcode")
	public WebElement zipCode;
	
	@FindBy(how = How.ID, using = "occupation")
	public WebElement selectOcupation;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]/span")
	public WebElement hobbies;
	
	@FindBy(how = How.ID, using = "nextenterproductdata")
	public WebElement buttonNext;
	
	/**
	 * Métodos para validação do formulário de seguradora
	 * @param nomeAba
	 */
	
	public void validarAbaAtiva(String nomeAba) {
		DriverFactory.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String abaValue = abaAtiva.getText();
		String expectValue = nomeAba;

		// Validação atributo esta ativo e o valor da aba
		assertTrue("A aba Selecionada não está ativa: ", getValue.getAttribute("class").contains("step-active"));
		assertTrue("Aba selelecionada não contém o titulo correto: ", abaValue.contains(expectValue));

	}

	public void preencherFormularioInsurant() {

		inputFirstName.clear();
		inputFirstName.sendKeys("Rafael");
		
		inputLastName.clear();
		inputLastName.sendKeys("Tulio");
		
		inputCalendar.clear();
		inputCalendar.sendKeys("02/22/1987");
		
		selectCountry.click();
		Select countryCombo = new Select(selectCountry);
		countryCombo.selectByValue("Brazil");
		
		zipCode.clear();
		zipCode.sendKeys("82920030");
		
		selectOcupation.click();
		Select ocupationCombo = new Select(selectOcupation);
		ocupationCombo.selectByValue("Public Official");
		
		hobbies.click();
		assertTrue(hobbies.isEnabled());
		
		buttonNext.click();
	}

}
