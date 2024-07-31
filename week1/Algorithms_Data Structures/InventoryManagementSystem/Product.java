import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }
    public void updateProduct(String productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product not found!");
        }
    }
    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }
    public void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addProduct(new Product("P001", "Laptop", 5, 99999.99));
        ims.addProduct(new Product("P002", "Smartphone", 15, 49999.99));
        ims.addProduct(new Product("P003", "Tablet", 10, 79999.99));
      
        System.out.println("Inventory:");
        ims.displayProducts();

        ims.updateProduct("P002", 18, 45999.99);
        System.out.println("\nAfter updating product P002:");
        ims.displayProducts();

        ims.deleteProduct("P001");
        System.out.println("\nAfter deleting product P001:");
        ims.displayProducts();
    }
}