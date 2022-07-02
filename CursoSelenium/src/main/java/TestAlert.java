import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAlert {
    
	private WebDriver driver;
	
	@Before // Antes da cada teste,execute o conteudo desse metodo.
	public void inicializa() {
     driver = new FirefoxDriver();
     driver.manage().window().setSize(new Dimension(1200, 765));
     driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	}  
	
	@After // Ele e executado apos cada um dos Testes. 
	public void finaliza() {
		
	}
	
	
	@Test
	public void deveInteragirComAlertSimples() {
		
	
	driver.findElement(By.id("alert")).click();
	Alert alert = driver.switchTo().alert();
	String texto = alert.getText(); // armazena a variavel do alerta.
	assertEquals("Alert Simples", texto);
	alert.accept();
	driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}
	
	@Test
	public void deveInteragirComAlertCOnfirm() {
		
	
	// IF
	driver.findElement(By.id("confirm")).click();
	Alert alerta = driver.switchTo().alert();
	Assert.assertEquals("Confirm Simples", alerta.getText());
	alerta.accept();
	Assert.assertEquals("Confirmado", alerta.getText());
	alerta.accept();
	
	// ELSE
	driver.findElement(By.id("confirm")).click();
	 alerta = driver.switchTo().alert();
	Assert.assertEquals("Confirm Simples", alerta.getText());
	alerta.dismiss(); // negado
	Assert.assertEquals("Negado", alerta.getText());
	alerta.dismiss();

	
	}
	
	
	@Test
	public void deveInteragirComAlertPrompt() {

	
	driver.findElement(By.id("prompt")).click();
	Alert alerta = driver.switchTo().alert();
	Assert.assertEquals("Digite um numero", alerta.getText());
	alerta.sendKeys("123");
	alerta.accept();
	Assert.assertEquals("Era 123?", alerta.getText());
	alerta.accept();
	Assert.assertEquals(":D", alerta.getText());
	alerta.accept();
	
	}
	
}
