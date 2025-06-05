package com.unifacisa.neomed.util;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.unifacisa.neomed.entity.ProfissionalDeSaude;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class JacksonConfig {

    @Bean
    public SimpleModule profissionalDeSaudeDeserializerModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(ProfissionalDeSaude.class, new ProfissionalDeSaudeDeserializer());
        return module;
    }
    
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        return converter;
    }
}