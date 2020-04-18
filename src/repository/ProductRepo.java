package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepo extends GeneralRepo<Product> {
    @Override
    List<Product> showProductList();

    @Override
    void add(Product product);

    @Override
    void editProduct(int index, Product product);

    @Override
    void removeProduct(int index);

    @Override
    String findByName(String name);

    @Override
    void findByID(int id);

    @Override
    ArrayList<Product> sortUp();

    @Override
    ArrayList<Product> sortDown();
}
