package com.behrmann.bff_agendador_tarefas.business;

import com.behrmann.bff_agendador_tarefas.business.dto.in.TarefasDTORequest;
import com.behrmann.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.behrmann.bff_agendador_tarefas.infrastructure.client.TarefasClient;
import com.behrmann.bff_agendador_tarefas.infrastructure.client.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefa(String token, TarefasDTORequest tarefasDTO) {
        return tarefasClient.gravarTarefas(tarefasDTO, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dataFinal,
                                                                    String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token) {
        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        tarefasClient.deletaTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum statusNotificacaoEnum, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(statusNotificacaoEnum, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest tarefasDTO, String id, String token) {
        return tarefasClient.updateTarefas(tarefasDTO, id, token);
    }

}
