import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFrameEJanelas {
    
	private WebDriver driver;
	
	@Before 
	public void inicializa() {
	     driver = new FirefoxDriver();
	     driver.manage().window().setSize(new Dimension(1200, 765));
	     driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		}  
	 
	  @After
	  public void finaliza() {
		  driver.quit();
	  }
	
	@Test
	public void deveInteragirComAlertSimples() {
		
	 WebDriver driver = new FirefoxDriver();
	
	// comando para pegar o frame 
	driver.switchTo().frame("frame1");
	 // clicar dentro do botao frame
	driver.findElement(By.id("FrameButton")).click();
	Alert alert = driver.switchTo().alert();
	String msg = alert.getText();
	Assert.assertEquals("Frame OK!", msg);
	alert.accept();
	
	// Vai trazer o FOco para a tela principal 
	
	driver.switchTo().defaultContent();
	driver.findElement(By.id("elementosForm:nome")).sendKeys("msg");
	
	}
	
	
	@Test
	public void deveInteragirComJanelas() {
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// devo encontrar o Botao.
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.switchTo().window(""); // vai voltar para o identificador.
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// devo encontrar o Botao.
		driver.findElement(By.id("buttonPopUpEasy")).click();
		System.out.println(driver.getWindowHandle()); // retorna o Id da Janela.
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
	}
		
}
