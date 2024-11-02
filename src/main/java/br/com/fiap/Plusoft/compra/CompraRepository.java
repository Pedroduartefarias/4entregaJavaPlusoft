package br.com.fiap.Plusoft.compra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    // Métodos customizados podem ser adicionados aqui, se necessário
}