package com.sideralti.app.dto;

import com.sideralti.app.model.enums.EstadoProyecto;
import com.sideralti.app.model.enums.NivelPrioridad;

public record ProyectoParcialDto(Long id,
                                 String nombre,
                                 EstadoProyecto estado,
                                 NivelPrioridad prioridad,
                                 String responsable) {}
