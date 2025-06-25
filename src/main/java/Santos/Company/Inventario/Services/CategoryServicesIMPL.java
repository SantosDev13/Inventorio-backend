package Santos.Company.Inventario.Services;

import java.util.List;

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

}
