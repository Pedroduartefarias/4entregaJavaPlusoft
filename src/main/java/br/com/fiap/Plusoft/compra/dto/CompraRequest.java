package br.com.fiap.Plusoft.compra.dto;

import br.com.fiap.Plusoft.compra.Compra;
import br.com.fiap.Plusoft.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CompraRequest(String descricao, BigDecimal valor) {

    public Compra toModel(User user) {
        return Compra.builder()
                .descricao(descricao)
                .valor(valor)
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();
    }
}