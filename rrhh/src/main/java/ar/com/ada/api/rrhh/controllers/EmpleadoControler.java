package ar.com.ada.api.rrhh.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.rrhh.entities.Empleado;
import ar.com.ada.api.rrhh.models.requests.infoBasicaEmpleadoRequest;
import ar.com.ada.api.rrhh.models.responses.GenericResponse;
import ar.com.ada.api.rrhh.services.CategoriaService;
import ar.com.ada.api.rrhh.services.EmpleadoService;

@RestController
public class EmpleadoControler {

  @Autowired
  EmpleadoService empleadoService;
  @Autowired
  CategoriaService categoriaService;

  @PostMapping("/empleados")
  public ResponseEntity<?> crearEmpleado(@RequestBody infoBasicaEmpleadoRequest info) {

    Empleado empleado = new Empleado();
    empleado.setNombre(info.nombre);
    empleado.setEdad(info.edad);
    empleado.setSueldo(info.sueldo);
    empleado.setCategoria(categoriaService.buscarCategoriaPorId(info.categoriaId));
    empleado.setFechaAlta(new Date());
    empleado.setEstadoId(1);
    empleadoService.crearEmpleado(empleado);

    GenericResponse resp = new GenericResponse();
    resp.isOk = true;
    resp.id = empleado.getEmpleadoId();
    resp.message = "empleado genarado con exito";

    return ResponseEntity.ok(resp);
  }

  @GetMapping("/empleados")
  public ResponseEntity<?> listarEmpleado() {

    return ResponseEntity.ok(empleadoService.listarEmpleados());

  }

}
