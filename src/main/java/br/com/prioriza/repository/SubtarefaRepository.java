package br.com.prioriza.repository;
// Define o pacote dos repositórios.

import java.util.List;
// Permite retornar uma lista de subtarefas.

import java.util.Optional;
// Representa um resultado que pode existir ou não.

import org.springframework.data.jpa.repository.JpaRepository;
// Disponibiliza operações prontas de acesso ao banco.

import br.com.prioriza.model.Subtarefa;
// Importa a entidade gerenciada.

public interface SubtarefaRepository extends JpaRepository<Subtarefa, Long> {
    // Gerencia subtarefas com identificador do tipo Long.

    List<Subtarefa> findByTarefaIdAndTarefaUsuarioIdOrderByIdAsc(
            Long tarefaId, Long usuarioId);
    // Lista as etapas de uma tarefa, verificando o dono.
    // Ordena pelo identificador, mantendo a ordem de cadastro.

    Optional<Subtarefa> findByIdAndTarefaUsuarioId(
            Long id, Long usuarioId);
    // Busca uma subtarefa pelo identificador e pelo dono da tarefa.
    // Retorna vazio se não existir ou pertencer a outro usuário.
}