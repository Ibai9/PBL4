/*
package com.registro.usuarios.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.servicio.UsuarioServicio;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioServicio);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            String email = "user@proba";
            if (usuarioServicio.findByEmail(email) == null) {
                UsuarioRegistroDTO userDto = new UsuarioRegistroDTO();
                userDto.setNombre("user");
                userDto.setApellido("proba");
                userDto.setEmail(email);
                userDto.setPassword("12345");
                usuarioServicio.guardar(userDto);
            }
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/registro**", "/js/**", "/css/**", "/img/**", "/images/**", "/static/**", "/video/**").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/").denyAll() // Denegar el acceso a la ruta raíz
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
                        if (roles.contains("ROLE_ADMIN")) {
                            response.sendRedirect("/admin");
                        } else {
                            response.sendRedirect("/index");
                        }
                    }
                })
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                });
    }
}
*/

package com.registro.usuarios.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.registro.usuarios.servicio.UsuarioServicio;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioServicio);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests
                        .antMatchers("/registro**", "/js/**", "/css/**", "/img/**", "/images/**", "/static/**", "/video/**").permitAll()
                        .antMatchers("/admin").hasRole("ADMIN")
                        .antMatchers("/").denyAll()
                        .anyRequest().authenticated()
        )
        .formLogin(formLogin ->
                formLogin
                        .loginPage("/login")
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                                Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
                                if (roles.contains("ROLE_ADMIN")) {
                                    response.sendRedirect("/admin");
                                } else {
                                    response.sendRedirect("/index");
                                }
                            }
                        })
                        .permitAll()
        )
        .logout(logout ->
                logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
        )
        .exceptionHandling(exceptionHandling ->
                exceptionHandling
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.sendError(HttpServletResponse.SC_FORBIDDEN);
                        })
        );
    }
}

