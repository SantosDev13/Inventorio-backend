package Santos.Company.Inventario.Services;

import org.springframework.http.ResponseEntity;

import Santos.Company.Inventario.Model.Category;
import Santos.Company.Inventario.Response.CategoryResponseRest;

public interface ICategoryService {

    public ResponseEntity <CategoryResponseRest> search();
    public ResponseEntity <CategoryResponseRest> searchById(Long id);
    public ResponseEntity <CategoryResponseRest> save(Category category);
    public ResponseEntity <CategoryResponseRest> update(Category category,Long id);
    public ResponseEntity <CategoryResponseRest> deleteById(Long id);

}
