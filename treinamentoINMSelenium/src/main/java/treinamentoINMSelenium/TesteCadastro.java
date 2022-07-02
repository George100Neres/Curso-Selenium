package treinamentoINMSelenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	
	private WebDriver driver;
	private  DomainEspecificLanguage dsl;
	
	@Before
	public void inicializa() {
		 driver = new ChromeDriver();
		driver.get("http://www.inmrobo.tk/accounts/login/");
		dsl = new  DomainEspecificLanguage(driver);
	}
	
	@Test
	public void deveValidarLoginComSucesso() {
		
		 dsl.escerverById("username", "treinamentoINM");
		// Abrindo o browser do googlechrome na tela de login do sistema
	     inicializa();
		//Thread.sleep(1500); tempo de espera antes de fechar o navegador
		driver.findElement(By.name("username")).sendKeys("treinamentoINM");
		driver.findElement(By.name("pass")).sendKeys("123456");
		driver.findElement(By.className("login100-btn")).click();
		
		Assert.assertEquals("NOVO FUNCIONARIO", driver.findElement(By.xpath("//[@id=\\\"navbarSupportedContent\\\"]/ul/li/a")).getText());
		
	}
   
	
	@Test
	public void deveValidarLoginSemSucesso() {
		
		WebDriver driver = new ChromeDriver();
	
		
		driver.findElement(By.name("username")).sendKeys("treinamentoINM");
		driver.findElement(By.name("pass")).sendKeys("1111111");
		driver.findElement(By.className("login100-btn")).click();
		
		Assert.assertTrue(driver.findElement(By.className("alert-danger")).getText().contains("ERRO! Usuario ou Senha Inválidos"));
		
	}
	
	public void deveValidarCadastroFuncionarioComSucesso() {
		
		WebDriver driver = new ChromeDriver();
		// Abrindo o browser do googlechrome na tela de login do sistema
		driver.get("http://www.inmrobo.tk/accounts/login/");
		//Thread.sleep(1500); tempo de espera antes de fechar o navegador
		driver.findElement(By.name("username")).sendKeys("treinamentoINM");
		driver.findElement(By.name("pass")).sendKeys("123456");
		driver.findElement(By.className("login100-btn")).click();
		
		driver.findElement(By.name("username")).sendKeys("treinamentoINM");
		// Informando senha
		driver.findElement(By.name("pass")).sendKeys("123456");
		 // Clica no botao ENTER
		driver.findElement(By.className("login100-btn")).click();
		
		// Clicar Novo Funcionário.
		driver.findElement(By.xpath("//[@id=\\\"navbarSupportedContent\\\"]/ul/li/a")).click();
		
		// Preencher Funcionario Aleatorio
		driver.findElement(By.id("inputNome")).sendKeys("Jairo" + 1 + (int) (Math.random() * 100000)+ "Vitar");
		driver.findElement(By.id("cpf")).sendKeys("225.052.470-48");
		
		// Criou  um Objeto
		WebElement elemento = driver.findElement(By.id("slcSexo"));
		// Criei uma LISTA desse objeto.
		Select combo = new Select(elemento);
		// preecheu o combo com o sexo Masculino
		combo.selectByVisibleText("Masculino");
		
		// Cadastro funcionario
		driver.findElement(By.id("inputAdmissao")).sendKeys("13-08-2018");
		driver.findElement(By.id("inputCargo")).sendKeys("Automatizado-Junior");
		driver.findElement(By.id("dinheiro")).sendKeys("3.000");
		driver.findElement(By.id("inputAdmissao")).sendKeys("13-08-2018");
		driver.findElement(By.id("clt")).click();
		
		// Clicar Botao enviar
		driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/input")).click();
		
		Assert.assertTrue(driver.findElement(By.className("alert-success")).getText().contains("SUCESSO! cadastrado com sucesso"));
		
		
	}
	
	public void finaliza() {
		driver.quit();
	}
}
