package com.api.sustentavel.dadosIniciais;

import com.api.sustentavel.user.Usuario;
import com.api.sustentavel.user.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class InitialDataLoader {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initUsers() {
        if (usuarioRepository.count() == 0) {
            log.info("Inicializando usuários padrão");

            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setNome("Administrador");
            admin.setEmail("admin@sustentavel.com");
            admin.setRoles(Arrays.asList("ADMIN", "USER"));
            admin.setEnabled(true);
            usuarioRepository.save(admin);

            Usuario user = new Usuario();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user123"));
            user.setNome("Usuário Comum");
            user.setEmail("user@sustentavel.com");
            user.setRoles(Arrays.asList("USER"));
            user.setEnabled(true);
            usuarioRepository.save(user);

            log.info("Usuários padrão criados com sucesso");
        }
    }
}