package br.projeto.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;



import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class VerbosTest {
  
	@Test
	public void deveSalvarUsuario() {
		given()
		  .log().all()
		  // Objeto sera reconhecido no formato json
		  .contentType("application/json")
		  .body("{ \"name:\" \"Jose:\", \"age\": 50}") // Faz uma requisi��o
		 .when()
		    .post("http://restapi.wcaquino.me/users") // manda para este recurso
		    .then()
		    .log().all()
		    .statusCode(201) // retorna que o Status Code foi Criado.
		    ;
	}
	
	public void NaodeveSalvarUsuariosemNome() {
		given()
		  .log().all()
		  // Objeto sera reconhecido no formato json
		  .contentType("application/json")
		  .body("<user>   <name>Jo�o</name> <age>50</age> </user>") // Faz uma requisi��o
		 .when()
		    .post("http://restapi.wcaquino.me/users")
		  .then()
		    .log().all()
		    .statusCode(400) // nao seja valido
		    .body("id", is(notNullValue())) // o id tem que ser nulo
		    .body("name", is("Jose"))
		    .body("age", is(50))
		    ;
	}
	
	public void deveAlterarUsuario() {
		given()
		  .log().all()
		  // Objeto sera reconhecido no formato json
		  .contentType("application/json")
		  .body("{ \"name:\"; \"Usuario alterado:\", \"age\": 90}") // Faz uma requisi��o
		 .when()
		    .put("http://restapi.wcaquino.me/users/1") // vai fazer a altera��o de Usuario
		  .then()
		    .log().all()
		    .statusCode(200) // nao seja valido
		    //.body("id", is(notNullValue())) // o id tem que ser nulo
		    //.body("name", is("Jose"))
		    //.body("age", is(50))
		    ;
   }
	
	public void devoCustomizarURLParte2() {
		given()
		.log().all()
		.contentType("application/json")
		.body("{\" name\": \"Usuario alterado\", \"age\": 80}")
		.when()
		  .put("https://restapi.wcaquino.me/{entidade}/{userId}", "users", "1")
		   .then()
		   .log().all()
		    .statusCode(200) // nao seja valido
		    .body("id",is(1)) // o id tem que ser nulo
		    .body("name", is(80))
		    .body("salary", is(1234.5678f))
		    ;
	}
	
	@Test
	public void deveRemoverUsuario() {
		given()
		     .log().all()
		     .when()
		        .delete("http://restapi.wcaquino.me/users/1")
		      .then()
		      .log().all()
		      .statusCode(400)
		      .body("error", is("Registro inexistente"))
		      ;
	}
	
}

