package pageObject;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import util.DriverFactory;

public class cadastrarDadosVeiculoPage {

	@FindBy(how = How.ID, using = "entervehicledata")
	public WebElement abaAtiva;

	@FindBy(how = How.XPATH, using = "//*[@id='idealsteps-nav']/ul/li[1]")
	public WebElement getValue;

	@FindBy(how = How.ID, using = "make")
	public WebElement selectMake;

	@FindBy(how = How.ID, using = "model")
	public WebElement selectModel;

	@FindBy(how = How.ID, using = "cylindercapacity")
	public WebElement inputCylinder;

	@FindBy(how = How.ID, using = "engineperformance")
	public WebElement inputEngine;

	@FindBy(how = How.ID, using = "opendateofmanufacturecalender")
	public WebElement calendar;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[1]/a")
	public WebElement dateCalendar;

	@FindBy(how = How.ID, using = "numberofseats")
	public WebElement number;

	@FindBy(how = How.XPATH, using = "//*[@id=\"insurance-form\"]/div/section[1]/div[7]/p/label[1]/span")
	public WebElement handDriveYes;

	@FindBy(how = How.ID, using = "numberofseatsmotorcycle")
	public WebElement numberofSeats;

	@FindBy(how = How.ID, using = "fuel")
	public WebElement selectFuel;

	@FindBy(how = How.ID, using = "payload")
	public WebElement payload;

	@FindBy(how = How.ID, using = "totalweight")
	public WebElement totalweight;

	@FindBy(how = How.ID, using = "listprice")
	public WebElement listprice;

	@FindBy(how = How.ID, using = "licenseplatenumber")
	public WebElement licenseplatenumber;

	@FindBy(how = How.ID, using = "annualmileage")
	public WebElement annualmileage;

	@FindBy(how = How.ID, using = "nextenterinsurantdata")
	public WebElement buttonNext;

	/***
	 *  Metodos para validar funcionalidades dos campos
	 * @param nomeAba
	 */
	
	public void validarAbaAtiva(String nomeAba) {
		DriverFactory.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String abaValue = abaAtiva.getText();
		String expectValue = nomeAba;

		// Validação atributo esta ativo e o valor da aba
		assertTrue("A aba Selecionada não está ativa: ", getValue.getAttribute("class").contains("step-active"));
		assertTrue("Aba selelecionada não contém o valor: ", abaValue.contains(expectValue));

	}

	public void preencherFormularioVehicle() {
		selectMake.click();
		Select makeCombo = new Select(selectMake);
		makeCombo.selectByValue("Audi");

		selectModel.click();
		Select modelCombo = new Select(selectModel);
		modelCombo.selectByValue("Motorcycle");

		inputCylinder.clear();
		inputCylinder.sendKeys("1500");

		inputEngine.sendKeys("280");

		calendar.click();
		dateCalendar.click();

		number.click();
		Select numberSeats = new Select(number);
		numberSeats.selectByIndex(2);

		handDriveYes.click();

		numberofSeats.click();
		Select numberOfSeats = new Select(numberofSeats);
		numberOfSeats.selectByIndex(3);

		selectFuel.click();
		Select fuel = new Select(selectFuel);
		fuel.selectByValue("Petrol");

		payload.clear();
		payload.sendKeys("200");

		totalweight.clear();
		totalweight.sendKeys("100");

		listprice.clear();
		listprice.sendKeys("600");

		licenseplatenumber.clear();
		licenseplatenumber.sendKeys("50");

		annualmileage.clear();
		annualmileage.sendKeys("100");

		buttonNext.click();
	}

}
