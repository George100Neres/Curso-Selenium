import org.junit.After;´

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
  /*
	@Test
	public void deveInteragirComAlertSimples() {
		
	 WebDriver driver = new FirefoxDriver();
	 driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

	 // Preechendo o formulario Nome
	driver.findElement(By.id("elementosForm:nome")).sendKeys("George");
	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Conta da Steam");
	driver.findElement(By.id("elementosForm:sexo:0")).click();
	driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
	driver.findElement(By.id("elementosForm:escolaridade")).click();
	new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");
	
	new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Futebol");
	
	// cadastrar
	driver.findElement(By.id("elementosForm:cadastrar")).click();
	
	// resltado do cadastro
	// Qunaodpegar o texto inteiro, verifico se inicia com o Cadastrado. Olhando so o inicio
	Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
	// Verifica so o texto Final
	Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("George"));
	Assert.assertEquals("Sobrenome: Conta da Steam", driver.findElement(By.id("descSobrenome")).getText());
	Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
	Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
	Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
	Assert.assertEquals("Esportes: Futebol", driver.findElement(By.id("descEsportes")).getText());

	}
	
	
	@Test
	public void deveValidarNomeObrigatorio() {
		
	 WebDriver driver = new FirefoxDriver();
	 driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.id("elementosForm:cadastrar")).sendKeys("Nome qualquer");
	driver.findElement(By.id("elementosForm:cadastrar")).click(); //  Usuario clicar no botao Cadastrar
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals("Nome eh obrigatorio", alert.getText());
	
   }
	
	@Test
	public void deveValidarSobreNomeObrigatorio() {
		
	 WebDriver driver = new FirefoxDriver();
	 driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	driver.findElement(By.id("elementosForm:cadastrar")).sendKeys("Nome qualquer");
	driver.findElement(By.id("elementosForm:cadastrar")).click(); // Usuario clicar no botao Cadastrar
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals("Nome eh obrigatorio", alert.getText());
	
	
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		
	 WebDriver driver = new FirefoxDriver();
	 driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	//Apos cadastrar,tenho que preencher um nome.
	driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
	driver.findElement(By.id("elementosForm:cadastrar")).click(); // Usuario clicar no botao Cadastrar
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals("Nome eh obrigatorio", alert.getText());
	
	
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		
	 WebDriver driver = new FirefoxDriver();
	 driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	//Apos cadastrar,tenho que preencher um nome.
	driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
	driver.findElement(By.id("elementosForm:sexo:1")).click();
	driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
	driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
	
	driver.findElement(By.id("elementosForm:cadastrar")).click(); // Usuario clicar no botao Cadastrar
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
	
	
	}
	
	
	@Test
	public void deveValidarEsportistaIndeciso() {
		
	 WebDriver driver = new FirefoxDriver();
	 driver.manage().window().setSize(new Dimension(1200, 765));
	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
	//Apos cadastrar,tenho que preencher um nome.
	driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
	driver.findElement(By.id("elementosForm:sexo:1")).click();
	driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
	//Obs: O select combo so da pra escolher um tipo de opção
	Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
	combo.selectByVisibleText("Karate");
	combo.selectByVisibleText("O que eh esporte?");
	driver.findElement(By.id("elementosForm:cadastrar")).click(); // Usuario clicar no botao Cadastrar
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
	
	
	} */
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	
	@Before
	public void inicializa() {
	     driver = new FirefoxDriver();
	     driver.manage().window().setSize(new Dimension(1200, 765));
	     driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		 dsl = new DSL (driver);
		 page = new CampoTreinamentoPage(driver);
		}  
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	public void deveRealizarCadastroComSucesso() {
		page.setNome("George");
		page.setSobrenome("Conta da Steam");
		page.setsexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsportes("Natacao");
		page.cadastrar();
		
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Conta da Steam"));
		Assert.assertEquals("Sobrenome: Conta da Steam", page.obterSobreNomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza",page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("desEsportes")).getText());
		
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio",dsl.alertaObterTextoEAceita());
	}
	
	
	@Test
	public void deveValidarSobreNomeObrigatorio() {
		page.setNome("Nome qualquer");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio",dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		dsl.escreve("elementosForm:nome", "Nome qualquer");
		dsl.escreve("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clicarBotao("elementosForm:nome:cadastar");
		Assert.assertEquals("Sexo eh obrigatorio",dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarComidaVegetariano() {
		page.setNome("Nome qualquer");
		page.setSobrenome("SobreNome qualquer");
		page.setsexoFeminino();
		page.setComidaVegetariano();
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?",dsl.alertaObterTextoEAceita());
	}
	
	public void deveValidarEsportistaIndeciso() {
		page.setNome("Nome qualquer");
		page.setSobrenome("SobreNome qualquer");
		page.setsexoFeminino();
		page.setComidaPizza();
		page.setEsportes("Karate", "O que eh esporte?");
		dsl.selecionarCombo("elementosFrom:esportes", "O que eh esporte?");
		page.cadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
	
}
