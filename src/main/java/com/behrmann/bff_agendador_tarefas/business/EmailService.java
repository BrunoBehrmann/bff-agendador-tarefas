package com.behrmann.bff_agendador_tarefas.business;

import com.behrmann.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.behrmann.bff_agendador_tarefas.infrastructure.client.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse tarefasDTO) {
        emailClient.enviarEmail(tarefasDTO);
    }

}
