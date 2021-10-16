package br.com.juliancambraia.receitaws.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CnpjFeignConfig {

    @Value("${api.cnpj.username}")
    private String username;

    @Value("${api.cnpj.password}")
    private String password;

    private BasicAuthRequestInterceptor interceptor;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(username, password);
    }
}
