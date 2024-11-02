package br.com.fiap.Plusoft.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> getAllCompras() {
        return compraService.getAllCompras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable Long id) {
        return compraService.getCompraById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Compra createCompra(@RequestBody Compra compra) {
        return compraService.saveCompra(compra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable Long id, @RequestBody Compra compraDetails) {
        Compra updatedCompra = compraService.updateCompra(id, compraDetails);
        if (updatedCompra != null) {
            return ResponseEntity.ok(updatedCompra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable Long id) {
        compraService.deleteCompra(id);
        return ResponseEntity.noContent().build();
    }
}
