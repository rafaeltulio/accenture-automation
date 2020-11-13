package util;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generica {

	private String mensagem = "";
	Logger logger = Logger.getLogger(Generica.class.toString());
	WebDriverWait wait;


	
	/**
	 * CARREGA UMA LISTA DE TAG DO TIPO BUTTON E VERIFICA O ATIVO
	 * 
	 * @param driver
	 * @param nomeBotao
	 */
	public void clicarButton(WebDriver driver, String nomeBotao) {
		List<WebElement> listaButton = driver.findElements(By.tagName("button"));
		for (WebElement w : listaButton) {
			System.out.println("chegou button");
			if (w.getText().equals(nomeBotao) && w.isDisplayed()) {
				w.click();
				break;
			}
		}
	}

	/**
	 * Método para buscar lh
	 * 
	 * @param driver
	 * @return
	 */

	public String recuperarMensagemTitle(WebDriver driver) {
		WebElement msn = driver.findElement(By.tagName("p-growl"));		
		return msn.findElement(By.tagName("p")).getText().toString();
	}

	public Object recuperaMensagemCampos(WebDriver driver) {
		List<WebElement> listaMensagem = driver.findElements(By.tagName("app-message"));
		
		for (WebElement w : listaMensagem) {
			if (!w.getText().isEmpty()) {
				mensagem = w.getText();
				break;
			}
		}
		return mensagem;
	}

	public void rolarScroll(WebDriver driver) throws InterruptedException {
		Actions clicker = new Actions(driver);
		clicker = new Actions(driver);
		clicker.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		clicker.click().perform();
	}
}
