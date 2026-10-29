package com.behrmann.bff_agendador_tarefas.business;

import com.behrmann.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.behrmann.bff_agendador_tarefas.business.dto.in.LoginDTORequest;
import com.behrmann.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.behrmann.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.behrmann.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.behrmann.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.behrmann.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import com.behrmann.bff_agendador_tarefas.infrastructure.client.client.UsuarioClient;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest usuarioDTO) {
        return usuarioClient.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token){
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest usuarioDTO){
        return usuarioClient.atualizaDadosUsuario(usuarioDTO, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return usuarioClient.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token){
        return  usuarioClient.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest enderecoDTO){
        return usuarioClient.cadastraEndereco(enderecoDTO,token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest telefoneDTO){
        return usuarioClient.cadastraTelefone(telefoneDTO, token);
    }

}
