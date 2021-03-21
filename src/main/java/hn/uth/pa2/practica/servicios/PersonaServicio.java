/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.practica.servicios;

import hn.uth.pa2.practica.modelos.Personas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.uth.pa2.practica.repositorios.PersonaRepositorio;

/**
 *
 * @author uth
 */
@Service
public class PersonaServicio {
    @Autowired
    private PersonaRepositorio repositorio;
    
    public Personas guardar(Personas entidad){
        return repositorio.save(entidad);
    }
    
    public void eliminar(Long id){
        repositorio.deleteById(id);
    }
    
    public Optional<Personas> getValor(Long id){
        return repositorio.findById(id);
    }
    
    public List<Personas> getTodos(){
        return (List<Personas>)repositorio.findAll();
    }
}
