package nosteam.IdeaProjects.PP_3_1_2_Boot_Security_new.config;

import nosteam.IdeaProjects.PP_3_1_2_Boot_Security_new.security.AuthProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthProviderImpl authProvider;

    public SecurityConfig(AuthProviderImpl authProvider) {
        this.authProvider = authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Разрешаем только страницу ошибки, так как /login теперь встроенный
                        .requestMatchers("/error").permitAll()
                        .anyRequest().authenticated()
                )
                .authenticationProvider(authProvider)

                .formLogin(form -> form
                        // .loginPage() НЕ ПИШЕМ — тогда включится стандартная форма
                        .defaultSuccessUrl("/hello", true) // Куда идти после успеха
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // Стандартный URL после выхода
                );

        return http.build();
    }
//Для кастомной страницы авторизации
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        // ВАЖНО: путь должен СОВПАДАТЬ с контроллером (включая /auth)
//                        .requestMatchers("/auth/login", "/process_login", "/error").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/auth/login") // Страница, которую мы разрешили выше
//                        .loginProcessingUrl("/process_login") // Скрытый URL, который обрабатывает POST-данные
//                        .defaultSuccessUrl("/hello", true)
//                        .permitAll() // Добавьте это для надежности
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/auth/login")
//                );
//
//        return http.build();
//    }
}

