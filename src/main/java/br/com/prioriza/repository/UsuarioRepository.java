package br.com.prioriza.repository;
// Define o pacote dos repositórios.

import java.util.Optional;
// Representa um resultado que pode existir ou não.

import org.springframework.data.jpa.repository.JpaRepository;
// Disponibiliza operações prontas para acessar o banco.

import br.com.prioriza.model.Usuario;
// Importa a entidade que este repositório gerencia.

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Gerencia a entidade Usuario, cuja chave primária é do tipo Long.

    Optional<Usuario> findByEmail(String email);
    // Busca um usuário pelo e-mail.
    // O resultado pode estar vazio se o e-mail não estiver cadastrado.

    boolean existsByEmail(String email);
    // Retorna true se o e-mail já estiver cadastrado.
}