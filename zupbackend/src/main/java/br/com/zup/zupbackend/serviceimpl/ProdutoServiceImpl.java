package br.com.zup.zupbackend.serviceimpl;

import java.io.Serializable;
import java.util.List;

import br.com.zup.zupbackend.dao.ProdutoDao;
import br.com.zup.zupbackend.entidade.Produto;
import br.com.zup.zupbackend.service.IProdutoService;

public class ProdutoServiceImpl implements IProdutoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Produto> listarTodos() {
		return new ProdutoDao().listaTodos();
	}

	@Override
	public Produto recuperarPorId(Long idProduto) {
		return new ProdutoDao().recuperarPorId(idProduto);
	}

	@Override
	public void adicionar(Produto produto) {
		new ProdutoDao().adicionar(produto);
	}

	@Override
	public void remover(Long idProduto) {
		new ProdutoDao().remover(idProduto);
	}

}
