package com.gym.db;

import com.gym.db.auth.*;
import com.gym.db.classes.GymClass;
import com.gym.db.classes.GymClassRepository;
import com.gym.db.members.Member;
import com.gym.db.members.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(
            UserRepository userRepo,
            MemberRepository memberRepo,
            GymClassRepository classRepo,
            PasswordEncoder encoder
    ) {
        return args -> {
            if (userRepo.count() == 0) {
                userRepo.save(new AppUser(null, "admin", encoder.encode("admin123"), Role.ADMIN));

                userRepo.save(new AppUser(null, "user", encoder.encode("user123"), Role.USER));
            }

            if (memberRepo.count() == 0) {
                memberRepo.save(new Member(null, "Juan Pérez", "BASIC", true));
                memberRepo.save(new Member(null, "Laura Gómez", "PREMIUM", true));
            }

            if (classRepo.count() == 0) {
                classRepo.save(new GymClass(null, "Spinning", "Coach Ana", LocalDateTime.now().plusDays(1), 20));
                classRepo.save(new GymClass(null, "CrossFit", "Coach Mario", LocalDateTime.now().plusDays(2), 15));
            }
        };
    }
}
