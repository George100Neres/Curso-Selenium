import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

	  private DSL dsl;
	  
	  public CampoTreinamentoPage(WebDriver driver) {
		  dsl = new DSL(driver);
	  }
	  
	  // Campo nome
	  public void setNome(String nome) {
		  dsl.escreve("elementosForm:nome",nome);
	  }
	  
	  //Campo Sobrenome
	  public void setSobrenome(String sobrenome) {
		  dsl.escreve("elementosForm:sobrenome", sobrenome);
	  }
	  
	  public void setsexoMasculino() {
		  dsl.clicarRadio("elementosForm:sexo:0");
	  }
	  
	  public void setsexoFeminino() {
		  dsl.clicarRadio("elementosForm:sexo:1");
	  }
	  
	  public void setComidaPizza() {
		  dsl.clicarRadio("elementosForm:comidaFavorita:2");
	  }
	  
	  public void setComidaVegetariano() {
		  dsl.clicarRadio("elementosForm:comidaFavorita:3");
	  }
	  
	  public void setEscolaridade(String valor) {
		  dsl.selecionarCombo("elementosForm:escolaridade", valor);
	  }
	  
	  public void setEsportes(String...valores ) {
		  for(String valor: valores)
		  dsl.selecionarCombo("elementosForm:esportes", valor);
	  }
	  
	  public void cadastrar() {
		  dsl.clicarBotao("elementosForm:cadastrar");
	  }
	  
	  public String obterResultadoCadastro() {
		  return dsl.obterTexto("resultado");
	  }
	  
	  public String obterSexoCadastro() {
		  return dsl.obterTexto("descSexo");
	  }
	  
	  public String obterComidaCadastro() {
		  return dsl.obterTexto("descComida");
	  }
	  
	  public String obterNomeCadastro() {
		  return dsl.obterTexto("descNome");
	  }
	  
	  public String obterSobreNomeCadastro() {
		  return dsl.obterTexto("descSobreNome");
	  }
	  
	  public String obterEscolaridadeCadastro() {
		  return dsl.obterTexto("descEscolaridade");
	  }
	  
	  public String obterEsportesCadastro() {
		  return dsl.obterTexto("descEsporte");
	  }
	  
	  
	  
}
