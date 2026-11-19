package br.com.prioriza.model;
// Define o pacote da classe.

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// Importa as ferramentas de mapeamento do JPA.

@Entity
// Define esta classe como uma entidade do banco.

@Table(name = "subtarefas")
// Define o nome da tabela.

public class Subtarefa {

    @Id
    // Define a chave primária.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Gera o identificador automaticamente.

    private Long id;
    // Identificador da subtarefa.

    @Column(nullable = false, length = 120)
    // Exige um título com até 120 caracteres no banco.

    private String titulo;
    // Descreve a pequena etapa que precisa ser realizada.

    @Column(nullable = false)
    // Torna obrigatória a informação de conclusão no banco.

    private boolean concluida = false;
    // Toda subtarefa nova começa pendente.

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // Várias subtarefas podem pertencer à mesma tarefa.

    @JoinColumn(name = "tarefa_id", nullable = false)
    // Cria a chave estrangeira que aponta para a tarefa principal.

    private Tarefa tarefa;
    // Guarda a tarefa à qual esta etapa pertence.

    public Subtarefa() {
        // Construtor sem argumentos utilizado pelo JPA.
    }

    public Long getId() {
        return id;
        // Retorna o identificador.
    }

    public void setId(Long id) {
        this.id = id;
        // Atualiza o identificador.
    }

    public String getTitulo() {
        return titulo;
        // Retorna o título.
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        // Atualiza o título.
    }

    public boolean isConcluida() {
        return concluida;
        // Informa se esta etapa foi concluída.
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
        // Marca a etapa como concluída ou pendente.
    }

    public Tarefa getTarefa() {
        return tarefa;
        // Retorna a tarefa principal.
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
        // Define a tarefa à qual esta etapa pertence.
    }
}