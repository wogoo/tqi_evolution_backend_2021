package com.wogoo.tqbank.tqbank.config

import com.wogoo.tqbank.tqbank.enums.Role
import com.wogoo.tqbank.tqbank.repository.CustomerRepository
import com.wogoo.tqbank.tqbank.security.AuthenticationFilter
import com.wogoo.tqbank.tqbank.security.AuthorizationFilter
import com.wogoo.tqbank.tqbank.security.CustomAuthenticationEntryPoint
import com.wogoo.tqbank.tqbank.security.JwtUtil
import com.wogoo.tqbank.tqbank.service.UserDetailsCustomService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.util.*

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig(
    private val customerRepository: CustomerRepository,
    private val userDetails: UserDetailsCustomService,
    private val jwtUtil: JwtUtil,
    private val customEntryPoint: CustomAuthenticationEntryPoint
) : WebSecurityConfigurerAdapter() {

    private val PUBLIC_MATCHERS = arrayOf(
        "/**"
    )
    private val PUBLIC_POST_MATCHERS = arrayOf(
        "/api/v1/customers",
        "/api/v1/loans"
    )
    private val ADMIN_MATCHERS = arrayOf(
        "/admin/**"
    )
    private val PUBLIC_GET_MATCHERS = arrayOf(
        "/api/v1/loans"
    )

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetails).passwordEncoder(bCryptPasswordEncoder())

    }


    override fun configure(http: HttpSecurity) {
        http.cors().and().csrf().disable()
        http.authorizeRequests()
            .antMatchers(*PUBLIC_MATCHERS).permitAll()
            .antMatchers(HttpMethod.POST, *PUBLIC_POST_MATCHERS).permitAll()
            .antMatchers(HttpMethod.GET, *PUBLIC_GET_MATCHERS).permitAll()
            .antMatchers(*ADMIN_MATCHERS).hasAuthority(Role.ADMIN.description)
            .anyRequest().authenticated()
        http.addFilter(AuthenticationFilter(authenticationManager(), customerRepository, jwtUtil))
        http.addFilter(AuthorizationFilter(authenticationManager(), userDetails, jwtUtil))
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.exceptionHandling().authenticationEntryPoint(customEntryPoint)
    }

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/v3/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**",
            "/swagger-ui.html", "/webjars/**","/swagger-ui/**", "/javainuse-openapi/**")/*.anyRequest() <- error -> /v3/api-docs*/

    }

    @Bean
    fun carsConfig(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
        config.addAllowedOriginPattern("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

}