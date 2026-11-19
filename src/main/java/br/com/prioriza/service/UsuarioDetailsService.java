package br.com.prioriza.service;
// Define o pacote dos serviços.

import java.util.Locale;
// Permite padronizar o e-mail em letras minúsculas.

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// Importa os tipos utilizados pelo Spring Security no login.

import org.springframework.stereotype.Service;
// Permite registrar esta classe como um serviço do Spring.

import br.com.prioriza.model.Usuario;
import br.com.prioriza.repository.UsuarioRepository;
// Importa nossa entidade e o repositório de usuários.

@Service
// Faz o Spring reconhecer e gerenciar esta classe.

public class UsuarioDetailsService implements UserDetailsService {
    // Implementa o contrato usado para buscar uma conta no login.

    private final UsuarioRepository usuarioRepository;
    // Guarda o repositório utilizado para consultar o banco.

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        // O Spring fornece o repositório pelo construtor.
    }

    @Override
    // Indica que implementamos um método da interface.

    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        // Apesar do nome do método, usaremos o e-mail como identificação.

        String emailNormalizado = email.trim().toLowerCase(Locale.ROOT);
        // Remove espaços nas pontas e converte para letras minúsculas.

        Usuario usuario = usuarioRepository.findByEmail(emailNormalizado)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado"));
        // Busca a conta no banco.
        // Se não encontrar, informa ao Spring Security que a conta não existe.

        return User.withUsername(usuario.getEmail())
                // Usa o e-mail como identificação da conta.

                .password(usuario.getSenha())
                // Fornece o hash já armazenado no banco.

                .roles("USUARIO")
                // Atribui o mesmo perfil de acesso a todos os usuários.

                .build();
                // Monta e retorna os dados esperados pelo Spring Security.
    }
}