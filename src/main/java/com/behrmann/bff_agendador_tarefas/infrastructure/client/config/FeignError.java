package com.behrmann.bff_agendador_tarefas.infrastructure.client.config;

import com.behrmann.bff_agendador_tarefas.infrastructure.exceptions.BusinessException;
import com.behrmann.bff_agendador_tarefas.infrastructure.exceptions.ConflictException;
import com.behrmann.bff_agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.behrmann.bff_agendador_tarefas.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {


    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 409:
                return new ConflictException("Erro atributo já existente ");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado ");
            case 401:
                return new UnauthorizedException("Erro usuário não encontrado ");
            default:
                return new BusinessException("Erro de servidor ");
        }
    }
}
