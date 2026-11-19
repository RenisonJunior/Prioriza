package br.com.prioriza.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.prioriza.model.Usuario;
import br.com.prioriza.repository.UsuarioRepository;

@Service
public class CadastroService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public CadastroService(UsuarioRepository usuarioRepository,
                           PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean cadastrar(Usuario usuario) {
        String email = usuario.getEmail().trim().toLowerCase();

        if (usuarioRepository.existsByEmail(email)) {
            return false;
        }

        usuario.setEmail(email);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        return true;
    }
}