package isis.projet.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class GenerateHash implements CommandLineRunner {
    @Override
    public void run(String... args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode("1234");
        System.out.println("Hash du mot de passe : " + hash);
    }
}
