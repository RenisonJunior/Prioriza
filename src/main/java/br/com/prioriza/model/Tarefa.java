package br.com.prioriza.model;
// Define o pacote da classe.

import java.time.LocalDate;
// Permite trabalhar com datas sem horário.

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

@Table(name = "tarefas")
// Define o nome da tabela.

public class Tarefa {

    @Id
    // Define a chave primária.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Gera o identificador automaticamente.

    private Long id;
    // Identificador da tarefa.

    @Column(nullable = false, length = 120)
    // Exige um título com até 120 caracteres no banco.

    private String titulo;
    // Exemplo: Preparar apresentação de Tecnologia Web.

    @Column(length = 1000)
    // Permite uma descrição opcional de até 1000 caracteres.

    private String descricao;
    // Guarda informações adicionais sobre a tarefa.

    @Column(nullable = false)
    // Torna obrigatório informar um prazo.

    private LocalDate prazo;
    // Guarda a data limite para concluir a tarefa.

    @Column(nullable = false)
    // Torna obrigatório informar a prioridade.

    private Integer prioridade = 2;
    // 1 = alta, 2 = média e 3 = baixa.

    @Column(nullable = false)
    // Torna obrigatório informar a duração prevista.

    private Integer minutosEstimados = 30;
    // Define 30 minutos como duração inicial.

    @Column(nullable = false)
    // Impede que a situação de conclusão fique nula no banco.

    private boolean concluida = false;
    // Uma tarefa nova começa pendente.

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // Várias tarefas podem pertencer ao mesmo usuário.

    @JoinColumn(name = "usuario_id", nullable = false)
    // Cria a chave estrangeira para a tabela de usuários.

    private Usuario usuario;
    // Guarda o dono da tarefa.

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // Várias tarefas podem utilizar a mesma categoria.

    @JoinColumn(name = "categoria_id", nullable = false)
    // Cria a chave estrangeira para a tabela de categorias.

    private Categoria categoria;
    // Guarda a categoria da tarefa.

    public Tarefa() {
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

    public String getDescricao() {
        return descricao;
        // Retorna a descrição.
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
        // Atualiza a descrição.
    }

    public LocalDate getPrazo() {
        return prazo;
        // Retorna o prazo.
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
        // Atualiza o prazo.
    }

    public Integer getPrioridade() {
        return prioridade;
        // Retorna o número da prioridade.
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
        // Atualiza a prioridade.
    }

    public Integer getMinutosEstimados() {
        return minutosEstimados;
        // Retorna a duração prevista.
    }

    public void setMinutosEstimados(Integer minutosEstimados) {
        this.minutosEstimados = minutosEstimados;
        // Atualiza a duração prevista.
    }

    public boolean isConcluida() {
        return concluida;
        // Informa se a tarefa foi concluída.
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
        // Marca a tarefa como concluída ou pendente.
    }

    public Usuario getUsuario() {
        return usuario;
        // Retorna o dono da tarefa.
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        // Define o dono da tarefa.
    }

    public Categoria getCategoria() {
        return categoria;
        // Retorna a categoria.
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        // Define a categoria.
    }
}