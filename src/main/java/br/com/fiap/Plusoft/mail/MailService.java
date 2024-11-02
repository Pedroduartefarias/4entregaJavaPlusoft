package br.com.fiap.Plusoft.mail;

import br.com.fiap.Plusoft.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    MailSender mailSender;

    public void sendWelcomeEmail(User user) {
        var email = new SimpleMailMessage();

        email.setFrom("Plusoft");
        email.setTo(user.getEmail());
        email.setSubject("Boas Vindas");
        email.setText("""
                    Olá, %s
                    
                    Seja bem vindo a Plusoft.
                    
                    Estamos felizes por ter você aqui.
                    
                    Att
                    Equipe Plusoft
                """.formatted(user.getName()));


        mailSender.send(email);
    }
}
