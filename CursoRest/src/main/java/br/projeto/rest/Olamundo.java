package br.projeto.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Olamundo {
  
	public static void main(String[] args) {
	Response response =	RestAssured.request(Method.GET, "http://restapi.wcaquino.me:80/ola"); // requisi��o do metodo
		System.out.println(response.getBody().asString().equals("Ola Mundo!")); // vai imprimir o corpo como uma String.
		System.out.println(response.statusCode() == 200); // a partir da response, vou obter o Status Code.
	 // Fazer a verifica��o do codigo do Status Code.
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
	}
}
