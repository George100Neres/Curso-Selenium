package br.projeto.rest;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Array;
import java.util.Arrays;


public class UserJsonTest {
  
	@Test
	public void deveVerificarPrimeiroNivel() {
		// Dado 
		given()
		//QUando
		.when()
			.get("https://restapi.wcaquino.me/users/1")
		.then()
		      .statusCode(200)
		      .body("id", is(1))
		      .body("name", containsString("Silva"))
		      .body("age", greaterThan(18))
		      ;
	}
	
	

	@Test
	public void deveVerificarPrimeiroNivelOutrasFormas() {
		Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/users/1");

		// path
		//Assert.assertEquals(new Integer(1), response.path("id"));

		//Assert.assertEquals(new Integer(1), response.path("%s", "id"));

		//jsonpath
		JsonPath jpath = new JsonPath(response.asString());
		//Assert.assertEquals(1, jpath.getInt("id"));

		//from
		int id = JsonPath.from(response.asString()).getInt("id");
		//Assert.assertEquals(1, id);
	}

		// Validar o segundo usuario
		@Test
		public void deveVerificarSegundoNivel() {
			given()
			//QUando
			.when()
				.get("https://restapi.wcaquino.me/users/2")
			.then()
			      .statusCode(200)
			      .body("id", is(2))
			      .body("name", containsString("Joaquina"))
			      .body("endereco.rua", is("Rua dos bobos")) // verifica se e este endereco
			      ;
			
		}
		
		@Test
		public void deveVerificarListaRaiz() {
			//QUando
			// verifica se e este endereco
			given()
			//QUando
			.when()
				.get("https://restapi.wcaquino.me/users/3")
			.then()
			      .statusCode(200)
			      .body("id", is(3))
			      .body("name", containsString("Ana"))
			      .body("filhos", hasSize(2)) // verifica se e este endereco
			      .body("filhos[0].name", is("Zezinho"))
			      .body("filhos[1].name", is("Luizinho"))
					.body("filhos.name", hasItem("Zezinho"))
					.body("filhos.name", hasItem("Luizinho"))
			   //   .body("filhos.name", hasItem("Zezinho"), "Luizinho")
			      ;
			
		}
		
		@Test
		public void deveRetornarErroUsuarioInexistente() {
			given()
			.when()
			  .get("https://restapi.wcaquino.me/users/4")
			  .then()
			  .statusCode(404)
			  .body("error", is("Usuário inexistente"))
			  ;
		}
		
		@Test
		public void deveVerificarListaRaiz2() {
			given()
			.when()
			  .get("https://restapi.wcaquino.me/users")
			 .then()
			 .statusCode(200)
			 .body("$", hasSize(3))
			 .body("name", hasItems("Joao da Silva", "Maria Joaquina", "Ana Julia"))
			 .body("age[1]", is(25))
			 .body("filhos.name", hasItem(Arrays.asList("Zezinho", "luizinho")))
			 .body("salary", contains(1234.5678f, 2500, null))
		  ;
		}			
			
	    @Test
	    public void deveFazerVerificacaoAvancadas() {
	    	given()
	    	 .when()
	    	   .get("https://restapi.wcaquino.me/users")
	    	   .then()
	    	     .statusCode(200)
	    	     .body("$", hasSize(3))
	    	     .body("age.findAll{it <= 25}.size()", is(2))
	    	     .body("age.findAll{it <= 25 && it it > 20}.size()", is(1))
	    	     .body("age.findAll{it.age > 25 && it.age > 20}.name", hasItem("Maria Joaquina"))
	    	     .body("find{it.age <= 25}.nome", is("Maria Joaquina"))
	    	     .body("findA{it.name.contains('n')}.nome", hasItems("Maria Joaquina", "Ana Julia"))
	    	     // verifica��o multiplicado por 2
					/*
	    	     .body("age.collect[it * 2]", 60, 50, 40))
				 .body("id.max", is(3))
				 .body("salary.min()", is{1234.5678f))

					 */
			
				;
          }
	  /*  @Test
	    public void devoUnirJsonPathComJava() {
	    	Array<String> nomes =
	    			given()
	    			 .when()
	    			   .get("https://restapi.wcaquino.me/users")
	    			  .then()
	    			     . statusCode(200)
	    			     // Verifica se a Letra inicial Inicia com letra maiuscula
	    			     .extract().path("name.findAll{it.startWith('Maria')}")
	    			    ;
	    	Assert.assertEquals(1, nomes.size());
	    	Assert.assertTrue(nomes.get(0).equalsIgnoreCase("mARia JOaquina"));
	    	Assert.assertEquals(nomes.get(0).toUpperCase(), "maria joaquina", toUpperCase());
	    }

	   */
	}

