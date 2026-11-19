package br.com.prioriza.model;
// Define o pacote da classe.

import java.time.LocalDate;
// Permite armazenar a data da atividade.

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

@Table(name = "registros_foco")
// Define o nome da tabela.

public class RegistroFoco {

    @Id
    // Define a chave primária.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Gera o identificador automaticamente.

    private Long id;
    // Identificador do registro.

    @Column(nullable = false)
    // Torna obrigatória a data no banco.

    private LocalDate data;
    // Guarda o dia em que a pessoa se dedicou à tarefa.

    @Column(nullable = false)
    // Torna obrigatória a quantidade de minutos.

    private Integer minutos;
    // Guarda o tempo dedicado, como 25 minutos.

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // Vários registros de foco podem pertencer à mesma tarefa.

    @JoinColumn(name = "tarefa_id", nullable = false)
    // Cria a chave estrangeira para a tarefa.

    private Tarefa tarefa;
    // Guarda a tarefa que recebeu esse tempo de dedicação.

    public RegistroFoco() {
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

    public LocalDate getData() {
        return data;
        // Retorna a data da atividade.
    }

    public void setData(LocalDate data) {
        this.data = data;
        // Atualiza a data da atividade.
    }

    public Integer getMinutos() {
        return minutos;
        // Retorna os minutos dedicados.
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
        // Atualiza os minutos dedicados.
    }

    public Tarefa getTarefa() {
        return tarefa;
        // Retorna a tarefa vinculada.
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
        // Define a tarefa vinculada.
    }
}