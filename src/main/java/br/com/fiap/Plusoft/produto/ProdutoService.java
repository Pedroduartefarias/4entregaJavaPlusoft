package br.com.fiap.Plusoft.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Long id, Produto produtoDetails) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoDetails.getNome());
            produto.setDescricao(produtoDetails.getDescricao());
            produto.setPreco(produtoDetails.getPreco());
            return produtoRepository.save(produto);
        }).orElse(null);
    }

    public boolean deleteProduto(Long id) {
        return produtoRepository.findById(id).map(produto -> {
            produtoRepository.delete(produto);
            return true;
        }).orElse(false);
    }
}
