package br.com.prioriza.repository;
// Define o pacote dos repositórios.

import java.util.List;
// Permite retornar uma lista de categorias.

import java.util.Optional;
// Representa um resultado que pode existir ou não.

import org.springframework.data.jpa.repository.JpaRepository;
// Disponibiliza operações prontas de acesso ao banco.

import br.com.prioriza.model.Categoria;
// Importa a entidade gerenciada.

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Gerencia categorias com identificador do tipo Long.

    List<Categoria> findByUsuarioIdOrderByNomeAsc(Long usuarioId);
    // Lista as categorias de um usuário em ordem alfabética.

    Optional<Categoria> findByIdAndUsuarioId(Long id, Long usuarioId);
    // Busca uma categoria pelo identificador e pelo dono.
    // Retorna vazio se ela não existir ou pertencer a outro usuário.
}