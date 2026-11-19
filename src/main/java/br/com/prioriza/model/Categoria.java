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

@Table(name = "categorias")
// Define o nome da tabela.

public class Categoria {

    @Id
    // Define a chave primária.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Gera o identificador automaticamente.

    private Long id;
    // Identificador da categoria.

    @Column(nullable = false, length = 50)
    // Exige um nome e limita a 50 caracteres no banco.

    private String nome;
    // Exemplos: Estudos, Trabalho e Pessoal.

    @Column(nullable = false, length = 7)
    // Guarda uma cor no formato hexadecimal, como #2563EB.

    private String cor = "#2563EB";
    // Define azul como a cor inicial da categoria.

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // Várias categorias podem pertencer ao mesmo usuário.
    // LAZY permite carregar os dados do usuário quando necessários.

    @JoinColumn(name = "usuario_id", nullable = false)
    // Cria a chave estrangeira que liga a categoria ao usuário.

    private Usuario usuario;
    // Guarda a referência ao dono da categoria.

    public Categoria() {
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

    public String getNome() {
        return nome;
        // Retorna o nome.
    }

    public void setNome(String nome) {
        this.nome = nome;
        // Atualiza o nome.
    }

    public String getCor() {
        return cor;
        // Retorna a cor.
    }

    public void setCor(String cor) {
        this.cor = cor;
        // Atualiza a cor.
    }

    public Usuario getUsuario() {
        return usuario;
        // Retorna o usuário dono da categoria.
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        // Define o usuário dono da categoria.
    }
}