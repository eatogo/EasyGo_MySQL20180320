package idv.ron.server.products;

import java.util.List;

public interface ProductDao {
	int insert(Foods food);
	int update(Foods food);
	int delete(int id);
	Foods findById(int id);
	List<Foods> getAll();
	byte[] getImage(int id);
}
