package br.com.fiap.Plusoft.user;

import br.com.fiap.Plusoft.mail.MailService;
import br.com.fiap.Plusoft.user.dto.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    // Buscar todos os usuários
    public List<User> findAll() {
        return repository.findAll();
    }

    // Criar um novo usuário
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now()); // Definindo o campo createdAt
        user.setUpdatedAt(LocalDateTime.now()); // Definindo o campo updatedAt
        mailService.sendWelcomeEmail(user);
        return repository.save(user);
    }

    // Buscar perfil pelo email
    public UserProfileResponse getProfile(String email) {
        return repository.findByEmail(email)
                .map(UserProfileResponse::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    // Buscar usuários por nome
    public List<User> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
