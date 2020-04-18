package repository;

import java.util.ArrayList;
import java.util.List;

public interface GeneralRepo<E> {
    List<E> showProductList();
    void add(E e);
    void editProduct(int index, E e);
    void removeProduct(int index);
    String findByName(String name);
    void findByID(int id);
    ArrayList<E> sortUp();
    ArrayList<E> sortDown();
}
