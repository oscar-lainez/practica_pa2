/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.practica.controladores;

import hn.uth.pa2.practica.modelos.Personas;
import hn.uth.pa2.practica.servicios.PersonaServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author uth
 * ws=webservice
 */
@RestController
@RequestMapping(value="/ws/persona")
public class PersonaApiControlador {
    @Autowired
    private PersonaServicio servicio;
    
    @GetMapping(value="/")
    public List<Personas> getTodos(){
        return servicio.getTodos();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Personas> getValor(@PathVariable Long id){
        return servicio.getValor(id);
    }               
    
    @PostMapping(value="/guardar")
    public Personas guardar(@RequestBody Personas persona){
        return servicio.guardar(persona);
    }
    
    @GetMapping(value="/eliminar/{id}")
    public Optional<Personas> eliminar(@PathVariable Long id){
        Optional<Personas> personaEliminado=servicio.getValor(id);
        servicio.eliminar(id);
        return personaEliminado;
    }
}
