package com.api.travelagency.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.api.travelagency.repository.UserRepository;
import com.api.travelagency.repository.DestinationRepository;
import com.api.travelagency.model.User;
import com.api.travelagency.model.Destination;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final DestinationRepository destinationRepository;
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    public DataLoader(UserRepository userRepository, DestinationRepository destinationRepository) {
        this.userRepository = userRepository;
        this.destinationRepository = destinationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        userRepository.save(new User("admin", encoder.encode("1"), Set.of(ROLE_ADMIN)));
        userRepository.save(new User("user", encoder.encode("2"), Set.of(ROLE_USER)));

        destinationRepository.save(new Destination("Paris", "França", "A cidade das luzes", 8.0));
        destinationRepository.save(new Destination("Toronto", "Canadá", "Uma cidade moderna e multicultural", 9.8));
    }
}
