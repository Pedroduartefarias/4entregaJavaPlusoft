package br.com.fiap.Plusoft.produto.dto;

import br.com.fiap.Plusoft.produto.Produto;

import java.math.BigDecimal;

public record ProdutoRequest(String nome, String descricao, BigDecimal preco) {

    public Produto toModel() {
        return Produto.builder()
                .nome(nome)
                .descricao(descricao)
                .preco(preco)
                .build();
    }
}
