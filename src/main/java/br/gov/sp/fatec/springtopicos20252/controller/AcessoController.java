package br.gov.sp.fatec.springtopicos20252.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springtopicos20252.entity.Acesso;
import br.gov.sp.fatec.springtopicos20252.service.AcessoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/acesso")
public class AcessoController {

    @Autowired
    private AcessoService service;

    @GetMapping
    public ResponseEntity<List<Acesso>> buscarTodos() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }
    
    @PostMapping
    public ResponseEntity<Acesso> cadastrarNovo(@RequestBody Acesso trabalho) {
        trabalho = service.novo(trabalho);
        return ResponseEntity
            .created(URI.create("/acesso"))
            .body(trabalho);
    }

    @GetMapping(value = "/nomeEDataHoraInicio")
    public ResponseEntity<List<Acesso>> buscarTodosAcessosPorNomeEData(@RequestParam("nome") String nome, @RequestParam("dataHoraInicio") LocalDateTime dataHoraInicio) {
        return ResponseEntity.ok().body(service.buscarTodosAcessosUsuarioAposDataHoraInicio(nome, dataHoraInicio));
    }
}

