package br.projeto.rest;

import io.restassured.RestAssured;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

 
public class UserXMLTest {
  
	// antes de executar cada um desses testes,come�ara a aprtir desse
	@BeforeClass
	public static void setup() {
	RestAssured.baseURI = "http://restapi.wcaquino.me";
	RestAssured.port = 443;
	RestAssured.basePath = "";
	
	RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
	reqBuilder.log(LogDetail.ALL);
	String reqSpec = String.valueOf(reqBuilder.build());
  }
	
	/*
	@Test
	public void devoTrabalharComXML() {
		given()
		    .spec(reqSpec)
		.log().all
		.when()
		    .get("/usersXML/3")
		.get("usersXML")
		.then()
		   .statusCode(resSpec) // deve retornar o status 200
		   
		   .rootPath("user") // informa o caminho da pasta
		.body("user.name", is("Ana Julia"))
		.body("user.id", is(3))
		
		.body("user.filhos.namesize()", is(2))
		.body("user.filhos.names[0]", is("Zezinho"))
		
		 .body("user.filhos.names[1]", is("Luizinho"))
		 .body("user.filhos.names", is("Luizinho"))
		 .detachRootPath("filhos") // vai remover a lista de filhos
		 .appendRootPath("filhos") // vai adicionar a lista de filhos
		.body("names", hasItem("Luizinho")) // cerifica 1 elelemnto
		.body("names", hasItems("Luizinho", "Zezinho")) // verifica 2 elementos
	   ;
	}

	 */

			@Test
			public void devoFazerPEsquisasAvancadasXML() {
				
				given()
				.when()
				.get("usersXML")
				.then()
				   .statusCode(200) // deve retornar o status 200
				   .body("users.user.size()", is(3))
				   .body("users.user.@id", hasItems("1", "2", "3"))
				   .body("users.user.find{it.age == 25}.name", is("Maria Joaquina"))
				    // Faz a verifia��o de todos os nomes da lista, que contem a letra "n"
				   .body("users.user.findAll{it.nome.toString().contains('n')).nome", hasItems("Maria Joaquina", "Ana Joaquina"))
				   .body("users.user.salary.find{it != null}.toDouble()",is(1234.5678d))
				   // Compara��o Com letras maiusculas
				  ;
			}
			
	    @Test
	    public void devoFazerPesquisaAvancadaComXMLEJava() {	
	    	Object path = given()
			.when()
			   .get("usersXML")
			.then()
			   .statusCode(200) // deve retornar o status 200
	    	 .extract().path("users.user.name.findAll{it.toString().contains('n')}"); // vai extrai da pasta
	    	 ;
	    	System.out.println(path); // ira retorna os nomes
	    }
	    /*
	    @Test
	    public void devoFazerPesquisaComPath() {
	    	given()
			.when()
			   .get("usersXML")
			.then()
			   .statusCode(200) // deve retornar o status 200
			   .body(hasXPath("count/users/user)"), is("3")) // verifia a qtd de elementos
			   
			   ;
	    }

	     */
			
}
