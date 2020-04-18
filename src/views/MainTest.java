package views;

import controller.ProductController;
import controller.ProductFile;
import model.Product;
import repository.ProductRepoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductController productController = new ProductController();
        ProductFile productFile=new ProductFile();
        int choice;
        do {
            showChoice();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            selectMenu(productController, choice);
        } while (choice != 0);
    }

    public static void selectMenu(ProductController productController, int choice) {
        List<Product> productList=productController.showProductList();
        switch (choice) {
            case 1:
               // productList = productController.showProductList();
                for (Product product : productList) {
                    System.out.println(product.toString());
                }
                break;
            case 2:
                System.out.println("Add product: ");
                Product product1 = ProductRepoImpl.createProduct();
                productController.add(product1);
                break;
            case 3:
                System.out.println("Enter index for editing: ");
                int indexEdit = scanner.nextInt();
                System.out.println(productList.get(indexEdit).toString());
                productController.editProduct(indexEdit, ProductRepoImpl.createProduct());
                for (Product product : productList) {
                    System.out.println(product.toString());
                }
                break;
            case 4:
                System.out.println("Enter index for removing:");
                int indexRemove = scanner.nextInt();
                productController.removeProduct(indexRemove);
                break;
            case 5:
                System.out.println("Enter a product Name:  ");
                String name= scanner.nextLine();
                System.out.println(productController.findByName(name));
                break;
            case 6:
                System.out.println("Enter a product ID:  ");
                int id = scanner.nextInt();
                productController.findById(id);
                break;
            case 7:
                System.out.println("Arrange product list upPrice");
                productController.sortUp();
                break;
            case 8:
                System.out.println(" Arrange product list downPrice:");
                productController.sortDown();
                break;
            case 9:
                System.out.println("Storing Product Information");
                ProductFile productFile = new ProductFile();
                productFile.writeFile(productList);
                productList=productFile.readFile();
                for (Product product : productList) {
                    System.out.println(product.toString());
                }
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("You didn't make any choice");
        }
    }

    public static void showChoice() {
        System.out.println("1. Show all products");
        System.out.println("2. Add a new product");
        System.out.println("3. Edit a product");
        System.out.println("4. Remove a product");
        System.out.println("5. Find a product by name");
        System.out.println("6. Find a product by ID");
        System.out.println("7. Arrange product list upPrice");
        System.out.println("8. Arange product list downPrice");
        System.out.println("9. Storing Product Information");
        System.out.println("0. Exit");
    }
}
