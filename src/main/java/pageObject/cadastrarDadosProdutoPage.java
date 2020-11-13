package pageObject;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import util.DriverFactory;

public class cadastrarDadosProdutoPage {

	@FindBy(how = How.ID, using = "enterproductdata")
	public WebElement abaAtiva;

	@FindBy(how = How.XPATH, using = "//*[@id='idealsteps-nav']/ul/li[3]")
	public WebElement getValue;

	@FindBy(how = How.ID, using = "startdate")
	public WebElement calendarStartDate;

	@FindBy(how = How.ID, using = "insurancesum")
	public WebElement selectInsurance;
	
	@FindBy(how = How.ID, using = "meritrating")
	public WebElement selectMerit;
	
	@FindBy(how = How.ID, using = "damageinsurance")
	public WebElement selectDamage;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span")
	public WebElement optionalProducts;
	
	@FindBy(how = How.ID, using = "courtesycar")
	public WebElement selectCourtesy;
	
	@FindBy(how = How.ID, using = "nextselectpriceoption")
	public WebElement buttonNext;

	/**
	 * Metodos para validação do formulário de Produtos
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

	public void preencherFormularioProduct() {
		calendarStartDate.clear();
		calendarStartDate.sendKeys("12/01/2021");
		
		selectInsurance.click();
		Select insuranceCombo = new Select(selectInsurance);
		insuranceCombo.selectByValue("5000000");
		
		selectMerit.click();
		Select meritCombo = new Select(selectMerit);
		meritCombo.selectByValue("Bonus 3");
		
		selectDamage.click();
		Select damageCombo = new Select(selectDamage);
		damageCombo.selectByValue("Partial Coverage");
		
		optionalProducts.click();
		assertTrue(optionalProducts.isEnabled());
		
		selectCourtesy.click();
		Select courtesyCombo = new Select(selectCourtesy);
		courtesyCombo.selectByValue("Yes");

		buttonNext.click();
		
	}

}
