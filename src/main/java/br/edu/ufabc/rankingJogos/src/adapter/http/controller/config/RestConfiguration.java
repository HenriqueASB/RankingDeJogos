package br.edu.ufabc.rankingJogos.src.adapter.http.controller.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RestConfiguration extends WebMvcAutoConfiguration implements WebMvcConfigurer {
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(false);
		configurer.ignoreAcceptHeader(true);
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins(CorsConfiguration.ALL)
				.allowedHeaders(CorsConfiguration.ALL)
				.allowedMethods(HttpMethod.GET.name(),HttpMethod.PATCH.name(),HttpMethod.PUT.name(),
								HttpMethod.POST.name(),HttpMethod.DELETE.name(),HttpMethod.OPTIONS.name());
	}

}
