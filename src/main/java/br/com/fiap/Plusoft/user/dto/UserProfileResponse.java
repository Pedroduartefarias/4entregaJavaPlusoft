package br.com.fiap.Plusoft.user.dto;

import br.com.fiap.Plusoft.user.User;

public record UserProfileResponse(
        String name,
        String genero,
        String email,
        String idade
) {
    public UserProfileResponse(User user){
        this(user.getName(), user.getGenero(), user.getEmail(), user.getIdade());
    }
}