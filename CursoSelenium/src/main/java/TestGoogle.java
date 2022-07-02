import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGoogle {
   
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
	public void teste() {
	  // Caminho do Gecko driver
	//System.setProperty("webdriver.gecko.driver", "/Users/george.santos/geckodriver/geckodriver.exe");	
	 // Instancia para abrir o navegador
	 WebDriver driver = new FirefoxDriver(); 
     // WebDriver driver  = new ChromeDriver();
	// driver.manage().window().maximize(); Maximizar o navegador
	driver.manage().window().setSize(new Dimension(1200, 765));
	 driver.get("http://www.google.com"); // Cessar o navegador
	 Assert.assertEquals("Google", driver.getTitle()); 
	// driver.quit(); // mata a execução do browser
	 
	}
}
