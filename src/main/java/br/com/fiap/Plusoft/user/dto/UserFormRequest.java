package br.com.fiap.Plusoft.user.dto;

import br.com.fiap.Plusoft.user.User;

import java.time.LocalDateTime;

public record UserFormRequest(
        String name,
        String genero,
        String email,
        String password,
        String idade
) {
    public User toModel() {
        return User.builder()
                .name(name)
                .genero(genero)
                .email(email)
                .password(password)
                .idade(idade)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}