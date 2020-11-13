package util;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver = null;
	DesiredCapabilities capabilities = null;
	static Logger logger = Logger.getLogger(DriverFactory.class.toString());

	/**
	 * Métodod para retornar a instância do WebDriver
	 * 
	 * @throws Exception
	 */

	public WebDriver openBrowser() throws Exception {
		System.setProperty("webdriver.chrome.verboseLogging", "false");
		if (driver != null) {
			return driver;
		}
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = "chrome";
		}
		if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			capabilities = DesiredCapabilities.internetExplorer();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			capabilities = DesiredCapabilities.firefox();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			capabilities = DesiredCapabilities.chrome();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--browser-test");
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		}

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		if (driver == null) {
			throw new Exception("Browser inválido: " + browser);

		}

		return driver;
	}

	/**
	 * Método que executa a finalização da execução dos testes
	 * 
	 * @param scenario
	 * @throws ClassNotFoundException
	 */
	@After
	public void embedScreenshot() throws Exception {

		if (driver != null) {
			driver.quit();
			driver = null;
		}

		logger.info("Teste finalizado......");
	}

}
