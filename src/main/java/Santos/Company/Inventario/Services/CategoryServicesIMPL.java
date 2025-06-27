package Santos.Company.Inventario.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Santos.Company.Inventario.Dao.ICategoryDao;
import Santos.Company.Inventario.Model.Category;
import Santos.Company.Inventario.Response.CategoryResponseRest;

@Service
public class CategoryServicesIMPL implements ICategoryService{

    @Autowired
    ICategoryDao categoryDao;

    //BUSQUEDA GENERAL
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<CategoryResponseRest> search() {
        
        CategoryResponseRest response = new CategoryResponseRest();

        try {
            List<Category> category = (List<Category>) categoryDao.findAll();
            response.getCategoryResponse().setCategory(category);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");

        } catch (Exception e) {

            response.setMetadata("Respuesta No ok", "-1", "Error al consultar");
            e.getStackTrace();

            return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity <>(response, HttpStatus.OK);
    }

    //METODO DE BUSQUEDA POR ID
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {
        
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {
            
            Optional<Category> category = categoryDao.findById(id);
            if(category.isPresent()){
                list.add(category.get());
                response.getCategoryResponse().setCategory(list);
                response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
            }
            else{
            response.setMetadata("Respuesta No ok", "-1", "Error al consultar por id");
            return new ResponseEntity <>(response, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {

            response.setMetadata("Respuesta No ok", "-1", "Error al consultar");
            e.getStackTrace();

            return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //Guardar las categorias
    @Transactional
    @Override
    public ResponseEntity<CategoryResponseRest> save(Category category) {
        
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {
            
            Category categorySaved =categoryDao.save(category);

            if(categorySaved != null){
                list.add(categorySaved);
                response.getCategoryResponse().setCategory(list);
                response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
            }else{
            response.setMetadata("Respuesta No ok", "-1", "Error al guardar");
            return new ResponseEntity <>(response, HttpStatus.BAD_REQUEST);
            }
            
        } catch (Exception e) {
            response.setMetadata("Respuesta No ok", "-1", "Error al guardar la categoria");
            e.getStackTrace();

            return new ResponseEntity <>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    @Override
    public ResponseEntity<CategoryResponseRest> update(Category category, Long id) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> list = new ArrayList<>();

        try {
            
            Optional<Category> categorySearch = categoryDao.findById(id);
            if(categorySearch.isPresent()){
                //se procederá a actualizar el registro
                categorySearch.get().setName(category.getName());
                categorySearch.get().setDescription(category.getDescription());

                Category categoryToUpdate = categoryDao.save(categorySearch.get());

                if(categoryToUpdate !=null){
                    list.add(categoryToUpdate);
                    response.getCategoryResponse().setCategory(list);
                    response.setMetadata("RESPUESTA OK ", "00", "CATEGORIA ACTUALIZADA");
                }else{
                    response.setMetadata("Respuesta No ok", "-1", "Categoria no actualizada");
                    return new ResponseEntity <>(response, HttpStatus.BAD_REQUEST);
                }
            } else{
            response.setMetadata("Respuesta No ok", "-1", "Categoria no encontrada");
            return new ResponseEntity <>(response, HttpStatus.NOT_FOUND);
            }

            
        } catch (Exception e) {
            response.setMetadata("Respuesta No ok", "-1", "Error al guardar la categoria");
            e.getStackTrace();

            return new ResponseEntity <>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
