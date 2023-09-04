package repository.productRepository;

import repository.product.Product;

import java.util.List;



public interface ProductRepository {
    Product getById(int id);
    List<Product> getAll();
    void add(Product product);
    void update(Product product);
    void delete(int id);
    void deleteAll();
    void createTable();
    int getDBSize();
}