package com.sideralti.app.mapper;

import com.sideralti.app.dto.ProyectoDto;
import com.sideralti.app.model.Proyecto;
import org.springframework.stereotype.Component;

@Component
public class ProyectoMapper {

    public ProyectoDto toDto(Proyecto proyecto) {
        if (proyecto == null) return null;

        ProyectoDto dto = new ProyectoDto();
        dto.setId(proyecto.getId());
        dto.setNombre(proyecto.getNombre());
        dto.setDescripcion(proyecto.getDescripcion());
        dto.setFechaInicio(proyecto.getFechaInicio());
        dto.setFechaFin(proyecto.getFechaFin());
        dto.setPresupuesto(proyecto.getPresupuesto());
        dto.setEstado(proyecto.getEstado());
        dto.setPrioridad(proyecto.getPrioridad());
        dto.setResponsable(proyecto.getResponsable());
        return dto;
    }

    public Proyecto toEntity(ProyectoDto dto) {
        if (dto == null) return null;

        Proyecto proyecto = new Proyecto();
        proyecto.setId(dto.getId());
        proyecto.setNombre(dto.getNombre());
        proyecto.setDescripcion(dto.getDescripcion());
        proyecto.setFechaInicio(dto.getFechaInicio());
        proyecto.setFechaFin(dto.getFechaFin());
        proyecto.setPresupuesto(dto.getPresupuesto());
        proyecto.setEstado(dto.getEstado());
        proyecto.setPrioridad(dto.getPrioridad());
        proyecto.setResponsable(dto.getResponsable());
        return proyecto;
    }
}