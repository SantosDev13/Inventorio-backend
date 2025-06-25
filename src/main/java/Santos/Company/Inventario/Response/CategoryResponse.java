package Santos.Company.Inventario.Response;

import java.util.List;

import Santos.Company.Inventario.Model.Category;
import lombok.Data;

@Data
public class CategoryResponse {

    private List<Category> category;

}
