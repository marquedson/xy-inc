package br.com.zup.zupbackend.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.zup.zupbackend.entidade.Produto;
import br.com.zup.zupbackend.service.IProdutoService;
import br.com.zup.zupbackend.serviceimpl.ProdutoServiceImpl;

@Path("/produto")
public class ProdutoEndPoint implements Serializable {

	private static final long serialVersionUID = 1L;

	private IProdutoService produtoService;

	public ProdutoEndPoint() {
		this.produtoService = new ProdutoServiceImpl();
	}

	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarProdutos() {
		List<Produto> produtos = new ArrayList<>();
		produtos = produtoService.listarTodos();
		return Response.status(Status.OK).entity(produtos).build(); 
	}

	@GET
	@Path("/buscar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduto(@PathParam("id") Long id) {
		Produto produto = new Produto();
		produto = produtoService.recuperarPorId(id);
		return Response.status(Status.OK).entity(produto).build();
	}
	
	@POST
	@Path("/adicionar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response adicionarProduto(@FormParam("id") Long id, @FormParam("nome") String nome, 
			@FormParam("descricao") String descricao, @FormParam("valor") Double valor) {

		Produto produto = new Produto(id, nome, descricao, valor);

		produtoService.adicionar(produto);

		return Response.status(Status.OK).entity(produto).build();
	}
	
	@PUT
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarProtudo(Produto produto) {

		Produto produtoAlterar = produtoService.recuperarPorId(produto.getId());
		produtoAlterar.setDescricao(produto.getDescricao());
		produtoAlterar.setNome(produto.getNome());
		produtoAlterar.setValor(produto.getValor());
		
		return Response.status(Status.OK).entity(produtoAlterar).build();
	}
	
	@DELETE
	@Path("/remover/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response alterarProtudoTeste(@PathParam("id") Long id) {
		
		produtoService.remover(id);
		
		String mensagemRetorno = "Produto removido com sucesso!";
		return Response.status(Status.OK).entity(mensagemRetorno).build();
	}


}
