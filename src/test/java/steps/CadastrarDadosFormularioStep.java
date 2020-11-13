package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pageObject.cadastrarDadosCotacaoPage;
import pageObject.cadastrarDadosPrecoPage;
import pageObject.cadastrarDadosProdutoPage;
import pageObject.cadastrarDadosSeguradoraPage;
import pageObject.cadastrarDadosVeiculoPage;
import util.DriverFactory;
import util.PropertyReader;

public class CadastrarDadosFormularioStep {

	cadastrarDadosVeiculoPage cadastrarVeiculoPage = new cadastrarDadosVeiculoPage();
	cadastrarDadosSeguradoraPage cadastrarSeguradoraPage = new cadastrarDadosSeguradoraPage();
	cadastrarDadosProdutoPage cadastrarProdutoPage = new cadastrarDadosProdutoPage();
	cadastrarDadosPrecoPage cadastrarPrecoPage = new cadastrarDadosPrecoPage();
	cadastrarDadosCotacaoPage cadastrarCotacaoPage = new cadastrarDadosCotacaoPage();

	WebDriverWait wait = null;
	DriverFactory factory = new DriverFactory();

	static WebDriver driver;

	public CadastrarDadosFormularioStep() throws Exception {
		driver = DriverFactory.driver;
		if (driver == null) {
			driver = factory.openBrowser();
		}

		cadastrarVeiculoPage = PageFactory.initElements(driver, cadastrarDadosVeiculoPage.class);
		cadastrarSeguradoraPage = PageFactory.initElements(driver, cadastrarDadosSeguradoraPage.class);
		cadastrarProdutoPage = PageFactory.initElements(driver, cadastrarDadosProdutoPage.class);
		cadastrarPrecoPage = PageFactory.initElements(driver, cadastrarDadosPrecoPage.class);
		cadastrarCotacaoPage = PageFactory.initElements(driver, cadastrarDadosCotacaoPage.class);
	}

	@Dado("que acesse a url do site")
	public void queAcesseAUrlDoSite() {

		driver.get(new PropertyReader().readProperty("host.sampleapp"));

	}

	@Quando("preencho o formulário de veiculos, aba {string} e pressiono o botão next")
	public void preencherFormularioVehicle(String nomeAba) {

		cadastrarVeiculoPage.validarAbaAtiva(nomeAba);
		cadastrarVeiculoPage.preencherFormularioVehicle();
	}

	@Quando("preencho o formulário de seguradora, aba {string} e pressiono o botão next")
	public void preencherFormularioSeguradora(String nomeAba) {

		cadastrarSeguradoraPage.validarAbaAtiva(nomeAba);
		cadastrarSeguradoraPage.preencherFormularioInsurant();

	}

	@Quando("preencho o formulário de produto, aba {string} e pressiono o botão next")
	public void preencherFormularioProduto(String nomeAba) {

		cadastrarProdutoPage.validarAbaAtiva(nomeAba);
		cadastrarProdutoPage.preencherFormularioProduct();
	}

	@Quando("preencho o formulário de preço, aba {string} e pressiono o botão next")
	public void preencherFormularioPreco(String nomeAba) {

		cadastrarPrecoPage.validarAbaAtiva(nomeAba);
		cadastrarPrecoPage.preencherFormularioPrice();
	}

	@Quando("preencho o formulário de cotação, aba {string} e pressiono o botão next")
	public void preencherFormularioCotacao(String nomeAba) {

		cadastrarCotacaoPage.validarAbaAtiva(nomeAba);
		cadastrarCotacaoPage.preencherFormularioQuote();
	}

	@Então("devo receber a mensagem de sucesso {string}")
	public void devoReceberAMensagemDeSucesso(String mensagemSucesso) {

		cadastrarCotacaoPage.validarMensagemRetorno(mensagemSucesso);

	}

	@Before
	public void beforScenario() {
		System.out.println("---------------- Iniciando Cenário----------------");

	}

	@After
	public void afterScenario() {
		System.out.println("---------------- Finalizando Cenário----------------");
		driver.quit();
	}

}
