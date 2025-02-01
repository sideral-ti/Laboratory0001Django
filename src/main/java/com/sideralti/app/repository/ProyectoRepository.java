package com.sideralti.app.repository;

import com.sideralti.app.model.Proyecto;
import com.sideralti.app.model.enums.EstadoProyecto;
import com.sideralti.app.model.enums.NivelPrioridad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    // Buscar proyectos por estado
    List<Proyecto> findByEstado(EstadoProyecto estado);

    // Buscar proyectos por prioridad
    List<Proyecto> findByPrioridad(NivelPrioridad prioridad);

    // Buscar proyectos por responsable
    List<Proyecto> findByResponsable(String responsable);

    // Buscar proyectos con presupuesto mayor a un valor
    List<Proyecto> findByPresupuestoGreaterThan(BigDecimal presupuesto);

    // Buscar proyectos entre dos fechas
    List<Proyecto> findByFechaInicioBetween(LocalDate start, LocalDate end);

    // Buscar proyectos por nombre que contenga una cadena
    List<Proyecto> findByNombreContaining(String nombreParcial);


    // 1. Buscar proyectos por responsable que contenga un nombre
    List<Proyecto> findByResponsableContaining(String nombreResponsable);

    // 2. Buscar proyectos con presupuesto entre un rango
    List<Proyecto> findByPresupuestoBetween(BigDecimal presupuestoMinimo, BigDecimal presupuestoMaximo);

    // 3. Buscar proyectos por nombre que empiece con un prefijo
    List<Proyecto> findByNombreStartingWith(String prefijo);

    // 4. Buscar proyectos con fecha de inicio anterior a una fecha
    List<Proyecto> findByFechaInicioLessThan(LocalDate fecha);

    // 5. Buscar proyectos por prioridad ordenados por presupuesto descendente
    List<Proyecto> findByPrioridadOrderByPresupuestoDesc(NivelPrioridad prioridad);

    // 6. Buscar proyectos por estado y prioridad
    List<Proyecto> findByEstadoAndPrioridad(EstadoProyecto estado, NivelPrioridad prioridad);


    // RECORD
//    List<Proyecto> findByEstado(EstadoProyecto estado);
//    List<Proyecto> findByPrioridad(NivelPrioridad prioridad);
//    List<Proyecto> findByFechaInicioBetween(LocalDate startDate, LocalDate endDate);
//    List<Proyecto> findByResponsable(String responsable);
    List<Proyecto> findByPresupuestoGreaterThanEqual(BigDecimal presupuesto);
    List<Proyecto> findByNombreContainingIgnoreCase(String keyword);
}
