package repository;

import model.Product;

import java.util.*;

public class ProductRepoImpl implements ProductRepo {
    public static ArrayList<Product> products = new ArrayList<>();
    static {
        products.add(new Product(01, "Iphone 11", "Apple", 30.0f, "Stocking", "Gold Color"));
        products.add(new Product(02, "Galaxy Note 7", "Samsung", 20.0f, "Stocking", "White Color"));
        products.add(new Product(03, "Nokia 8800", "Nokia", 10.0f, "Out of stock", "Black Color"));
        products.add(new Product(04, "Xiaomi A3", "Xiaomi", 5.0f, "Stocking", "Orange Color"));
        products.add(new Product(05, "Oppo F5", "Oppo", 15.0f, "Stocking", "Red Color"));
    }
    public static Product createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID Product: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Name Product: ");
        String name = scanner.nextLine();
        System.out.println("Enter Brand Product: ");
        String brand = scanner.nextLine();
        System.out.println("Enter Price Product: ");
        float price = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter Status Product: ");
        String status = scanner.nextLine();
        System.out.println("Enter Description Product: ");
        String description = scanner.nextLine();

        Product product = new Product(id, name, brand, price, status, description);

        return product;
    }

    @Override
    public List<Product> showProductList() {
        return products;
    }

    @Override
    public void add(Product product) {
        if (product != null) products.add(product);
    }

    @Override
    public void editProduct(int index, Product product) {
        if (index < 0 || index >= products.size()) {
            throw new ArrayIndexOutOfBoundsException("Index Out Of Bounds!");
        } else {
            products.set(index-1, product);
        }
    }

    @Override
    public void removeProduct(int index) {
        if (index < 0 || index >= products.size()) {
            throw new ArrayIndexOutOfBoundsException("Index Out Of Bounds!");
        } else {
            products.remove(index-1);
        }
    }

    @Override
    public String findByName(String name) {
        for (Product product : products) {
            String productName = product.getName();
            try {
                if (name.equals(productName)) {
                    return product.toString();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return "Don't have this Product!";
    }

    @Override
    public void findByID(int id) {
        for (Product product : products) {
            int productID = product.getId();
            try {
                if (productID == id) {
                    System.out.println(product.toString());
                }
            } catch (Exception e) {
                e.getMessage();
                System.out.println("Don't have this Product!");
            }

        }
    }

    @Override
    public ArrayList<Product> sortUp() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getPrice() > p2.getPrice()) {
                    return 1;
                } else if (p1.getPrice() == p2.getPrice()) {
                    return 0;
                } else return -1;
            }
        });
        return products;
    }

    @Override
    public ArrayList<Product> sortDown() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getPrice() > p2.getPrice()) {
                    return -1;
                } else if (p1.getPrice() == p2.getPrice()) {
                    return 0;
                } else return 1;
            }
        });
        return products;
    }
}
