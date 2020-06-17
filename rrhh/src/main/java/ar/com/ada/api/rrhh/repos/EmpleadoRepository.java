package ar.com.ada.api.rrhh.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.rrhh.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository <Empleado,Integer> {
    
}