package treinamentoINMSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestePortal {
    
	public static void main(String[] args) {
		
		// Instaciando meu driver
		WebDriver driver = new ChromeDriver();
		// Abrindo o browser do googlechrome na tela de login do sistema
		driver.get("http://www.inmrobo.tk/accounts/login/");
		//Thread.sleep(1500); tempo de espera antes de fechar o navegador
		
		//Informando o usuario
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
		
		driver.quit();
		
	}
}
