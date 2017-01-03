package br.com.zup.zupbackend.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.zup.zupbackend.entidade.Produto;

public class ProdutoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Produto> repository = new ArrayList<>();
	
	private Map<Long, Produto> repositoryProdutos = new HashMap<>();
	
	public ProdutoRepository() {
		
		repositoryProdutos.put(new Long(1), new Produto(new Long(1), "Smartphone" , "Telefone Smartphone", new Double(850.00)));
		repositoryProdutos.put(new Long(2), new Produto(new Long(2), "Computador" , "Computador DELL", new Double(2.850)));
		repositoryProdutos.put(new Long(3), new Produto(new Long(3), "Notebook" , "Notebook DELL", new Double(3.850)));
		repositoryProdutos.put(new Long(4), new Produto(new Long(4), "Relógio" , "Relógio Smartwatch", new Double(350.00)));
		repositoryProdutos.put(new Long(5), new Produto(new Long(5), "Smart TV" , "TV Samsumg", new Double(850.00)));
		repositoryProdutos.put(new Long(6), new Produto(new Long(6), "Tablet" , "Tablet Samsumg", new Double(1.250)));
		repositoryProdutos.put(new Long(7), new Produto(new Long(7), "iPad" , "iPad mini", new Double(2.300)));
	}

	public List<Produto> listar() {
		List<Produto> produtos = new ArrayList<>(repositoryProdutos.values());
		return produtos;
	}

	public Produto getPorId(Long id) {
		
		return repositoryProdutos.get(id);
	}

}
