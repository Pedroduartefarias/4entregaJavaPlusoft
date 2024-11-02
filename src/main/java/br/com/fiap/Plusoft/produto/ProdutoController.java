package br.com.fiap.Plusoft.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Get all produtos
    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    // Get produto by id
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.getProdutoById(id);
        return produto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new produto
    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    // Update produto
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        Produto updatedProduto = produtoService.updateProduto(id, produtoDetails);
        if (updatedProduto != null) {
            return ResponseEntity.ok(updatedProduto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        boolean deleted = produtoService.deleteProduto(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
