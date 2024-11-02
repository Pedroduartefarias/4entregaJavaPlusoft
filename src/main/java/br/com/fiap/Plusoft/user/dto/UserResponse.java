package br.com.fiap.Plusoft.user.dto;

import br.com.fiap.Plusoft.user.User;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String name,
        String email,
        String genero,
        String idade,
        LocalDateTime createdAt
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getGenero(),
                user.getIdade(),
                user.getCreatedAt()
        );
    }
}