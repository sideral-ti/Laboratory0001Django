package com.sideralti.app.controller.rest;

import com.sideralti.app.dto.ProyectoDto;
import com.sideralti.app.dto.ProyectoParcialDto;
import com.sideralti.app.model.enums.EstadoProyecto;
import com.sideralti.app.model.enums.NivelPrioridad;
import com.sideralti.app.service.ProyectoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest/proyectos")
public class ProyectoRestController {

    private final ProyectoService proyectoService;

    public ProyectoRestController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDto> findById(@PathVariable Long id) {
        ProyectoDto proyecto = proyectoService.findById(id);
        return proyecto != null ? ResponseEntity.ok(proyecto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ProyectoDto>> findAll() {
        return ResponseEntity.ok(proyectoService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProyectoDto> save(@RequestBody ProyectoDto proyectoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(proyectoService.save(proyectoDTO));
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<ProyectoDto>> saveAll(@RequestBody List<ProyectoDto> proyectosDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(proyectoService.saveAll(proyectosDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoDto> update(@PathVariable Long id, @RequestBody ProyectoDto proyectoDTO) {
        ProyectoDto updatedProyecto = proyectoService.update(id, proyectoDTO);
        return updatedProyecto != null ? ResponseEntity.ok(updatedProyecto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        proyectoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        proyectoService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(proyectoService.count());
    }

    // Endpoint para buscar por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ProyectoDto>> findByEstado(@PathVariable EstadoProyecto estado) {
        return ResponseEntity.ok(proyectoService.findByEstado(estado));
    }

    // Endpoint para buscar por prioridad
    @GetMapping("/prioridad/{prioridad}")
    public ResponseEntity<List<ProyectoDto>> findByPrioridad(@PathVariable NivelPrioridad prioridad) {
        return ResponseEntity.ok(proyectoService.findByPrioridad(prioridad));
    }

    // Endpoint para buscar por responsable
    @GetMapping("/responsable/{responsable}")
    public ResponseEntity<List<ProyectoDto>> findByResponsable(@PathVariable String responsable) {
        return ResponseEntity.ok(proyectoService.findByResponsable(responsable));
    }

    // Endpoint para buscar por presupuesto mayor a
    @GetMapping("/presupuesto/mayor-que/{presupuesto}")
    public ResponseEntity<List<ProyectoDto>> findByPresupuestoGreaterThan(@PathVariable BigDecimal presupuesto) {
        return ResponseEntity.ok(proyectoService.findByPresupuestoGreaterThan(presupuesto));
    }

    // Endpoint para buscar por rango de fechas
    @GetMapping("/fecha-inicio")
    public ResponseEntity<List<ProyectoDto>> findByFechaInicioBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(proyectoService.findByFechaInicioBetween(start, end));
    }

    // Endpoint para buscar por nombre parcial
    @GetMapping("/nombre")
    public ResponseEntity<List<ProyectoDto>> findByNombreContaining(@RequestParam String nombreParcial) {
        return ResponseEntity.ok(proyectoService.findByNombreContaining(nombreParcial));
    }


    // 1. Endpoint para buscar proyectos por responsable parcial
    @GetMapping("/responsable")
    public ResponseEntity<List<ProyectoDto>> buscarProyectosPorResponsableParcial(
            @RequestParam String nombreResponsable
    ) {
        return ResponseEntity.ok(proyectoService.buscarProyectosPorResponsableParcial(nombreResponsable));
    }

    // 2. Endpoint para buscar proyectos por rango de presupuesto
    @GetMapping("/presupuesto-rango")
    public ResponseEntity<List<ProyectoDto>> buscarProyectosPorRangoPresupuesto(
            @RequestParam BigDecimal presupuestoMinimo,
            @RequestParam BigDecimal presupuestoMaximo
    ) {
        return ResponseEntity.ok(proyectoService.buscarProyectosPorRangoPresupuesto(presupuestoMinimo, presupuestoMaximo));
    }

    // 3. Endpoint para buscar proyectos por prefijo de nombre
    @GetMapping("/nombre-prefijo")
    public ResponseEntity<List<ProyectoDto>> buscarProyectosPorPrefijoNombre(
            @RequestParam String prefijo
    ) {
        return ResponseEntity.ok(proyectoService.buscarProyectosPorPrefijoNombre(prefijo));
    }

    // 4. Endpoint para buscar proyectos con fecha de inicio anterior
    @GetMapping("/fecha-inicio-antes")
    public ResponseEntity<List<ProyectoDto>> buscarProyectosAnterioresA(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha
    ) {
        return ResponseEntity.ok(proyectoService.buscarProyectosAnterioresA(fecha));
    }

    // 5. Endpoint para buscar proyectos por prioridad ordenados por presupuesto
    @GetMapping("/prioridad-presupuesto")
    public ResponseEntity<List<ProyectoDto>> buscarProyectosPorPrioridadOrdenadosPorPresupuesto(
            @RequestParam NivelPrioridad prioridad
    ) {
        return ResponseEntity.ok(proyectoService.buscarProyectosPorPrioridadOrdenadosPorPresupuesto(prioridad));
    }

    // 6. Endpoint para buscar proyectos por estado y prioridad
    @GetMapping("/estado-prioridad")
    public ResponseEntity<List<ProyectoDto>> buscarProyectosPorEstadoYPrioridad(
            @RequestParam EstadoProyecto estado,
            @RequestParam NivelPrioridad prioridad
    ) {
        return ResponseEntity.ok(proyectoService.buscarProyectosPorEstadoYPrioridad(estado, prioridad));
    }






    // RECORD

    @GetMapping("/estado-parcial")
    public List<ProyectoParcialDto> getProyectosByEstado( @RequestParam EstadoProyecto estado) {
        return proyectoService.findByEstadoParcial(estado);
    }

    @GetMapping("/prioridad-parcial")
    public List<ProyectoParcialDto> getProyectosByPrioridad(@RequestParam NivelPrioridad prioridad) {
        return proyectoService.findByPrioridadParcial(prioridad);
    }

    @GetMapping("/fechas-parcial")
    public List<ProyectoParcialDto> getProyectosByFechaInicioBetween(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return proyectoService.findByFechaInicioBetweenProyectoParcialDto(startDate, endDate);
    }

    @GetMapping("/responsable-parcial")
    public List<ProyectoParcialDto> getProyectosByResponsable(@RequestParam String responsable) {
        return proyectoService.findByResponsableProyectoParcialDto(responsable);
    }

    @GetMapping("/presupuesto-parcial")
    public List<ProyectoParcialDto> getProyectosByPresupuesto(@RequestParam BigDecimal presupuesto) {
        return proyectoService.findByPresupuestoGreaterThanEqual(presupuesto);
    }

    @GetMapping("/nombre-parcial")
    public List<ProyectoParcialDto> getProyectosByNombre(@RequestParam String keyword) {
        return proyectoService.findByNombreContainingIgnoreCase(keyword);
    }




    // Endpoint 1: Filtrar proyectos por estado
    @GetMapping("/filtrar-por-estado")
    public ResponseEntity<List<ProyectoDto>> filtrarPorEstado(@RequestParam EstadoProyecto estado) {
        List<ProyectoDto> proyectosFiltrados = proyectoService.filtrarPorEstado(estado);
        return ResponseEntity.ok(proyectosFiltrados);
    }

    // Endpoint 2: Filtrar proyectos por prioridad
    @GetMapping("/filtrar-por-prioridad")
    public ResponseEntity<List<ProyectoDto>> filtrarPorPrioridad(@RequestParam NivelPrioridad prioridad) {
        List<ProyectoDto> proyectosFiltrados = proyectoService.filtrarPorPrioridad(prioridad);
        return ResponseEntity.ok(proyectosFiltrados);
    }

    // Endpoint 3: Filtrar proyectos por presupuesto mayor a un valor
    @GetMapping("/filtrar-por-presupuesto-mayor")
    public ResponseEntity<List<ProyectoDto>> filtrarPorPresupuestoMayor(@RequestParam BigDecimal presupuestoMinimo) {
        List<ProyectoDto> proyectosFiltrados = proyectoService.filtrarPorPresupuestoMayor(presupuestoMinimo);
        return ResponseEntity.ok(proyectosFiltrados);
    }

    // Endpoint 4: Filtrar proyectos por fecha de inicio posterior a una fecha
    @GetMapping("/filtrar-por-fecha-inicio-posterior")
    public ResponseEntity<List<ProyectoDto>> filtrarPorFechaInicioPosterior(@RequestParam LocalDate fechaInicio) {
        List<ProyectoDto> proyectosFiltrados = proyectoService.filtrarPorFechaInicioPosterior(fechaInicio);
        return ResponseEntity.ok(proyectosFiltrados);
    }
}