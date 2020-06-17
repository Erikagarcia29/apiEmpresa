package ar.com.ada.api.rrhh.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.rrhh.entities.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{

    
}