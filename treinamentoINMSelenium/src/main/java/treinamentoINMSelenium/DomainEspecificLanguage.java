package treinamentoINMSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DomainEspecificLanguage {

	
	private WebDriver driver;
	
	public DomainEspecificLanguage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escerverById(String IdCampo, String texto) {
		driver.findElement(By.name(IdCampo)).sendKeys(texto);
	}
}

