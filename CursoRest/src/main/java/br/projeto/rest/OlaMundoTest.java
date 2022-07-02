package br.projeto.rest;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class OlaMundoTest {

	/*
	@Test
	public void testOlaMundo() {
		Response response =	RestAssured.request(Method.GET, "http://restapi.wcaquino.me:80/ola"); // requisi��o do metodo
		Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!")); // vai imprimir o corpo como uma String.
		Assert.assertTrue(response.statusCode() == 200); // a partir da response, vou obter o Status Code.
		Assert.assertTrue("O status deeria ser 200", response.statusCode() == 200);
		Assert.assertEquals(201, response.statusCode());
		
	 // Fazer a verifica��o do codigo do Status Code.
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
		
	}

	 */

	/*
	@Test
	 public void devoConhecerOutraFormaRestAssured() {
		 
		Response response =	RestAssured.request(Method.GET, "http://restapi.wcaquino.me:/ola"); // requisi��o do metodo
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
		
		get("http://restapi.wcaquino.me/ola").then().statusCode(200);
	  
		given()
		//Pr� COndi��es
		.when()
			.get("http://restapi.wcaquino.me/ola")
		 .then()
		      .statusCode(201);
	}

	 */
	 @Test
	 public void devoConhecerMatchersHamcrest() {
		 // Comparativo de Strings
		 assertThat("Maria", is("Maria"));
		 // COmparativo de NUmeros Iguais
		 assertThat(128, is(128));
		 //Comparativo do tipo Inteiro
		 assertThat(128, Matchers.isA(Integer.class));
		 // Comparativos e numeros tipo DOuble
		 assertThat(128d, Matchers.isA(Double.class));
		 assertThat(128d, Matchers.greaterThan(125d));
		 //

		 //Vai verifiar se o tamanho desse array e de 5 elementos.
		 List<Integer> impares = Arrays.asList(1, 3, 5, 7, 9);
		 assertThat(impares, Matchers.hasSize(5));
		 assertThat(impares, hasItem(1)); // verifiar se o numero contem na lista

		 assertThat("Maria", is(not("Jo�o"))); // nao e joao
		 assertThat("Maria", not("Jo�o"));
		 assertThat("Joaquina", anyOf(is("Maria"), is("Joaquina")));

	 }
		 @Test
		 public void deveValidarBody() {
			 given()
				//Pr� COndi��es
				.when()
					.get("http://restapi.wcaquino.me/ola")
				 .then()
				      .statusCode(200)
			   .body(is("Ola Mundo!"));
	 }
		
}
