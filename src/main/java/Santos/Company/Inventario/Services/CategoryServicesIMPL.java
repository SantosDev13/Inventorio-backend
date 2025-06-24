package Santos.Company.Inventario.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Santos.Company.Inventario.Dao.ICategoryDao;
import Santos.Company.Inventario.Response.CategoryResponseRest;

@Service
public class CategoryServicesIMPL implements ICategoryService{

    @Autowired
    ICategoryDao categoryDao;

    @Override
    public ResponseEntity<CategoryResponseRest> search() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}
