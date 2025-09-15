package br.gov.sp.fatec.springtopicos20252.service;

import java.time.LocalDateTime;
import java.util.List;

import br.gov.sp.fatec.springtopicos20252.entity.Acesso;

public interface AcessoService {

    public Acesso novo(Acesso acesso);

    public List<Acesso> buscarTodos();

    public List<Acesso> buscarTodosAcessosUsuarioAposDataHoraInicio(String nome, LocalDateTime dataHoraInicio);
    
}
