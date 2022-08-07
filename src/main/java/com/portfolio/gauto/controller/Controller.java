
package com.portfolio.gauto.controller;

import com.portfolio.gauto.entity.Persona;
import com.portfolio.gauto.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:4200")

public class Controller {
    @Autowired IPersonaService PersoServ;
    
    @PostMapping ("/nueva/persona")
    public void agregarPersona(@RequestBody Persona pers){
    PersoServ.savePersona(pers);
    }
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona>verPersonas(){
        return PersoServ.getPersonas();
    }
    
    @DeleteMapping("/personas/delete/persona/{id}")
    public void borrarPersona(@PathVariable Long id){
        PersoServ.deletePersona(id);
    }
    
    @PutMapping("/edit/persona/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestParam( "nombre") String nuevoNombre, @RequestParam( "apellido") String nuevoApellido, @RequestParam( "img") String nuevaImg){
    
        Persona persona= PersoServ.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);
         
        PersoServ.savePersona(persona);
        
        return persona;
    };
    
     @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return PersoServ.findPersona((long)1);
        
    }
        
    
    
    
    
    
}
