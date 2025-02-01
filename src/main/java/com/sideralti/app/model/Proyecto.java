package com.sideralti.app.model;

import com.sideralti.app.model.enums.EstadoProyecto;
import com.sideralti.app.model.enums.NivelPrioridad;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "proyectos")
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 1000)
    private String descripcion;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Column(precision = 19, scale = 2)
    private BigDecimal presupuesto;

    @Enumerated(EnumType.STRING)
    private EstadoProyecto estado;

    @Enumerated(EnumType.STRING)
    private NivelPrioridad prioridad;

    private String responsable;

    public Proyecto() {
    }

    public Proyecto(Long id, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal presupuesto, EstadoProyecto estado, NivelPrioridad prioridad, String responsable) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.presupuesto = presupuesto;
        this.estado = estado;
        this.prioridad = prioridad;
        this.responsable = responsable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public EstadoProyecto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProyecto estado) {
        this.estado = estado;
    }

    public NivelPrioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(NivelPrioridad prioridad) {
        this.prioridad = prioridad;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
