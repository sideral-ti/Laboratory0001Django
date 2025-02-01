package com.sideralti.app.service.impl;

import com.sideralti.app.dto.ProyectoDto;
import com.sideralti.app.dto.ProyectoParcialDto;
import com.sideralti.app.mapper.ProyectoMapper;
import com.sideralti.app.model.Proyecto;
import com.sideralti.app.model.enums.EstadoProyecto;
import com.sideralti.app.model.enums.NivelPrioridad;
import com.sideralti.app.repository.ProyectoRepository;
import com.sideralti.app.service.ProyectoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;
    private final ProyectoMapper proyectoMapper;

    public ProyectoServiceImpl(ProyectoRepository proyectoRepository, ProyectoMapper proyectoMapper) {
        this.proyectoRepository = proyectoRepository;
        this.proyectoMapper = proyectoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public ProyectoDto findById(Long id) {
        Proyecto entity = proyectoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proyecto no encontrado con ID: " + id));
        return proyectoMapper.toDto(entity);
    }

    public List<ProyectoDto> findAll() {
        return proyectoRepository.findAll().stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProyectoDto save(ProyectoDto proyectoDTO) {
        Proyecto proyecto = proyectoMapper.toEntity(proyectoDTO);
        return proyectoMapper.toDto(proyectoRepository.save(proyecto));
    }

    public List<ProyectoDto> saveAll(List<ProyectoDto> proyectosDTO) {
        List<Proyecto> proyectos = proyectosDTO.stream()
                .map(proyectoMapper::toEntity)
                .collect(Collectors.toList());
        return proyectoRepository.saveAll(proyectos).stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProyectoDto update(Long id, ProyectoDto proyectoDTO) {
        // Buscar el proyecto existente, lanzar EntityNotFoundException si no existe
        Proyecto proyectoExistente = proyectoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proyecto no encontrado con ID: " + id));

        // Actualizar campos uno por uno
        proyectoExistente.setNombre(proyectoDTO.getNombre());
        proyectoExistente.setDescripcion(proyectoDTO.getDescripcion());
        proyectoExistente.setFechaInicio(proyectoDTO.getFechaInicio());
        proyectoExistente.setFechaFin(proyectoDTO.getFechaFin());
        proyectoExistente.setPresupuesto(proyectoDTO.getPresupuesto());
        proyectoExistente.setEstado(proyectoDTO.getEstado());
        proyectoExistente.setPrioridad(proyectoDTO.getPrioridad());
        proyectoExistente.setResponsable(proyectoDTO.getResponsable());

        // Guardar y devolver el proyecto actualizado
        return proyectoMapper.toDto(proyectoRepository.save(proyectoExistente));
    }

    public void deleteById(Long id) {
        proyectoRepository.deleteById(id);
    }

    public void deleteAll() {
        proyectoRepository.deleteAll();
    }

    public long count() {
        return proyectoRepository.count();
    }


    // Método para buscar proyectos por estado
    public List<ProyectoDto> findByEstado(EstadoProyecto estado) {
        return proyectoRepository.findByEstado(estado).stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // Método para buscar proyectos por prioridad
    public List<ProyectoDto> findByPrioridad(NivelPrioridad prioridad) {
        return proyectoRepository.findByPrioridad(prioridad).stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // Método para buscar proyectos por responsable
    public List<ProyectoDto> findByResponsable(String responsable) {
        return proyectoRepository.findByResponsable(responsable).stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // Método para buscar proyectos con presupuesto mayor a un valor
    public List<ProyectoDto> findByPresupuestoGreaterThan(BigDecimal presupuesto) {
        return proyectoRepository.findByPresupuestoGreaterThan(presupuesto).stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // Método para buscar proyectos entre dos fechas
    public List<ProyectoDto> findByFechaInicioBetween(LocalDate start, LocalDate end) {
        return proyectoRepository.findByFechaInicioBetween(start, end).stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // Método para buscar proyectos por nombre que contenga una cadena
    public List<ProyectoDto> findByNombreContaining(String nombreParcial) {
        return proyectoRepository.findByNombreContaining(nombreParcial).stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }


    // 1. Método para buscar proyectos por responsable parcial
    public List<ProyectoDto> buscarProyectosPorResponsableParcial(String nombreResponsable) {
        return proyectoRepository.findByResponsableContaining(nombreResponsable)
                .stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // 2. Método para buscar proyectos por rango de presupuesto
    public List<ProyectoDto> buscarProyectosPorRangoPresupuesto(BigDecimal presupuestoMinimo, BigDecimal presupuestoMaximo) {
        return proyectoRepository.findByPresupuestoBetween(presupuestoMinimo, presupuestoMaximo)
                .stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // 3. Método para buscar proyectos por prefijo de nombre
    public List<ProyectoDto> buscarProyectosPorPrefijoNombre(String prefijo) {
        return proyectoRepository.findByNombreStartingWith(prefijo)
                .stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // 4. Método para buscar proyectos con fecha de inicio anterior
    public List<ProyectoDto> buscarProyectosAnterioresA(LocalDate fecha) {
        return proyectoRepository.findByFechaInicioLessThan(fecha)
                .stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // 5. Método para buscar proyectos por prioridad ordenados por presupuesto
    public List<ProyectoDto> buscarProyectosPorPrioridadOrdenadosPorPresupuesto(NivelPrioridad prioridad) {
        return proyectoRepository.findByPrioridadOrderByPresupuestoDesc(prioridad)
                .stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // 6. Método para buscar proyectos por estado y prioridad
    public List<ProyectoDto> buscarProyectosPorEstadoYPrioridad(EstadoProyecto estado, NivelPrioridad prioridad) {
        return proyectoRepository.findByEstadoAndPrioridad(estado, prioridad)
                .stream()
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }





    public List<ProyectoParcialDto> findByEstadoParcial(EstadoProyecto estado) {
        return proyectoRepository.findByEstado(estado)
                .stream()
                .map(p -> new ProyectoParcialDto(p.getId(), p.getNombre(), p.getEstado(),
                        p.getPrioridad(), p.getResponsable()))
                .collect(Collectors.toList());
    }

    public List<ProyectoParcialDto> findByPrioridadParcial(NivelPrioridad prioridad) {
        return proyectoRepository.findByPrioridad(prioridad)
                .stream()
                .map(p -> new ProyectoParcialDto(p.getId(), p.getNombre(), p.getEstado(),
                        p.getPrioridad(), p.getResponsable()))
                .collect(Collectors.toList());
    }

    public List<ProyectoParcialDto> findByFechaInicioBetweenProyectoParcialDto(LocalDate startDate, LocalDate endDate) {
        return proyectoRepository.findByFechaInicioBetween(startDate, endDate)
                .stream()
                .map(p -> new ProyectoParcialDto(p.getId(), p.getNombre(), p.getEstado(),
                        p.getPrioridad(), p.getResponsable()))
                .collect(Collectors.toList());
    }

    public List<ProyectoParcialDto> findByResponsableProyectoParcialDto(String responsable) {
        return proyectoRepository.findByResponsableContaining(responsable)
                .stream()
                .map(p -> new ProyectoParcialDto(p.getId(), p.getNombre(), p.getEstado(),
                        p.getPrioridad(), p.getResponsable()))
                .collect(Collectors.toList());
    }

    public List<ProyectoParcialDto> findByPresupuestoGreaterThanEqual(BigDecimal presupuesto) {
        return proyectoRepository.findByPresupuestoGreaterThanEqual(presupuesto)
                .stream()
                .map(p -> new ProyectoParcialDto(p.getId(), p.getNombre(), p.getEstado(),
                        p.getPrioridad(), p.getResponsable()))
                .collect(Collectors.toList());
    }

    public List<ProyectoParcialDto> findByNombreContainingIgnoreCase(String keyword) {
        return proyectoRepository.findByNombreContainingIgnoreCase(keyword)
                .stream()
                .map(p -> new ProyectoParcialDto(p.getId(), p.getNombre(), p.getEstado(),
                        p.getPrioridad(), p.getResponsable()))
                .collect(Collectors.toList());
    }






    // Método para filtrar proyectos por estado
    public List<ProyectoDto> filtrarPorEstado(EstadoProyecto estado) {
        return proyectoRepository.findAll().stream()
                .filter(proyecto -> proyecto.getEstado() == estado)
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // Método para filtrar proyectos por prioridad
    public List<ProyectoDto> filtrarPorPrioridad(NivelPrioridad prioridad) {
        return proyectoRepository.findAll().stream()
                .filter(proyecto -> proyecto.getPrioridad() == prioridad)
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // Método para filtrar proyectos por presupuesto mayor a un valor
    public List<ProyectoDto> filtrarPorPresupuestoMayor(BigDecimal presupuestoMinimo) {
        return proyectoRepository.findAll().stream()
                .filter(proyecto -> proyecto.getPresupuesto().compareTo(presupuestoMinimo) > 0)
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }

    // Método para filtrar proyectos por fecha de inicio posterior a una fecha
    public List<ProyectoDto> filtrarPorFechaInicioPosterior(LocalDate fechaInicio) {
        return proyectoRepository.findAll().stream()
                .filter(proyecto -> proyecto.getFechaInicio().isAfter(fechaInicio))
                .map(proyectoMapper::toDto)
                .collect(Collectors.toList());
    }
}