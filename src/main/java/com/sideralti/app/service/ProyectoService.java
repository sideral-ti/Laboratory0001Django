package com.sideralti.app.service;

import com.sideralti.app.dto.ProyectoDto;
import com.sideralti.app.dto.ProyectoParcialDto;
import com.sideralti.app.model.enums.EstadoProyecto;
import com.sideralti.app.model.enums.NivelPrioridad;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ProyectoService {

    ProyectoDto findById(Long id);

    List<ProyectoDto> findAll();

    ProyectoDto save(ProyectoDto proyectoDTO);

    List<ProyectoDto> saveAll(List<ProyectoDto> proyectosDTO);

    ProyectoDto update(Long id, ProyectoDto proyectoDTO);

    void deleteById(Long id);

    void deleteAll();

    long count();

    List<ProyectoDto> findByEstado(EstadoProyecto estado);

    List<ProyectoDto> findByPrioridad(NivelPrioridad prioridad);

    List<ProyectoDto> findByResponsable(String responsable);

    List<ProyectoDto> findByPresupuestoGreaterThan(BigDecimal presupuesto);

    List<ProyectoDto> findByFechaInicioBetween(LocalDate start, LocalDate end);

    List<ProyectoDto> findByNombreContaining(String nombreParcial);

    List<ProyectoDto> buscarProyectosPorResponsableParcial(String nombreResponsable);

    List<ProyectoDto> buscarProyectosPorRangoPresupuesto(BigDecimal presupuestoMinimo, BigDecimal presupuestoMaximo);

    List<ProyectoDto> buscarProyectosPorPrefijoNombre(String prefijo);

    List<ProyectoDto> buscarProyectosAnterioresA(LocalDate fecha);

    List<ProyectoDto> buscarProyectosPorPrioridadOrdenadosPorPresupuesto(NivelPrioridad prioridad);

    List<ProyectoDto> buscarProyectosPorEstadoYPrioridad(EstadoProyecto estado, NivelPrioridad prioridad);


    // RECORDS
    List<ProyectoParcialDto> findByEstadoParcial(EstadoProyecto estado);

    List<ProyectoParcialDto> findByPrioridadParcial(NivelPrioridad prioridad);

    List<ProyectoParcialDto> findByFechaInicioBetweenProyectoParcialDto(LocalDate startDate, LocalDate endDate);

    List<ProyectoParcialDto> findByResponsableProyectoParcialDto(String responsable);

    List<ProyectoParcialDto> findByPresupuestoGreaterThanEqual(BigDecimal presupuesto);

    List<ProyectoParcialDto> findByNombreContainingIgnoreCase(String keyword);




    List<ProyectoDto> filtrarPorEstado(EstadoProyecto estado);

    List<ProyectoDto> filtrarPorPrioridad(NivelPrioridad prioridad);

    List<ProyectoDto> filtrarPorPresupuestoMayor(BigDecimal presupuestoMinimo);

    List<ProyectoDto> filtrarPorFechaInicioPosterior(LocalDate fechaInicio);
}
