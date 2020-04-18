package controller;

import model.Product;
import repository.ProductRepoImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    ProductRepoImpl productService = new ProductRepoImpl();
    public List<Product> showProductList() {
        return productService.showProductList();
    }


    public void add(Product product){
        productService.add(product);
    }

    public  void editProduct(int index, Product product){
        productService.editProduct(index,product);
    }

    public void removeProduct(int index){
        productService.removeProduct(index);

    }

    public String findByName(String name){
        return productService.findByName(name);
    }

    public void findById(int id) {
        productService.findByID(id);
    }

    public ArrayList<Product> sortUp(){
        return productService.sortUp();
    }
    public ArrayList<Product> sortDown(){
        return productService.sortDown();
    }
}
