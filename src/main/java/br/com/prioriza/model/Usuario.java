package br.com.prioriza.model;
// Define o pacote ao qual esta classe pertence.

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Importa as ferramentas do JPA para mapear a classe no banco.

@Entity
// Informa ao JPA que esta classe representa uma entidade do banco.

@Table(name = "usuarios")
// Define o nome da tabela: usuarios.

public class Usuario {

    @Id
    // Define a chave primária da tabela.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Faz o banco gerar o identificador automaticamente.

    private Long id;
    // Guarda o identificador do usuário.

    @Column(nullable = false, length = 100)
    // Torna o campo obrigatório no banco e limita a 100 caracteres.

    private String nome;
    // Guarda o nome do usuário.

    @Column(nullable = false, unique = true, length = 150)
    // Impede e-mails nulos ou repetidos no banco.

    private String email;
    // Guarda o e-mail utilizado no login.

    @Column(nullable = false)
    // Torna obrigatório armazenar o hash da senha.

    private String senha;
    // Receberá a senha protegida por hash, nunca a senha original.

    @Column(nullable = false)
    // Torna obrigatório o tempo diário disponível.

    private Integer minutosDisponiveis = 60;
    // Define 60 minutos como valor inicial, que poderá ser alterado.

    public Usuario() {
        // Construtor sem argumentos necessário para o JPA.
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

    public String getEmail() {
        return email;
        // Retorna o e-mail.
    }

    public void setEmail(String email) {
        this.email = email;
        // Atualiza o e-mail.
    }

    public String getSenha() {
        return senha;
        // Retorna o hash armazenado.
    }

    public void setSenha(String senha) {
        this.senha = senha;
        // Armazena o valor recebido; o hash será gerado no cadastro.
    }

    public Integer getMinutosDisponiveis() {
        return minutosDisponiveis;
        // Retorna o tempo diário disponível.
    }

    public void setMinutosDisponiveis(Integer minutosDisponiveis) {
        this.minutosDisponiveis = minutosDisponiveis;
        // Atualiza o tempo diário disponível.
    }
}