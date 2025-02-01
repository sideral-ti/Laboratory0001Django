--
-- Script SQL para poblar datos directo en la tabla
--
INSERT INTO proyectos
(nombre, descripcion, fecha_inicio, fecha_fin, presupuesto, estado, prioridad, responsable)
VALUES
    ('Sistema de Gestión Empresarial', 'Desarrollo de plataforma integral para administración de recursos', '2024-01-15', '2024-12-31', 150000.00, 'PLANIFICACION', 'ALTA', 'Juan Pérez'),
    ('Aplicación Móvil de E-commerce', 'Desarrollo de app para ventas online con múltiples funcionalidades', '2024-02-01', '2024-10-30', 85000.50, 'EJECUCION', 'URGENTE', 'María Rodríguez'),
    ('Infraestructura Cloud', 'Migración de servicios a infraestructura en la nube', '2024-03-10', '2024-09-15', 120000.75, 'PLANIFICACION', 'MEDIA', 'Carlos Sánchez'),
    ('Sistema de Recursos Humanos', 'Implementación de sistema para gestión de personal', '2024-01-20', '2024-11-30', 95000.25, 'EJECUCION', 'ALTA', 'Laura Martínez'),
    ('Plataforma de Análisis de Datos', 'Desarrollo de herramienta para análisis de big data', '2024-02-15', '2024-12-15', 200000.00, 'PLANIFICACION', 'URGENTE', 'Roberto García'),
    ('Sistema de Seguridad Industrial', 'Implementación de sistema de monitoreo y control', '2024-04-01', '2024-10-01', 75000.50, 'EJECUCION', 'BAJA', 'Ana López'),
    ('Portal Web Corporativo', 'Rediseño y desarrollo de sitio web institucional', '2024-01-05', '2024-07-30', 45000.00, 'FINALIZADO', 'MEDIA', 'David Torres'),
    ('CRM Personalizado', 'Sistema de gestión de relación con clientes', '2024-03-20', '2024-11-15', 110000.75, 'PLANIFICACION', 'ALTA', 'Sofía Ramírez'),
    ('Sistema de Inventario', 'Desarrollo de aplicación para control de stock', '2024-02-10', '2024-08-31', 65000.25, 'EJECUCION', 'MEDIA', 'Pablo Fernández'),
    ('Desarrollo de API Rest', 'Construcción de microservicios para integración', '2024-04-15', '2024-10-15', 90000.00, 'PLANIFICACION', 'URGENTE', 'Lucía Morales'),
    ('Sistema de Facturación Electrónica', 'Implementación de sistema de facturación digital', '2024-01-10', '2024-09-30', 80000.50, 'EJECUCION', 'ALTA', 'Miguel Álvarez'),
    ('Aplicación de Gestión Académica', 'Sistema integral para instituciones educativas', '2024-03-01', '2024-12-20', 130000.75, 'PLANIFICACION', 'MEDIA', 'Elena Gutiérrez');