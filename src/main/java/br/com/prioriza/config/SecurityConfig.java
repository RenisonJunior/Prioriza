package br.com.prioriza.config;
// Define o pacote das configurações.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// Permite registrar configurações e objetos gerenciados pelo Spring.

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// Permite configurar as regras de segurança das páginas.

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// Disponibiliza a geração e a verificação de hashes de senha.

import org.springframework.security.web.SecurityFilterChain;
// Representa o conjunto de filtros de segurança da aplicação.

@Configuration
// Informa ao Spring que esta classe contém configurações.

public class SecurityConfig {

    @Bean
    // Disponibiliza este objeto para outras partes da aplicação.

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // Utiliza BCrypt para proteger e verificar as senhas.
    }

    @Bean
    // Registra as regras de segurança no Spring.

    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        // Recebe a ferramenta de configuração da segurança.

        http.authorizeHttpRequests(acesso -> acesso
                // Inicia a definição das permissões de acesso.

                .requestMatchers(
                        "/login",
                        "/cadastro",
                        "/css/**",
                        "/js/**",
                        "/img/**",
                        "/favicon.ico",
                        "/error"
                ).permitAll()
                // Permite acessar essas rotas sem estar conectado.

                .anyRequest().authenticated()
                // Exige login para todas as outras rotas.
        );

        http.formLogin(login -> login
                // Configura a autenticação por formulário.

                .loginPage("/login")
                // Define o endereço da nossa futura página de login.

                .loginProcessingUrl("/login")
                // Define onde o formulário enviará os dados de acesso.

                .usernameParameter("email")
                // Usa o campo email como identificação.

                .passwordParameter("senha")
                // Usa o campo senha para receber a senha digitada.

                .defaultSuccessUrl("/", true)
                // Após entrar, direciona sempre para o painel inicial.

                .failureUrl("/login?erro")
                // Se a autenticação falhar, volta ao login com um aviso.

                .permitAll()
                // Permite que pessoas desconectadas utilizem o login.
        );

        http.logout(logout -> logout
                // Configura a saída da conta.

                .logoutUrl("/logout")
                // Define a rota que receberá o formulário de saída.

                .logoutSuccessUrl("/login?saiu")
                // Depois de sair, retorna à página de login.

                .invalidateHttpSession(true)
                // Encerra a sessão do usuário.

                .deleteCookies("JSESSIONID")
                // Remove o cookie que identifica a sessão.
        );

        return http.build();
        // Finaliza e retorna a configuração de segurança.
    }
}