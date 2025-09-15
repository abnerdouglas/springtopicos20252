package br.gov.sp.fatec.springtopicos20252.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springtopicos20252.entity.Acesso;

public interface AcessoRepository extends JpaRepository<Acesso, Long>
{
    List<Acesso> findByUsuarioNomeAndDataHoraInicioGreaterThan(String nome, LocalDateTime dataHoraInicio);
}
