package br.com.prioriza.repository;
// Define o pacote dos repositórios.

import java.util.List;
// Permite retornar vários registros de foco.

import java.util.Optional;
// Representa um resultado que pode existir ou não.

import org.springframework.data.jpa.repository.JpaRepository;
// Disponibiliza operações prontas de acesso ao banco.

import br.com.prioriza.model.RegistroFoco;
// Importa a entidade gerenciada.

public interface RegistroFocoRepository
        extends JpaRepository<RegistroFoco, Long> {
    // Gerencia registros de foco com identificador do tipo Long.

    List<RegistroFoco> findByTarefaIdAndTarefaUsuarioIdOrderByDataDescIdDesc(
            Long tarefaId, Long usuarioId);
    // Lista os registros de uma tarefa, verificando seu dono.
    // Mostra primeiro as datas mais recentes.
    // Para registros da mesma data, mostra primeiro o maior identificador.

    List<RegistroFoco> findByTarefaUsuarioIdOrderByDataDescIdDesc(
            Long usuarioId);
    // Lista os registros de todas as tarefas de um usuário.
    // Será utilizado para apresentar o histórico e calcular os totais.

    Optional<RegistroFoco> findByIdAndTarefaUsuarioId(
            Long id, Long usuarioId);
    // Busca um registro pelo identificador e pelo dono da tarefa.
    // Retorna vazio se não existir ou pertencer a outra pessoa.
}