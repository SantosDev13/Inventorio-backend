package Santos.Company.Inventario.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Santos.Company.Inventario.Response.CategoryResponseRest;
import Santos.Company.Inventario.Services.ICategoryService;



@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService service;

    //Devuelve todas las categorias
    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories(){
        ResponseEntity<CategoryResponseRest> response = service.search();
        return response;
    }

    //Devuelve todas las categorias por el Id

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchById(@PathVariable Long id){
        ResponseEntity<CategoryResponseRest> response = service.searchById(id);
        return response;
    }
    
}
