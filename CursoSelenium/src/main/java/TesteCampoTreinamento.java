import java.util.Arrays;
import java.util.List;


import org.apache.bcel.generic.Select;
import org.eclipse.jetty.io.ManagedSelector.Selectable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ISelect;

public class TesteCampoTreinamento {
  
	
	private WebDriver driver; // Variavel global, Todosos testes vao chamar este metodo
	private DSL dsl;
	
	@Before // Antes da cada teste,execute o conteudo desse metodo.
	public void inicializa() {
     driver = new FirefoxDriver();
     driver.manage().window().setSize(new Dimension(1200, 765));
     driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	dsl = new DSL(driver);
	}
	
	@After // Ele e executado apos cada um dos Testes. 
	public void finaliza() {
		driver.close();
	}
	
	
	@Test
	 public void testeTextField() {
	dsl.escreve("elementosForm:nome", "Teste de escrita");
	//driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de Escrita");
	Assert.assertEquals("Teste de Escrita", dsl.obterValorCampo("elementosForm:nome"));
	
	//driver.quit();
	//driver.quit();
	}
	
	@Test
	public void testeTextFieldDuplo() {
		dsl.escreve("elementosForm:nome", "George");
		Assert.assertEquals("George",dsl.obterValorCampo("elementosForm:nome"));
		dsl.escreve("elementosFrom:nome", "Conta da Steam");
		Assert.assertEquals("Conta da Steam",dsl.obterValorCampo("elementosForm:nome"));
		
	}
	
	@Test
	public void deveInteragirComTextArea() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\n quebrou"); //vai escrever no campo sugestoes
		Assert.assertEquals("teste\n quebrou", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		//driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioouButton() {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		//driver.quit();
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		//driver.quit();
	}
	
	@Test
	public void deveInteragirComCombo() {
		
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", dsl.obterValorCampo("elementosForm:escolaridade"));
		//driver.quit();
		
	}	
	
	
	@Test
	public void deveVerificarValoresCombo() {
		/*
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade")); // metodo da instância do elementosForm
		org.openqa.selenium.support.ui.Select combo = new org.openqa.selenium.support.ui.Select(element);
		List<WebElement> options = combo.getOptions(); // Faz uma checagem na lista
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
			encontrou = true;
			break;
			}
		}
		
		Assert.assertTrue(encontrou);*/
		Assert.assertEquals(8, dsl.obtervalorCombo("elementosForm:escolaridade")); // retorna a quantidade de opções do combo
		//dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
    }
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		dsl.selecionarCombo("elementosForm:esporte", "Natacao");
		dsl.selecionarCombo("elementosForm:esporte", "Corrida");
		dsl.selecionarCombo("elementosForm:esporte", "O que eh esporte?");
		
		List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(3, opcoesMarcadas.size());
					  // 3 valores da lista
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(2, opcoesMarcadas.size()); // verifico se foram 2 opções marcadas.
		Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
		//driver.quit();
		
	}
	
	
	@Test
	public void deveInteragirComBotoes() {
		
		dsl.clicarBotao("buttonSimple");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		//driver.quit();
	}
	
	@Test
	@Ignore // Vai ignorar o Teste,mostrando apenas o resultado.
	public void deveInteragirComLinks() {
		// vai clicar no botao Voltar!
		dsl.clicarBotao("Voltar");
		//driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		///WebDriver driver = new FirefoxDriver();
		//driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		//estrategia de busca pelo body
		//System.out.println(driver.findElement(By.tagName("body")).getText());
					// Verificaçaao de String
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento",dsl.obterTexto(By.tagName("h3")));
		
						// Busca pela Classe do Elemento
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",dsl.obterTexto(By.className("facilAchar")));
		
		//driver.quit();
	}
	
}
