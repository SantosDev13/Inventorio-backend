package Santos.Company.Inventario.Response;

import java.util.List;
import java.util.Locale;

import lombok.Data;

@Data
public class CategoryResponse {

    private List<Locale.Category> category;

}
