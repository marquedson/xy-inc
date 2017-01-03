package br.com.zup.zupbackend.service;

import java.util.List;

import br.com.zup.zupbackend.entidade.Produto;

public interface IProdutoService {

	public List<Produto> listarTodos();
	
	public Produto recuperarPorId(Long idProduto);

	public void adicionar(Produto produto);

	public void remover(Long idProduto);
	
}
