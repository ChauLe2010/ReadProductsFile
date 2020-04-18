package controller;

import model.Product;
import repository.ProductRepoImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFile {
    private static String filePath = "ListProduct.txt";

    public ProductFile() {
    }

    public void writeFile(List<Product> products) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < products.size(); i++) {
                System.out.println(products.get(i).toString());
                oos.writeObject(products.get(i));
                oos.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public ArrayList<Product> readFile() {
        ArrayList<Product> productList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            Product product = new Product();
            while ((product = (Product) ois.readObject()) != null) {
                productList.add(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("Read File!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }
}
