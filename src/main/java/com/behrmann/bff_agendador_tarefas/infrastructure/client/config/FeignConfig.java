package com.behrmann.bff_agendador_tarefas.infrastructure.client.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.openfeign.FeignErrorDecoderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignError feignError(){
        return new FeignError();
    }
}
