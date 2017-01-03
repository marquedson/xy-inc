package zupbackend;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;

public class ProdutoWSTest {

	@Test
	public void deveListarProdutos(){
		
		JsonPath path = given()
				.header("Accept", "application/json")
				.contentType("application/json")
				.get("/zup-backend/rest/produto/listar")
				.andReturn()
				.jsonPath();
		
		List<Integer> idsProdutos = path.getList("id");
		
		assertEquals(idsProdutos.get(0).longValue(), 1L);
	    assertEquals(idsProdutos.get(1).longValue(), 2L);
	}

	@Test
	public void deveRecuperarUmProduto(){
		
		//Buscar o produto de id igual a 5.
		
		JsonPath path = given()
				.header("Accept", "application/json")
				.contentType("application/json")
				.get("/zup-backend/rest/produto/buscar/5")
				.andReturn()
				.jsonPath();
		
		Integer idProduto = path.get("id");
		
		assertEquals(idProduto.longValue(), 5L);
	}
}
