/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.practica.repositorios;

import hn.uth.pa2.practica.modelos.Personas;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author uth
 */
public interface PersonaRepositorio extends CrudRepository<Personas, Long> {
    @Query(value="select * from personas a , notas n where a.id=n.id ")
    List<Personas> buscarListaTotalFinal();
}
