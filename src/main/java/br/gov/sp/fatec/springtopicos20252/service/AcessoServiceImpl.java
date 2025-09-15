package br.gov.sp.fatec.springtopicos20252.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springtopicos20252.entity.Acesso;
import br.gov.sp.fatec.springtopicos20252.repository.AcessoRepository;

@Service
public class AcessoServiceImpl implements AcessoService {

    @Autowired
    private AcessoRepository acessoRepo;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public List<Acesso> buscarTodos() {
        return acessoRepo.findAll();
    }

    @Override
    public Acesso novo(Acesso acesso) {
        if (acesso == null ||
                acesso.getUsuario() == null ||
                acesso.getUsuario().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não informado!");
        }
        if (acesso.getTempoAcesso() != null && acesso.getTempoAcesso() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Se informado, tempo de acesso deve ser maior do que zero!");
        }
        if (!acesso.getTipo().equals("Setup") &&
                !acesso.getTipo().equals("Config") &&
                !acesso.getTipo().equals("Maint")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Tipo inválido. Tipos válidos: Setup, Config ou Maint.");
        }
        if (acesso.getDataHoraInicio() == null) {
            acesso.setDataHoraInicio(LocalDateTime.now());
        }
        acesso.setUsuario(usuarioService.buscarPeloId(acesso.getUsuario().getId()));
        return acessoRepo.save(acesso);
    }

    @Override
    public List<Acesso> buscarTodosAcessosUsuarioAposDataHoraInicio(String nome, LocalDateTime dataHoraInicio) {
        return acessoRepo.findByUsuarioNomeAndDataHoraInicioGreaterThan(nome, dataHoraInicio);
    }

}
