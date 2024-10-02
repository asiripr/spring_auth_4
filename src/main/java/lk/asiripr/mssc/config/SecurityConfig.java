package lk.asiripr.mssc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//	/api/** authenticated httpBasic
	@Bean
	@Order(1)
	SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
		return http.securityMatcher("/api/posts").authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.httpBasic(Customizer.withDefaults()).build();
	}

	@Bean
	@Order(2)
	SecurityFilterChain h2consoleSecurityFilterChain(HttpSecurity http) throws Exception {
		return http.securityMatcher(AntPathRequestMatcher.antMatcher("/h2-console/**"))
				.authorizeHttpRequests(
						auth -> auth.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll())
				.csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))
				.headers(headers -> headers.frameOptions().disable()).build();
	}

	// /permitAll() /private = login with a formLogin
	@Bean
	@Order(3)
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(auth -> auth.requestMatchers("/").permitAll().anyRequest().authenticated())
				.formLogin(Customizer.withDefaults()).build();

	}

}
