/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.practica.controladores;

import hn.uth.pa2.practica.modelos.Personas;
import hn.uth.pa2.practica.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author uth
 */
@Controller
public class PersonaUIControlador {
 @Autowired
 private PersonaServicio servicio;
 
 @RequestMapping("/")
 public String index(Model model){
     setParametro(model,"lista", servicio.getTodos());
     return "index";
 }
 
 @GetMapping("/crear")
 public String irCrear(Model model){
     setParametro(model,"persona", new Personas());
     return "persona";
 }
 
 @GetMapping("/actualizar/{id}")
 public String irActualizar(@PathVariable("id") Long id, Model model){
     setParametro(model,"persona",servicio.getValor(id));
     return "persona";
 }
 
 @PostMapping("/guardar")
 public String guardar(Personas persona, Model model){
     servicio.guardar(persona);
     return "redirect:/";
 }
 
 @GetMapping("/eliminar/{id}")
 public String eliminar(@PathVariable("id") Long id, Model model){
     servicio.eliminar(id);
     return "redirect:/";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }
}
