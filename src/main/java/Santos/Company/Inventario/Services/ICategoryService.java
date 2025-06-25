package Santos.Company.Inventario.Services;

import org.springframework.http.ResponseEntity;

import Santos.Company.Inventario.Response.CategoryResponseRest;

public interface ICategoryService {

    public ResponseEntity <CategoryResponseRest> search();
    public ResponseEntity <CategoryResponseRest> searchById(Long id);

}
