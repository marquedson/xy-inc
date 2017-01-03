package br.com.zup.zupbackend.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.zup.zupbackend.entidade.Produto;

public class ProdutoDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static Map<Long, Produto> produtosMap = new HashMap<>();
	
	static {
		produtosMap.put(new Long(1), new Produto(new Long(1), "Smartphone" , "Telefone Smartphone", new Double(850)));
		produtosMap.put(new Long(2), new Produto(new Long(2), "Computador" , "Computador DELL", new Double(2850)));
		produtosMap.put(new Long(3), new Produto(new Long(3), "Notebook" , "Notebook DELL", new Double(3850)));
		produtosMap.put(new Long(4), new Produto(new Long(4), "Relógio" , "Relógio Smartwatch", new Double(350)));
		produtosMap.put(new Long(5), new Produto(new Long(5), "Smart TV" , "TV Samsumg", new Double(850)));
		produtosMap.put(new Long(6), new Produto(new Long(6), "Tablet" , "Tablet Samsumg", new Double(1250)));
		produtosMap.put(new Long(7), new Produto(new Long(7), "iPad" , "iPad mini", new Double(2300)));
	}

	public List<Produto> listaTodos() {
		List<Produto> produtos = new ArrayList<>(produtosMap.values());
		return produtos;
	}

	public Produto recuperarPorId(Long idProduto) {
		return produtosMap.get(idProduto);
	}

	public void adicionar(Produto produto) {
		produtosMap.put(produto.getId(), produto);
	}

	public void remover(Long idPproduto) {
		Produto produtoRemover = produtosMap.get(idPproduto);
		produtosMap.remove(produtoRemover);
	}

}
