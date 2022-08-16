
package com.portfolio.gauto.controller;

import com.portfolio.gauto.entity.Persona;
import com.portfolio.gauto.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@CrossOrigin(origins ="https://portfolio-jeremiasgauto.web.app")

public class Controller {
    @Autowired IPersonaService PersoServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/nueva/persona")
    public String agregarPersona(@RequestBody Persona pers){
    PersoServ.savePersona(pers);
    return "La persona fue creada exitosamente";
    }
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona>verPersonas(){
        return PersoServ.getPersonas();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/persona/{id}")
    public String borrarPersona(@PathVariable Long id){
        PersoServ.deletePersona(id);
        return "La persona fue eliminada de manera exitosa";
    }
    


  
    
    @PutMapping("/edit/persona")
    public ResponseEntity<Persona>editarPersona(@RequestBody Persona persona){
        Persona updatePersona=PersoServ.savePersona(persona);
        return new ResponseEntity<>(updatePersona, HttpStatus.OK);
    }
    
     @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return PersoServ.findPersona((long)1);
        
    }
        
    
    
    
    
    
}
