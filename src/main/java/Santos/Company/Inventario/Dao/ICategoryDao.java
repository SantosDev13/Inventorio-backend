package Santos.Company.Inventario.Dao;

import org.springframework.data.repository.CrudRepository;

import Santos.Company.Inventario.Model.Category;

public interface ICategoryDao extends CrudRepository <Category, Long>{

}
