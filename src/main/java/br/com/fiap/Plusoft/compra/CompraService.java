package br.com.fiap.Plusoft.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    public Optional<Compra> getCompraById(Long id) {
        return compraRepository.findById(id);
    }

    public Compra saveCompra(Compra compra) {
        // Set timestamps (se necessário)
        compra.setCreatedAt(LocalDateTime.now());
        compra.setUpdatedAt(LocalDateTime.now());
        return compraRepository.save(compra);
    }

    public Compra updateCompra(Long id, Compra compraDetails) {
        return compraRepository.findById(id).map(compra -> {
            compra.setDescricao(compraDetails.getDescricao());
            compra.setValor(compraDetails.getValor());
            compra.setUser(compraDetails.getUser());
            compra.setUpdatedAt(LocalDateTime.now()); // Atualiza o timestamp
            return compraRepository.save(compra);
        }).orElse(null);
    }

    public void deleteCompra(Long id) {
        compraRepository.deleteById(id);
    }
}