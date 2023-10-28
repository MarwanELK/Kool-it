package project.spring.backend_koolit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.spring.backend_koolit.model.Recette;
import project.spring.backend_koolit.service.BackendService;

import java.util.List;

@RestController
public class BackendController {
    @Autowired
    private BackendService backendService;

    /*@RequestMapping("/hello")
    public String sayHello(){
        return "Hello world !";
    }*/

    @RequestMapping("/recettes")
    public List<Recette> getRecettes(){
        return backendService.getRecettes();
    }

    @RequestMapping("/recettes/{id}")
    public Recette getRecette(@PathVariable long id){
        return backendService.getRecette(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/recette/{id}")
    public void deleteRecette(@PathVariable long id){
        backendService.deleteRecette(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/recettes")
    public void addRecette(@RequestBody Recette recette){
        backendService.addRecette(recette);
    }

    @RequestMapping (method = RequestMethod.PUT, value = "recette/{id}")
    public void updateRecette(@RequestBody Recette recette, @PathVariable long id){
        backendService.updateRecette(recette, id);
    }
}
