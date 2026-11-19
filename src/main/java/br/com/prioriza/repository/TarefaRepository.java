package br.com.prioriza.repository;
// Define o pacote dos repositórios.

import java.util.List;
// Permite retornar várias tarefas.

import java.util.Optional;
// Representa um resultado que pode existir ou não.

import org.springframework.data.jpa.repository.JpaRepository;
// Disponibiliza operações prontas de acesso ao banco.

import br.com.prioriza.model.Tarefa;
// Importa a entidade gerenciada.

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // Gerencia tarefas com identificador do tipo Long.

    List<Tarefa> findByUsuarioIdOrderByConcluidaAscPrazoAscPrioridadeAsc(
            Long usuarioId);
    // Lista as tarefas de um usuário.
    // Mostra primeiro as pendentes, depois ordena por prazo e prioridade.

    Optional<Tarefa> findByIdAndUsuarioId(Long id, Long usuarioId);
    // Busca uma tarefa verificando também seu dono.

    List<Tarefa> findByUsuarioIdAndConcluidaFalseOrderByPrioridadeAscPrazoAsc(
            Long usuarioId);
    // Lista somente as tarefas pendentes do usuário.
    // Ordena primeiro pela prioridade e depois pelo prazo.

    boolean existsByCategoriaId(Long categoriaId);
    // Verifica se alguma tarefa utiliza determinada categoria.
}