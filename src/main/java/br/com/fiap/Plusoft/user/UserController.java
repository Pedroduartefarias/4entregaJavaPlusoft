package br.com.fiap.Plusoft.user;

import br.com.fiap.Plusoft.user.dto.UserFormRequest;
import br.com.fiap.Plusoft.user.dto.UserProfileResponse;
import br.com.fiap.Plusoft.user.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    // Retornar todos os usuários ou buscar por nome
    @GetMapping
    public List<User> findAll(@RequestParam(required = false) String name){
        if (name != null) return service.findByName(name);
        return service.findAll();
    }

    // Criar um novo usuário
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserFormRequest userForm, UriComponentsBuilder uriBuilder){
        var user = service.create(userForm.toModel());
        var uri = uriBuilder
                .path("/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(UserResponse.from(user));
    }

    // Obter o perfil do usuário autenticado
    @GetMapping("/profile")
    public UserProfileResponse getProfile() {
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return service.getProfile(email);
    }
}
